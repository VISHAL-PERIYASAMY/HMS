package global.coda.hms.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.exception.BusinessException;

/**
 *
 * @author Vishal
 */
@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

	/**
	 * To response.
	 *
	 * @param error the error
	 * @return the response
	 */
	@Override
	public Response toResponse(BusinessException error) {

		return Response.status(HttpStatusConstant.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity(error.getMessage())
				.build();
	}
}
