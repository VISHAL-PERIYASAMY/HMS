package global.coda.hms.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.delegate.PatientOperationDelegate;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;
import global.coda.hms.model.ResponseBody;

/**
 *
 *
 * @author Vishal
 */
@Path("/patient")
public class PatientService {

	private PatientOperationDelegate patientOperationDelegate = new PatientOperationDelegate();

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Patient> createPatient(Patient patient) throws BusinessException, SystemException {
		patientOperationDelegate.addPatient(patient);
		ResponseBody<Patient> response = new ResponseBody<Patient>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(patient);
		return response;
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<String> deletePatient(Patient patient) throws BusinessException, SystemException {
		patientOperationDelegate.deletePatient(patient);
		ResponseBody<String> response = new ResponseBody<String>();
		response.setStatus(HttpStatusConstant.OK_NO_CONTENT);
		response.setMessage(ApplicationConstant.USER_DELETED);
		return response;
	}

	/**
	 * Read patient by id.
	 *
	 * @param id the id
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GET
	@Path("/read/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Patient> readPatientById(@PathParam("param") int id) throws BusinessException, SystemException {
		ResponseBody<Patient> response = new ResponseBody<Patient>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(patientOperationDelegate.readPatientById(id));
		return response;
	}

	/**
	 * Read all patient.
	 *
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<List<Patient>> readAllPatient() throws BusinessException, SystemException {
		ResponseBody<List<Patient>> response = new ResponseBody<List<Patient>>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(patientOperationDelegate.readAllPatient());
		return response;
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Patient> updatePatient(Patient patient) throws BusinessException, SystemException {
		patientOperationDelegate.updatePatient(patient);
		ResponseBody<Patient> response = new ResponseBody<Patient>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(patient);
		return response;
	}

}
