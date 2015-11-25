package com.fstn.service.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.fstn.service.message.RestApiMessage;

/**
 * 
 * @author sza
 *
 */
public class RestApiException extends WebApplicationException {

  private static final long serialVersionUID = 1L;

  public RestApiException() {
  }

  public RestApiException(RestApiMessage message, int status) {
    super(Response.status(status).entity(message).build());
  }

}
