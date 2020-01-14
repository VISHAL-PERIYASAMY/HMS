package global.coda.hms.delegate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.DoctorCrudHelper;
import global.coda.hms.model.Doctor;

/**
 *
 * @author Vishal
 */
public class DoctorOperationDelegate {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(DoctorOperationDelegate.class);

	/** The doctor crud helper. */
	private DoctorCrudHelper doctorCrudHelper = new DoctorCrudHelper();

	/**
	 * Adds the doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean addDoctor(Doctor doctor) throws BusinessException, SystemException {
		logger.entry(doctor);
		logger.traceExit();
		return doctorCrudHelper.addDoctor(doctor);
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
		logger.entry(doctor);
		logger.traceExit();
		return doctorCrudHelper.deleteDoctor(doctor);
	}

	/**
	 * Read all doctor.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public List<Doctor> readAllDoctor() throws BusinessException, SystemException {
		logger.traceEntry();
		List<Doctor> doctorList = doctorCrudHelper.readAllDoctor();
		logger.traceExit(doctorList);
		return doctorList;

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
		logger.entry(id);
		Doctor doctor = doctorCrudHelper.readDoctorById(id);
		logger.traceExit(doctor);
		return doctor;
	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean updateDoctor(Doctor doctor) throws BusinessException, SystemException {
		logger.entry(doctor);
		logger.traceExit();
		return doctorCrudHelper.upddateDoctor(doctor);
	}

}
