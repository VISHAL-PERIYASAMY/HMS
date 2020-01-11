package global.coda.hms.delegate;

import java.util.List;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.DoctorCrudHelper;
import global.coda.hms.model.Doctor;

/**
 *
 * @author Vishal
 */
public class DoctorOperationDelegate {

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
		return doctorCrudHelper.readAllDoctor();

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
		return doctorCrudHelper.readDoctorById(id);
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
		return doctorCrudHelper.upddateDoctor(doctor);
	}

}
