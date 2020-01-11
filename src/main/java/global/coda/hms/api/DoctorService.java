package global.coda.hms.api;

import java.util.List;
import java.util.Map;

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
import global.coda.hms.delegate.DoctorOperationDelegate;
import global.coda.hms.delegate.RecordOperationDelegate;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.RecordDetails;
import global.coda.hms.model.ResponseBody;

/**
 *
 * @author Vishal
 */
@Path("/doctor")
public class DoctorService {

	private DoctorOperationDelegate doctorOperationDelegate = new DoctorOperationDelegate();

	/**
	 * Create the doctor.
	 *
	 * @param doctor the doctor
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Doctor> createDoctor(Doctor doctor) throws BusinessException, SystemException {

		doctorOperationDelegate.addDoctor(doctor);
		ResponseBody<Doctor> response = new ResponseBody<Doctor>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctor);
		return response;
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctor the doctor
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<String> deleteDoctor(Doctor doctor) throws BusinessException, SystemException {
		doctorOperationDelegate.deleteDoctor(doctor);
		ResponseBody<String> response = new ResponseBody<String>();
		response.setStatus(HttpStatusConstant.OK_NO_CONTENT);
		response.setMessage(ApplicationConstant.USER_DELETED);
		return response;
	}

	/**
	 * Read doctor by id.
	 *
	 * @param id the id
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GET
	@Path("/read/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Doctor> readDoctorById(@PathParam("param") int id) throws BusinessException, SystemException {
		ResponseBody<Doctor> response = new ResponseBody<Doctor>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctorOperationDelegate.readDoctorById(id));
		return response;
	}

	/**
	 * Read all the doctor.
	 *
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<List<Doctor>> readAllDoctor() throws BusinessException, SystemException {
		ResponseBody<List<Doctor>> response = new ResponseBody<List<Doctor>>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctorOperationDelegate.readAllDoctor());
		return response;
	}

	/**
	 * Update the doctor.
	 *
	 * @param doctor the doctor
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Doctor> updateDoctor(Doctor doctor) throws BusinessException, SystemException {
		doctorOperationDelegate.updateDoctor(doctor);
		ResponseBody<Doctor> response = new ResponseBody<Doctor>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctor);
		return response;
	}

	/**
	 * Read record by id.
	 *
	 * @param id the id
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GET
	@Path("/{param}/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Map<String, List<RecordDetails>>> readRecordById(@PathParam("param") int id)
			throws BusinessException, SystemException {
		RecordOperationDelegate recordOperationDelegate = new RecordOperationDelegate();
		ResponseBody<Map<String, List<RecordDetails>>> response = new ResponseBody<Map<String, List<RecordDetails>>>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(recordOperationDelegate.readRecordById(id));
		return response;
	}

	/**
	 * Read all record.
	 *
	 * @param id the id
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GET
	@Path("/getpatient")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody<Map<String, List<RecordDetails>>> readAllRecord(@PathParam("param") int id)
			throws BusinessException, SystemException {
		RecordOperationDelegate recordOperationDelegate = new RecordOperationDelegate();
		ResponseBody<Map<String, List<RecordDetails>>> response = new ResponseBody<Map<String, List<RecordDetails>>>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(recordOperationDelegate.readAllRecord());
		return response;
	}

}
