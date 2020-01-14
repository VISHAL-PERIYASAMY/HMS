package global.coda.hms.config;

import org.glassfish.jersey.server.ResourceConfig;

import global.coda.hms.api.DoctorService;
import global.coda.hms.api.PatientService;
import global.coda.hms.exceptionmapper.BusinessExceptionMapper;
import global.coda.hms.exceptionmapper.SystemExceptionMapper;

/**
 * The Class JerseyConfig.
 *
 * @author Vishal
 */
public class JerseyConfig extends ResourceConfig {

	/**
	 * Jersey configuration.
	 */
	public JerseyConfig() {
		register(DoctorService.class);
		register(PatientService.class);
		register(BusinessExceptionMapper.class);
		register(SystemExceptionMapper.class);

	}
}
