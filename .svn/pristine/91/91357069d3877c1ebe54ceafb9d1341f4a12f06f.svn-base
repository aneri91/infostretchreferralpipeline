package com.infostretch.referral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.infostretch.referral.entity.Role;
import com.infostretch.referral.exception.RESTServiceException;

/**
 * role dao implementation class.
 *
 * @author pratik.oza
 */
@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {
  /** The entity manager. */
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Instantiates a new role dao impl.
   */
  // default constructor
  public RoleDaoImpl() {
    super(Role.class);
  }

  /**
   * get role table by role name.
   *
   * @param roleName
   *          the role name
   * @return role
   * @throws RESTServiceException
   *           the REST service exception
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Role> getRoleByRoleName(final String roleName) throws RESTServiceException {
    final Query query = this.entityManager
        .createQuery(" SELECT r FROM Role r WHERE r.roleName=:roleName ");
    query.setParameter("roleName", roleName);
    final List<Role> roleList = query.getResultList();
    return roleList;
  }
}
