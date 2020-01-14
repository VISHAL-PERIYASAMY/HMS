package global.coda.hms.delegate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.PatientCrudHelper;
import global.coda.hms.model.Patient;

/**
 *
 * @author Vishal
 */
public class PatientOperationDelegate {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(PatientOperationDelegate.class);

	/** The patient crud helper. */
	private PatientCrudHelper patientCrudHelper = new PatientCrudHelper();

	/**
	 * Adds the patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean addPatient(Patient patient) throws BusinessException, SystemException {
		logger.entry(patient);
		logger.traceExit();
		return patientCrudHelper.addPatient(patient);
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean deletePatient(Patient patient) throws BusinessException, SystemException {
		logger.entry(patient);
		logger.traceExit();
		return patientCrudHelper.deletePatient(patient);
	}

	/**
	 * Read all patient.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public List<Patient> readAllPatient() throws BusinessException, SystemException {
		logger.traceEntry();
		List<Patient> patientList = patientCrudHelper.readAllPatient();
		logger.traceExit(patientList);
		return patientList;
	}

	/**
	 * Read patient by id.
	 *
	 * @param id the id
	 * @return the patient
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public Patient readPatientById(int id) throws BusinessException, SystemException {
		logger.entry(id);
		Patient patient = patientCrudHelper.readPatientById(id);
		logger.traceExit(patient);
		return patient;
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean updatePatient(Patient patient) throws BusinessException, SystemException {
		logger.entry(patient);
		logger.traceExit();
		return patientCrudHelper.upddatePatient(patient);
	}

}
