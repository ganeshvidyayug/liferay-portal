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

package com.liferay.portal.lock.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.lock.model.Lock;
import com.liferay.portal.service.ServiceContext;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lock service. This utility wraps {@link com.liferay.portal.lock.service.persistence.impl.LockPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LockPersistence
 * @see com.liferay.portal.lock.service.persistence.impl.LockPersistenceImpl
 * @generated
 */
@ProviderType
public class LockUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Lock lock) {
		getPersistence().clearCache(lock);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lock> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lock> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lock> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Lock> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Lock update(Lock lock) {
		return getPersistence().update(lock);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Lock update(Lock lock, ServiceContext serviceContext) {
		return getPersistence().update(lock, serviceContext);
	}

	/**
	* Returns all the locks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByUuid(
		java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the locks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @return the range of matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the locks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first lock in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first lock in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last lock in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last lock in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the locks before and after the current lock in the ordered set where uuid = &#63;.
	*
	* @param lockId the primary key of the current lock
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a lock with the primary key could not be found
	*/
	public static com.liferay.portal.lock.model.Lock[] findByUuid_PrevAndNext(
		long lockId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence()
				   .findByUuid_PrevAndNext(lockId, uuid, orderByComparator);
	}

	/**
	* Removes all the locks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of locks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching locks
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the locks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the locks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @return the range of matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the locks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first lock in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first lock in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last lock in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last lock in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the locks before and after the current lock in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param lockId the primary key of the current lock
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a lock with the primary key could not be found
	*/
	public static com.liferay.portal.lock.model.Lock[] findByUuid_C_PrevAndNext(
		long lockId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(lockId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the locks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of locks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching locks
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the locks where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date
	* @return the matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByLtExpirationDate(
		java.util.Date expirationDate) {
		return getPersistence().findByLtExpirationDate(expirationDate);
	}

	/**
	* Returns a range of all the locks where expirationDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expirationDate the expiration date
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @return the range of matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByLtExpirationDate(
		java.util.Date expirationDate, int start, int end) {
		return getPersistence()
				   .findByLtExpirationDate(expirationDate, start, end);
	}

	/**
	* Returns an ordered range of all the locks where expirationDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expirationDate the expiration date
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findByLtExpirationDate(
		java.util.Date expirationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence()
				   .findByLtExpirationDate(expirationDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first lock in the ordered set where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByLtExpirationDate_First(
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence()
				   .findByLtExpirationDate_First(expirationDate,
			orderByComparator);
	}

	/**
	* Returns the first lock in the ordered set where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByLtExpirationDate_First(
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence()
				   .fetchByLtExpirationDate_First(expirationDate,
			orderByComparator);
	}

	/**
	* Returns the last lock in the ordered set where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByLtExpirationDate_Last(
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence()
				   .findByLtExpirationDate_Last(expirationDate,
			orderByComparator);
	}

	/**
	* Returns the last lock in the ordered set where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByLtExpirationDate_Last(
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence()
				   .fetchByLtExpirationDate_Last(expirationDate,
			orderByComparator);
	}

	/**
	* Returns the locks before and after the current lock in the ordered set where expirationDate &lt; &#63;.
	*
	* @param lockId the primary key of the current lock
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a lock with the primary key could not be found
	*/
	public static com.liferay.portal.lock.model.Lock[] findByLtExpirationDate_PrevAndNext(
		long lockId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence()
				   .findByLtExpirationDate_PrevAndNext(lockId, expirationDate,
			orderByComparator);
	}

	/**
	* Removes all the locks where expirationDate &lt; &#63; from the database.
	*
	* @param expirationDate the expiration date
	*/
	public static void removeByLtExpirationDate(java.util.Date expirationDate) {
		getPersistence().removeByLtExpirationDate(expirationDate);
	}

	/**
	* Returns the number of locks where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date
	* @return the number of matching locks
	*/
	public static int countByLtExpirationDate(java.util.Date expirationDate) {
		return getPersistence().countByLtExpirationDate(expirationDate);
	}

	/**
	* Returns the lock where className = &#63; and key = &#63; or throws a {@link com.liferay.portal.lock.NoSuchLockException} if it could not be found.
	*
	* @param className the class name
	* @param key the key
	* @return the matching lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByC_K(
		java.lang.String className, java.lang.String key)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence().findByC_K(className, key);
	}

	/**
	* Returns the lock where className = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param key the key
	* @return the matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByC_K(
		java.lang.String className, java.lang.String key) {
		return getPersistence().fetchByC_K(className, key);
	}

	/**
	* Returns the lock where className = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching lock, or <code>null</code> if a matching lock could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByC_K(
		java.lang.String className, java.lang.String key,
		boolean retrieveFromCache) {
		return getPersistence().fetchByC_K(className, key, retrieveFromCache);
	}

	/**
	* Removes the lock where className = &#63; and key = &#63; from the database.
	*
	* @param className the class name
	* @param key the key
	* @return the lock that was removed
	*/
	public static com.liferay.portal.lock.model.Lock removeByC_K(
		java.lang.String className, java.lang.String key)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence().removeByC_K(className, key);
	}

	/**
	* Returns the number of locks where className = &#63; and key = &#63;.
	*
	* @param className the class name
	* @param key the key
	* @return the number of matching locks
	*/
	public static int countByC_K(java.lang.String className,
		java.lang.String key) {
		return getPersistence().countByC_K(className, key);
	}

	/**
	* Caches the lock in the entity cache if it is enabled.
	*
	* @param lock the lock
	*/
	public static void cacheResult(com.liferay.portal.lock.model.Lock lock) {
		getPersistence().cacheResult(lock);
	}

	/**
	* Caches the locks in the entity cache if it is enabled.
	*
	* @param locks the locks
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.lock.model.Lock> locks) {
		getPersistence().cacheResult(locks);
	}

	/**
	* Creates a new lock with the primary key. Does not add the lock to the database.
	*
	* @param lockId the primary key for the new lock
	* @return the new lock
	*/
	public static com.liferay.portal.lock.model.Lock create(long lockId) {
		return getPersistence().create(lockId);
	}

	/**
	* Removes the lock with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lockId the primary key of the lock
	* @return the lock that was removed
	* @throws com.liferay.portal.lock.NoSuchLockException if a lock with the primary key could not be found
	*/
	public static com.liferay.portal.lock.model.Lock remove(long lockId)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence().remove(lockId);
	}

	public static com.liferay.portal.lock.model.Lock updateImpl(
		com.liferay.portal.lock.model.Lock lock) {
		return getPersistence().updateImpl(lock);
	}

	/**
	* Returns the lock with the primary key or throws a {@link com.liferay.portal.lock.NoSuchLockException} if it could not be found.
	*
	* @param lockId the primary key of the lock
	* @return the lock
	* @throws com.liferay.portal.lock.NoSuchLockException if a lock with the primary key could not be found
	*/
	public static com.liferay.portal.lock.model.Lock findByPrimaryKey(
		long lockId)
		throws com.liferay.portal.lock.exception.NoSuchLockException {
		return getPersistence().findByPrimaryKey(lockId);
	}

	/**
	* Returns the lock with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lockId the primary key of the lock
	* @return the lock, or <code>null</code> if a lock with the primary key could not be found
	*/
	public static com.liferay.portal.lock.model.Lock fetchByPrimaryKey(
		long lockId) {
		return getPersistence().fetchByPrimaryKey(lockId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.portal.lock.model.Lock> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the locks.
	*
	* @return the locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the locks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @return the range of locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the locks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.lock.model.impl.LockModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locks
	* @param end the upper bound of the range of locks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of locks
	*/
	public static java.util.List<com.liferay.portal.lock.model.Lock> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.lock.model.Lock> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the locks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of locks.
	*
	* @return the number of locks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LockPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(LockPersistence persistence) {
	}

	private static ServiceTracker<LockPersistence, LockPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LockUtil.class);

		_serviceTracker = new ServiceTracker<LockPersistence, LockPersistence>(bundle.getBundleContext(),
				LockPersistence.class, null);

		_serviceTracker.open();
	}
}