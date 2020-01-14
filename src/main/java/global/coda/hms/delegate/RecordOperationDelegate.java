package global.coda.hms.delegate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.RecordDetailsHelper;
import global.coda.hms.model.DoctorPatientMapping;

/**
 *
 * @author Vishal
 */
public class RecordOperationDelegate {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(RecordOperationDelegate.class);

	/** The record details helper. */
	private RecordDetailsHelper recordDetailsHelper = new RecordDetailsHelper();

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
		DoctorPatientMapping doctorPatientMapping = recordDetailsHelper.readRecordById(id);
		logger.traceExit(doctorPatientMapping);
		return doctorPatientMapping;
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
		List<DoctorPatientMapping> listDoctorPatientMapping = recordDetailsHelper.readAllRecord();
		logger.traceExit(listDoctorPatientMapping);
		return listDoctorPatientMapping;
	}

}
