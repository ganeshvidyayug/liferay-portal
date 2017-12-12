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

package com.liferay.layout.page.template.service.permission;

import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 * @deprecated As of 1.0.0, with no direct replacement
 */
@Component(
	property = {"model.class.name=com.liferay.layout.page.template.model.LayoutPageTemplateEntry"},
	service = BaseModelPermissionChecker.class
)
@Deprecated
public class LayoutPageTemplateEntryPermission
	implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker,
			LayoutPageTemplateEntry layoutPageTemplateEntry, String actionId)
		throws PortalException {

		_layoutPageTemplateEntryModelResourcePermission.check(
			permissionChecker, layoutPageTemplateEntry, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long layoutPageTemplateEntryId,
			String actionId)
		throws PortalException {

		_layoutPageTemplateEntryModelResourcePermission.check(
			permissionChecker, layoutPageTemplateEntryId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker,
			LayoutPageTemplateEntry layoutPageTemplateEntry, String actionId)
		throws PortalException {

		return _layoutPageTemplateEntryModelResourcePermission.contains(
			permissionChecker, layoutPageTemplateEntry, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long layoutPageTemplateEntryId,
			String actionId)
		throws PortalException {

		return _layoutPageTemplateEntryModelResourcePermission.contains(
			permissionChecker, layoutPageTemplateEntryId, actionId);
	}

	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		_layoutPageTemplateEntryModelResourcePermission.check(
			permissionChecker, primaryKey, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.layout.page.template.model.LayoutPageTemplateCollection)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<LayoutPageTemplateEntry>
			modelResourcePermission) {

		_layoutPageTemplateEntryModelResourcePermission =
			modelResourcePermission;
	}

	private static ModelResourcePermission<LayoutPageTemplateEntry>
		_layoutPageTemplateEntryModelResourcePermission;

}