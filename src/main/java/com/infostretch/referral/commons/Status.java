package com.infostretch.referral.commons;

import java.io.Serializable;

/**
 * Status of REST service response.
 *
 * @author aneri.parikh
 */
public class Status implements Serializable {

  /** default. */
  private static final long serialVersionUID = 1L;

  /** The message. */
  private String message;

  /** The code. */
  private Integer code;

  /**
   * default status instance with code 0 & code specified false.
   */
  public Status() {
    this.code = 200;
  }

  /**
   * Creates instance with values as per mentioned and code 0 & codeSpecified false.
   *
   * @param value
   *          the value
   */
  public Status(final String value) {
    this();
    this.message = value;
  }

  /**
   * Creates instance with values & code as per mentioned and codeSpecified false.
   *
   * @param value
   *          the value
   * @param code
   *          the code
   */
  public Status(final String value, final Integer code) {
    super();
    this.message = value;
    this.code = code;
  }

  /**
   * Gets the code.
   *
   * @return the code
   */
  public Integer getCode() {
    return this.code;
  }

  /**
   * Gets the message.
   *
   * @return the message
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * Sets the code.
   *
   * @param code
   *          the code to set
   */
  public void setCode(final Integer code) {
    this.code = code;
  }

  /**
   * Sets the message.
   *
   * @param value
   *          the new message
   */
  public void setMessage(final String value) {
    this.message = value;
  }
}
