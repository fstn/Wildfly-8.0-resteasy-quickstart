package com.fstn.service.exception;

import com.fstn.service.message.RestApiMessage;
import com.fstn.service.message.RestApiMessageCode;
import com.fstn.service.message.RestApiMessageLevel;

/**
 * HTTP 412 (PreconditionFailed)
 * 
 * @author sza
 *
 */
public class MalFormedObjectException extends PreconditionFailedException {

  private static final long serialVersionUID = 1L;

  /**
   * Create a HTTP 412 (PreconditionFailed) exception.
   * 
   * @param message
   *          the String that is the entity of the 400 response.
   */
  public MalFormedObjectException(String message, String detail) {
    super(new RestApiMessage(RestApiMessageCode.MALFORMED_OBJECT.getValue(),
        RestApiMessageLevel.ERROR.toString(), message, detail));
  }
}
