package com.fstn.service.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.jboss.resteasy.spi.UnhandledException;

/**
 * @author sza on 19/11/2015.
 */
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	// TODO modifier le handler
    @Override
    public Response toResponse(Exception e) {
        // For simplicity I am preparing error xml by hand.
		// Ideally we should create an ErrorResponse class to hold the error
		// info.
        Response response = null;

		if (e instanceof IllegalArgumentException || e.getCause() instanceof IllegalArgumentException) {
			Throwable safeE = extractThrowable(e, e instanceof IllegalArgumentException);
			response = (Response.status(Response.Status.BAD_REQUEST).entity(
					(new SupplierBadRequestWebServiceException(ExceptionMessage.BAD_REQUEST_EXCEPTION + ": "
							+ extractCastContentFromException(safeE, 0, 3), safeE))
							.getApiMessage()).build());
		}

        return response;
    }

	/**
	 * Extract throwable.
	 *
	 * @param e
	 *            the e
	 * @param condition
	 *            the condition
	 * @return the throwable
	 */
	private Throwable extractThrowable(Exception e, boolean condition) {
		Throwable safeE = null;
		if (condition) {
			safeE = e;
		} else {
			safeE = e.getCause();
		}
		return safeE;
	}

	/**
	 * Extract cast content from exception.
	 *
	 * @param safeE            the e
	 * @param start the start of capture
	 * @param end the end of capture
	 * @return the string
	 */
	private String extractCastContentFromException(Throwable safeE, int start, int end) {
		if (safeE != null && safeE.getMessage() != null && safeE.getMessage().split(":").length > start) {
			String result = "";
			for (int i = start; i <= end; i++) {
				if (safeE.getMessage().split(":").length > i) {
					result += safeE.getMessage().split(":")[i];
				}
			}
			return result.trim();
		} else {
			return "";
		}
	}
}