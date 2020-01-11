package global.coda.hms.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.exception.SystemException;

/**
 *
 * @author Vishal
 */
@Provider
public class SystemExceptionMapper implements ExceptionMapper<SystemException> {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(SystemExceptionMapper.class);

	/**
	 * To response.
	 *
	 * @param error the error
	 * @return the response
	 */
	@Override
	public Response toResponse(SystemException error) {
		logger.error(error.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).type(MediaType.TEXT_PLAIN)
				.entity(ApplicationConstant.SERVER_ERROR).build();
	}
}
