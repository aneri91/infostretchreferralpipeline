/**
 *
 */
package com.infostretch.referral.commons;

import java.util.List;

/**
 * The Class SalesReferralResponseDTO.
 *
 * @author aneri.parikh
 */
public class SalesReferralResponseDTO {

  /** The status. */
  private Status status;

  /** The data. */
  private List<SalesReferralDetails> data;

  /**
   * Instantiates a new sales referral response dto.
   */
  public SalesReferralResponseDTO() {
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return this.status;
  }

  /**
   * Sets the status.
   *
   * @param status
   *          the status to set
   */
  public void setStatus(final Status status) {
    this.status = status;
  }

  /**
   * Gets the data.
   *
   * @return the data
   */
  public List<SalesReferralDetails> getData() {
    return this.data;
  }

  /**
   * Sets the data.
   *
   * @param data
   *          the data to set
   */
  public void setData(final List<SalesReferralDetails> data) {
    this.data = data;
  }

}
