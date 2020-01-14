package global.coda.hms.helper;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.constant.NumericConstants;
import global.coda.hms.dao.PatientDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exception.UserNameAlreadyExistException;
import global.coda.hms.model.Patient;

/**
 * The Class PatientCrudHelper.
 *
 * @author Vishal
 */

public class PatientCrudHelper {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(PatientCrudHelper.class);

	/** The patient dao. */
	private PatientDao patientDao = new PatientDao();

	/**
	 * Adds the patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean addPatient(Patient patient) throws BusinessException, SystemException {
		try {
			logger.entry(patient);
			logger.traceExit();
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
	 * @throws SystemException   the system exception
	 */
	public boolean deletePatient(Patient patient) throws BusinessException, SystemException {
		try {
			logger.entry(patient);
			logger.traceExit();
			boolean result = patientDao.deletePatientDao(patient.getUserId());
			if (!result) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			return result;
		} catch (BusinessException error) {
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
	 * @throws SystemException   the system exception
	 */
	public List<Patient> readAllPatient() throws BusinessException, SystemException {
		try {
			logger.traceEntry();
			List<Patient> patient = patientDao.readAllPatientDao();
			if (patient.size() == NumericConstants.ZERO) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			logger.traceExit();
			return patient;
		} catch (BusinessException error) {
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
	 * @throws SystemException   the system exception
	 */
	public Patient readPatientById(int id) throws BusinessException, SystemException {
		try {
			logger.entry(id);
			Patient patient = patientDao.readPatientByIdDao(id);
			logger.traceExit(patient);
			if (patient == null) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			return patient;
		} catch (BusinessException error) {
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
	 * @throws SystemException   the system exception
	 */
	public boolean upddatePatient(Patient patient) throws BusinessException, SystemException {
		try {
			logger.entry(patient);
			logger.traceExit();
			boolean result = patientDao.updatePatientDao(patient);
			if (!result) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			return result;
		} catch (BusinessException error) {
			throw new BusinessException(error.getMessage());
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

}
