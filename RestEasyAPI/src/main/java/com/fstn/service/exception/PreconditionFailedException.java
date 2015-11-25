package com.fstn.service.exception;

import com.fstn.service.message.RestApiMessage;

/**
 * HTTP 412 (PreconditionFailed)
 * @author sza
 *
 */
public abstract class PreconditionFailedException extends RestApiException {

  private static final long serialVersionUID = 1L;
  /** 
   * Create a HTTP 412 (PreconditionFailed) exception.
   * 
   * @param restApiMessage
   */
  public PreconditionFailedException(RestApiMessage restApiMessage) {
    super(restApiMessage, 412);
  }

}
