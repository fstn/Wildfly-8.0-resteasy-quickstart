package com.fstn.service.exception;

import com.fstn.service.message.RestApiMessage;
import com.fstn.service.message.RestApiMessageCode;
import com.fstn.service.message.RestApiMessageLevel;


/**
 * HTTP 400 (BadRequestException)
 * 
 * @author sza
 *
 */
public class EmptyRequestException extends RestApiException {

  private static final long serialVersionUID = 1L;

  /**
   * Create a HTTP 400 (BadRequestException) exception.
   * 
   * @param message
   *          the String that is the entity of the 400 response.
   */
  public EmptyRequestException(String message,
      String detail) {
    super(new RestApiMessage(RestApiMessageCode.EMPTY_REQUEST.getValue(),
        RestApiMessageLevel.ERROR.toString(), message, detail),400);
  }
}
