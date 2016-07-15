/**
 */
package com.infostretch.referral.commons;

/**
 * The Class UpdateEmployeeStatusRequestDTO.
 *
 * @author aneri.parikh
 */
public class UpdateEmployeeStatusRequestDTO {

  /** The is close. */
  private Boolean isClose;

  /** The is contact. */
  private Boolean isContact;

  /** The is viable. */
  private Boolean isViable;

  /** The candidate id. */
  private Integer candidateId;

  /** The updated by. */
  private Integer updatedBy;

  /**
   * Instantiates a new update employee status request dto.
   */
  public UpdateEmployeeStatusRequestDTO() {
  }

  /**
   * Gets the checks if is close.
   *
   * @return the isClose
   */
  public Boolean getIsClose() {
    return this.isClose;
  }

  /**
   * Sets the checks if is close.
   *
   * @param isClose
   *          the isClose to set
   */
  public void setIsClose(final Boolean isClose) {
    this.isClose = isClose;
  }

  /**
   * Gets the checks if is contact.
   *
   * @return the isContact
   */
  public Boolean getIsContact() {
    return this.isContact;
  }

  /**
   * Sets the checks if is contact.
   *
   * @param isContact
   *          the isContact to set
   */
  public void setIsContact(final Boolean isContact) {
    this.isContact = isContact;
  }

  /**
   * Gets the checks if is viable.
   *
   * @return the isViable
   */
  public Boolean getIsViable() {
    return this.isViable;
  }

  /**
   * Sets the checks if is viable.
   *
   * @param isViable
   *          the isViable to set
   */
  public void setIsViable(final Boolean isViable) {
    this.isViable = isViable;
  }

  /**
   * Gets the candidate id.
   *
   * @return the candidateId
   */
  public Integer getCandidateId() {
    return this.candidateId;
  }

  /**
   * Sets the candidate id.
   *
   * @param candidateId
   *          the candidateId to set
   */
  public void setCandidateId(final Integer candidateId) {
    this.candidateId = candidateId;
  }

  /**
   * Gets the updated by.
   *
   * @return the updatedBy
   */
  public Integer getUpdatedBy() {
    return this.updatedBy;
  }

  /**
   * Sets the updated by.
   *
   * @param updatedBy
   *          the updatedBy to set
   */
  public void setUpdatedBy(final Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

}
