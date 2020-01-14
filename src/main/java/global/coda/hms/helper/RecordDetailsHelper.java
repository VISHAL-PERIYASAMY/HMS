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
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.DoctorPatientMapping;

/**
 * The Class RecordDetailsHelper.
 */
public class RecordDetailsHelper {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(RecordDetailsHelper.class);

	/** The doctor dao. */
	private DoctorDao doctorDao = new DoctorDao();

	/**
	 * Read record by id.
	 *
	 * @param id the id
	 * @return the DoctorPatientMapping
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public DoctorPatientMapping readRecordById(int id) throws BusinessException, SystemException {
		logger.entry(id);
		try {
			DoctorPatientMapping doctorPatientMapping = doctorDao.readRecordById(id);
			if (doctorPatientMapping.getListOfPatients().size() == NumericConstants.ZERO) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.RECORD_NOT_FOUND);
			}
			logger.traceExit(doctorPatientMapping);
			return doctorPatientMapping;
		} catch (BusinessException error) {
			throw new BusinessException(error.getMessage());
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read all record.
	 *
	 * @return the map
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public List<DoctorPatientMapping> readAllRecord() throws BusinessException, SystemException {
		logger.traceEntry();
		try {
			List<DoctorPatientMapping> listDoctorPatientMapping = doctorDao.readAllRecord();
			if (listDoctorPatientMapping.size() == NumericConstants.ZERO) {
				throw new BusinessException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.RECORD_NOT_FOUND);
			}
			logger.traceExit(listDoctorPatientMapping);
			return listDoctorPatientMapping;
		} catch (BusinessException error) {
			throw new BusinessException(error.getMessage());
		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

}
