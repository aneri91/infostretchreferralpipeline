package com.infostretch.referral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.infostretch.referral.commons.EmployeeReferralDetails;
import com.infostretch.referral.entity.EmployeeReferral;
import com.infostretch.referral.exception.RESTServiceException;

/**
 * The Class EmployeeReferralDaoImpl.
 *
 * Employee Referral Information<br/>
 *
 * @author aneri.parikh
 */
@Repository("employeeReferralDao")
public class EmployeeReferralDaoImpl extends GenericDaoImpl<EmployeeReferral> implements
    EmployeeReferralDao {
  /** The entity manager. */
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Instantiates a new employee referral dao impl.
   */
  public EmployeeReferralDaoImpl() {
    super(EmployeeReferral.class);
  }

  /**
   * Gets the Employee referral details.
   *
   * @return the employee referral details
   * @throws RESTServiceException
   *           the REST service exception
   * @see com.infostretch.referral.dao.EmployeeReferralDao#getEmployeeReferralDetails()
   */

  @SuppressWarnings("unchecked")
  @Override
  public List<EmployeeReferralDetails> getEmployeeReferralDetails() throws RESTServiceException {
    final Query query = this.entityManager
        .createQuery("SELECT new com.infostretch.referral.commons.EmployeeReferralDetails"
            + "(e.id,e.candidateName,e.isContact,e.isViable,"
            + "e.isClose) FROM EmployeeReferral e");
    final List<EmployeeReferralDetails> result = query.getResultList();
    return result;
  }

  /**
   * @see com.infostretch.referral.dao.EmployeeReferralDao#getEmployeeReferralDetailsByCreatedBy(java
   *      .lang.Integer)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<EmployeeReferralDetails> getEmployeeReferralDetailsByCreatedBy(final Integer createdBy)
      throws RESTServiceException {
    // Query
    final Query query = this.entityManager
        .createQuery("SELECT new com.infostretch.referral.commons.EmployeeReferralDetails"
            + "(e.id,e.candidateName,e.isContact,e.isViable,"
            + "e.isClose) FROM EmployeeReferral e WHERE e.createdBy.id=:createdBy");
    query.setParameter("createdBy", createdBy);
    // Get the List of Sales Referral by Role
    final List<EmployeeReferralDetails> result = query.getResultList();
    return result;
  }
}
