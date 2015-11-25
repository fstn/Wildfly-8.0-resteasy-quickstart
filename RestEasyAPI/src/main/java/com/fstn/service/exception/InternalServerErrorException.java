package com.fstn.service.exception;

import com.fstn.service.message.RestApiMessage;
import com.fstn.service.message.RestApiMessageCode;
import com.fstn.service.message.RestApiMessageLevel;

/**
 * HTTP 500 (InternalServerError)
 * 
 * @author sza
 *
 */
public class InternalServerErrorException extends RestApiException {

  private static final long serialVersionUID = 1L;

  /**
   * Create a HTTP 500 (InternalServerError) exception.
   * 
   * @param message
   *          the String that is the entity of the 400 response.
   */
  public InternalServerErrorException(String message, String detail) {
    super(new RestApiMessage(RestApiMessageCode.INTERNAL_ERROR.getValue(),
        RestApiMessageLevel.ERROR.toString(), message, detail), 500);
  }
}
