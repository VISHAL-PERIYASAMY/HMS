package global.coda.hms.helper;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.constant.NumericConstants;
import global.coda.hms.dao.DoctorDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.DoctorNotFoundException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exception.UserNameAlreadyExistException;
import global.coda.hms.model.Doctor;

/**
 * The Class DoctorCrudHelper.
 *
 * @author Vishal
 */

public class DoctorCrudHelper {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(DoctorCrudHelper.class);

	/** The doctor dao. */
	private DoctorDao doctorDao = new DoctorDao();

	/**
	 * Adds the doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean addDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			logger.entry(doctor);
			logger.traceExit();
			return doctorDao.addDoctorDao(doctor);
		} catch (UserNameAlreadyExistException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean deleteDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			logger.entry(doctor);
			boolean result = doctorDao.deleteDoctorDao(doctor.getUserId());
			if (!result) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit();
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
	 * Read all doctor.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public List<Doctor> readAllDoctor() throws BusinessException, SystemException {
		try {
			logger.traceEntry();
			List<Doctor> doctor = doctorDao.readAllDoctorDao();
			if (doctor.size() == NumericConstants.ZERO) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit(doctor);
			return doctor;
		} catch (BusinessException error) {
			throw new BusinessException(error.getMessage());
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read doctor by id.
	 *
	 * @param id the id
	 * @return the doctor
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public Doctor readDoctorById(int id) throws BusinessException, SystemException {
		try {
			logger.entry(id);
			Doctor doctor = doctorDao.readDoctorByIdDao(id);
			if (doctor == null) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit(doctor);
			return doctor;
		} catch (BusinessException error) {
			throw new BusinessException(error.getMessage());
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Upddate doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean upddateDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			logger.entry(doctor);
			boolean result = doctorDao.updateDoctorDao(doctor);
			if (!result) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit();
			return result;
		} catch (BusinessException error) {
			throw new BusinessException(error.getMessage());
		} catch (DoctorNotFoundException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

}
