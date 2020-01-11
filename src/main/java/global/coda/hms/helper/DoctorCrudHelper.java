package global.coda.hms.helper;

import java.sql.SQLException;
import java.util.List;

import global.coda.hms.dao.DoctorDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.DoctorNotFoundException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exception.UserNameAlreadyExistException;
import global.coda.hms.model.Doctor;

// TODO: Auto-generated Javadoc
/**
 * The Class DoctorCrudHelper.
 *
 * @author Vishal
 */
/**
 * The Class DoctorCrudHelper.
 */
public class DoctorCrudHelper {

	/** The doctor dao. */
	private DoctorDao doctorDao = new DoctorDao();

	/**
	 * Adds the doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public boolean addDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
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
	 * @throws SystemException the system exception
	 */
	public boolean deleteDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			return doctorDao.deleteDoctorDao(doctor.getUserId());
		} catch (DoctorNotFoundException error) {
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
	 * @throws SystemException the system exception
	 */
	public List<Doctor> readAllDoctor() throws BusinessException, SystemException {
		try {
			return doctorDao.readAllDoctorDao();
		} catch (DoctorNotFoundException error) {
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
	 * @throws SystemException the system exception
	 */
	public Doctor readDoctorById(int id) throws BusinessException, SystemException {
		try {
			return doctorDao.readDoctorByIdDao(id);
		} catch (DoctorNotFoundException error) {
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
	 * @throws SystemException the system exception
	 */
	public boolean upddateDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			return doctorDao.updateDoctorDao(doctor);
		} catch (DoctorNotFoundException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

}
