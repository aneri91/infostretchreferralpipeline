package com.infostretch.referral.exception;

import com.infostretch.referral.commons.Status;

/**
 * The Class RESTServiceException.
 */
public class RESTServiceException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** status information for rest response. */
  private final Status status;

  /**
   * Instantiates a new rest service exception.
   *
   * @param value
   *          the value
   * @param code
   *          the code
   * @param throwable
   *          the throwable
   */
  public RESTServiceException(final String value, final Integer code, final Throwable throwable) {
    super(value, throwable);
    this.status = new Status(value, code);
  }

  /**
   * Instantiates a new rest service exception.
   *
   * @param value
   *          the value
   * @param throwable
   *          the throwable
   */
  public RESTServiceException(final String value, final Throwable throwable) {
    super(value, throwable);
    this.status = new Status(value);
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return this.status;
  }
}
