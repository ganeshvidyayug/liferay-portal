/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.tools.rest.builder.internal.freemarker.tool.java.parser;

import com.liferay.portal.kernel.util.CamelCaseUtil;
import com.liferay.portal.tools.rest.builder.internal.freemarker.tool.java.JavaMethodParameter;
import com.liferay.portal.tools.rest.builder.internal.freemarker.tool.java.JavaMethodSignature;
import com.liferay.portal.tools.rest.builder.internal.freemarker.tool.java.parser.util.OpenAPIParserUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.yaml.config.ConfigYAML;
import com.liferay.portal.vulcan.yaml.openapi.Components;
import com.liferay.portal.vulcan.yaml.openapi.OpenAPIYAML;
import com.liferay.portal.vulcan.yaml.openapi.Operation;
import com.liferay.portal.vulcan.yaml.openapi.Parameter;
import com.liferay.portal.vulcan.yaml.openapi.Schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Peter Shin
 */
public class GraphQLOpenAPIParser {

	public static List<JavaMethodSignature> getJavaMethodSignatures(
		ConfigYAML configYAML, String graphQLType, OpenAPIYAML openAPIYAML) {

		List<JavaMethodSignature> javaMethodSignatures = new ArrayList<>();

		Components components = openAPIYAML.getComponents();

		Map<String, Schema> schemas = components.getSchemas();

		for (String schemaName : schemas.keySet()) {
			javaMethodSignatures.addAll(
				_getJavaMethodSignatures(
					configYAML, graphQLType, openAPIYAML, schemaName));
		}

		return javaMethodSignatures;
	}

	public static String getMethodAnnotations(
		JavaMethodSignature javaMethodSignature) {

		Set<String> methodAnnotations = new TreeSet<>();

		methodAnnotations.add("@GraphQLInvokeDetached");

		String httpMethod = OpenAPIParserUtil.getHTTPMethod(
			javaMethodSignature.getOperation());

		if (Objects.equals(httpMethod, "get") ||
			Objects.equals(httpMethod, "post")) {

			methodAnnotations.add("@GraphQLField");
		}

		return OpenAPIParserUtil.merge(methodAnnotations, '\n');
	}

	public static String getParameters(
		List<JavaMethodParameter> javaMethodParameters, Operation operation,
		boolean annotation) {

		StringBuilder sb = new StringBuilder();

		for (JavaMethodParameter javaMethodParameter : javaMethodParameters) {
			String parameterAnnotation = null;

			if (annotation) {
				parameterAnnotation = _getParameterAnnotation(
					javaMethodParameter, operation);
			}

			String parameter = OpenAPIParserUtil.getParameter(
				javaMethodParameter, parameterAnnotation);

			sb.append(parameter);

			sb.append(',');
		}

		if (sb.length() > 0) {
			sb.setLength(sb.length() - 1);
		}

		return sb.toString();
	}

	private static List<JavaMethodParameter> _getJavaMethodParameters(
		JavaMethodSignature resourceJavaMethodSignature) {

		List<JavaMethodParameter> javaMethodParameters = new ArrayList<>();

		for (JavaMethodParameter javaMethodParameter :
				resourceJavaMethodSignature.getJavaMethodParameters()) {

			String parameterType = javaMethodParameter.getParameterType();

			if (Objects.equals(parameterType, Pagination.class.getName())) {
				javaMethodParameters.add(
					new JavaMethodParameter(
						"pageSize", Integer.class.getName()));

				javaMethodParameters.add(
					new JavaMethodParameter("page", Integer.class.getName()));
			}
			else {
				javaMethodParameters.add(javaMethodParameter);
			}
		}

		return javaMethodParameters;
	}

	private static List<JavaMethodSignature> _getJavaMethodSignatures(
		ConfigYAML configYAML, String graphQLType, OpenAPIYAML openAPIYAML,
		String schemaName) {

		List<JavaMethodSignature> javaMethodSignatures = new ArrayList<>();

		List<JavaMethodSignature> resourceJavaMethodSignatures =
			ResourceOpenAPIParser.getJavaMethodSignatures(
				configYAML, openAPIYAML, schemaName);

		for (JavaMethodSignature resourceJavaMethodSignature :
				resourceJavaMethodSignatures) {

			Operation operation = resourceJavaMethodSignature.getOperation();

			if (!_isGraphQLMethod(graphQLType, operation)) {
				continue;
			}

			String returnType = resourceJavaMethodSignature.getReturnType();

			if (returnType.startsWith(Page.class.getName() + "<")) {
				String pageClassName = Page.class.getName();

				String className = returnType.substring(
					pageClassName.length() + 1, returnType.length() - 1);

				StringBuilder sb = new StringBuilder();

				sb.append(Collection.class.getName());
				sb.append("<");
				sb.append(className);
				sb.append(">");

				returnType = sb.toString();
			}

			List<JavaMethodParameter> javaMethodParameters =
				_getJavaMethodParameters(resourceJavaMethodSignature);

			javaMethodSignatures.add(
				new JavaMethodSignature(
					resourceJavaMethodSignature.getPath(),
					resourceJavaMethodSignature.getPathItem(), operation,
					resourceJavaMethodSignature.getSchemaName(),
					javaMethodParameters,
					resourceJavaMethodSignature.getMethodName(), returnType));
		}

		return javaMethodSignatures;
	}

	private static String _getParameterAnnotation(
		JavaMethodParameter javaMethodParameter, Operation operation) {

		for (Parameter parameter : operation.getParameters()) {
			String parameterName = CamelCaseUtil.toCamelCase(
				parameter.getName());

			if (!Objects.equals(
					parameterName, javaMethodParameter.getParameterName())) {

				continue;
			}

			Schema schema = parameter.getSchema();

			if (schema.getType() != null) {
				StringBuilder sb = new StringBuilder();

				sb.append("@GraphQLName(\"");
				sb.append(parameter.getName());
				sb.append("\")");

				return sb.toString();
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append("@GraphQLName(\"");

		String parameterType = javaMethodParameter.getParameterType();

		if (parameterType.lastIndexOf('.') != -1) {
			parameterType = parameterType.substring(
				parameterType.lastIndexOf(".") + 1);
		}

		sb.append(parameterType);

		sb.append("\")");

		return sb.toString();
	}

	private static boolean _isGraphQLMethod(
		String graphQLType, Operation operation) {

		String httpMethod = OpenAPIParserUtil.getHTTPMethod(operation);

		if (Objects.equals(graphQLType, "mutation") &&
			!Objects.equals(httpMethod, "get")) {

			return true;
		}

		if (Objects.equals(graphQLType, "query") &&
			Objects.equals(httpMethod, "get")) {

			return true;
		}

		return false;
	}

}