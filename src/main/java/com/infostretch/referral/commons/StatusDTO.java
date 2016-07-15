package com.infostretch.referral.commons;

/**
 * Delivery Status Status Update DTO for delivery service.
 *
 * @author aneri.parikh
 */
public class StatusDTO {

  /** The status. */
  private Status status;

  /**
   * Construct default constructor.
   */
  public StatusDTO() {
  }

  /**
   * Instantiates a new status dto.
   *
   * @param code
   *          the code
   * @param message
   *          the message
   */
  public StatusDTO(final Integer code, final String message) {
    this.status = new Status(message, code);
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

}
