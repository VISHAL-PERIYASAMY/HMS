package global.coda.hms.delegate;

import java.util.List;
import java.util.Map;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.RecordDetailsHelper;
import global.coda.hms.model.RecordDetails;

/**
 *
 * @author Vishal
 */
public class RecordOperationDelegate {

	/** The record details helper. */
	private RecordDetailsHelper recordDetailsHelper = new RecordDetailsHelper();

	/**
	 * Read record by id.
	 *
	 * @param id the id
	 * @return the map
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public Map<String, List<RecordDetails>> readRecordById(int id) throws BusinessException, SystemException {
		return recordDetailsHelper.readRecordById(id);
	}

	/**
	 * Read all record.
	 *
	 * @return the map
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public Map<String, List<RecordDetails>> readAllRecord() throws BusinessException, SystemException {
		return recordDetailsHelper.readAllRecord();
	}

}
