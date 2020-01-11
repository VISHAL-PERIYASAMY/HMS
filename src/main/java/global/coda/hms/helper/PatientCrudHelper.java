package global.coda.hms.helper;

import java.sql.SQLException;
import java.util.List;

import global.coda.hms.dao.PatientDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.PatientNotFoundException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exception.UserNameAlreadyExistException;
import global.coda.hms.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientCrudHelper.
 *
 * @author Vishal
 */
/**
 * The Class PatientCrudHelper.
 */
public class PatientCrudHelper {

	/** The patient dao. */
	private PatientDao patientDao = new PatientDao();

	/**
	 * Adds the patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public boolean addPatient(Patient patient) throws BusinessException, SystemException {
		try {
			return patientDao.addPatientDao(patient);
		} catch (UserNameAlreadyExistException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public boolean deletePatient(Patient patient) throws BusinessException, SystemException {
		try {
			return patientDao.deletePatientDao(patient.getUserId());
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read all patient.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public List<Patient> readAllPatient() throws BusinessException, SystemException {
		try {
			return patientDao.readAllPatientDao();
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read patient by id.
	 *
	 * @param id the id
	 * @return the patient
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public Patient readPatientById(int id) throws BusinessException, SystemException {
		try {
			return patientDao.readPatientByIdDao(id);
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Upddate patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public boolean upddatePatient(Patient patient) throws BusinessException, SystemException {
		try {
			return patientDao.updatePatientDao(patient);
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

}
