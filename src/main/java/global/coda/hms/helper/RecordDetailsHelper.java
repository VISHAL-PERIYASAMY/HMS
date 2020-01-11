package global.coda.hms.helper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import global.coda.hms.dao.RecordDetailsDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.RecordNotFoundException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.RecordDetails;

// TODO: Auto-generated Javadoc
/**
 * The Class RecordDetailsHelper.
 */
public class RecordDetailsHelper {

	/** The record details dao. */
	private RecordDetailsDao recordDetailsDao = new RecordDetailsDao();

	/**
	 * Read record by id.
	 *
	 * @param id the id
	 * @return the map
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	public Map<String, List<RecordDetails>> readRecordById(int id) throws BusinessException, SystemException {
		try {
			return recordDetailsDao.readRecordById(id);
		} catch (RecordNotFoundException error) {
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
	 * @throws SystemException the system exception
	 */
	public Map<String, List<RecordDetails>> readAllRecord() throws BusinessException, SystemException {
		try {
			return recordDetailsDao.readAllRecord();
		} catch (RecordNotFoundException error) {
			throw new BusinessException(error.getMessage());

		} catch (SQLException error) {
			throw new SystemException(error.getMessage());

		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

}
