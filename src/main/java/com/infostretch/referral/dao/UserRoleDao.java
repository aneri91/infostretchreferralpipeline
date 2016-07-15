package com.infostretch.referral.dao;

import com.infostretch.referral.entity.UserRoleMapping;
import com.infostretch.referral.exception.RESTServiceException;

/**
 * The Interface UserRoleDao.
 */
public interface UserRoleDao extends GenericDao<UserRoleMapping> {
  /**
   * Gets the role by user id.
   *
   * @param userId
   *          the user id
   * @return the role by user id
   * @throws RESTServiceException
   *           the REST service exception
   */
  String getRoleByUserId(Integer userId) throws RESTServiceException;
}
