package global.coda.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.config.DataBaseConfig;
import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.constant.NumericConstants;
import global.coda.hms.constant.RecordDetailsSqlQueryConstant;
import global.coda.hms.exception.RecordNotFoundException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import global.coda.hms.model.RecordDetails;

/**
 *
 * @author Vishal
 */
public class RecordDetailsDao {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(RecordDetailsDao.class);

	/**
	 * Read record by id.
	 *
	 * @param id the id
	 * @return the map
	 * @throws Exception the exception
	 */
	public Map<String, List<RecordDetails>> readRecordById(int id) throws Exception {
		logger.traceEntry();
		Map<String, List<RecordDetails>> recordMap = new HashMap<String, List<RecordDetails>>();
		PatientDao patientDao = new PatientDao();
		DoctorDao doctorDao = new DoctorDao();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement(RecordDetailsSqlQueryConstant.READ_RECORD_BY_DOCTOR_ID);
			preparedStatement.setInt(NumericConstants.ONE, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<RecordDetails> patientList = new ArrayList<RecordDetails>();
			while (resultSet.next()) {
				RecordDetails recordDetails = new RecordDetails();
				int patientId = resultSet.getInt(ApplicationConstant.PATIENT_ID);
				Patient patient = patientDao.readPatientByIdDao(patientId);
				recordDetails.setPatientName(patient.getUsername());
				recordDetails.setDisease(resultSet.getString(ApplicationConstant.DISEASE));
				patientList.add(recordDetails);

			}
			if (patientList.size() == NumericConstants.ZERO) {
				throw new RecordNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.RECORD_NOT_FOUND);
			}
			Doctor doctor = doctorDao.readDoctorByIdDao(id);
			recordMap.put(doctor.getUsername(), patientList);

		} catch (RecordNotFoundException error) {
			throw new RecordNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return recordMap;
	}

	/**
	 * Read all record.
	 *
	 * @return the map
	 * @throws Exception the exception
	 */
	public Map<String, List<RecordDetails>> readAllRecord() throws Exception {
		logger.traceEntry();
		Map<String, List<RecordDetails>> recordMap = new HashMap<String, List<RecordDetails>>();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement(RecordDetailsSqlQueryConstant.UNIQUE_DOCTOR_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Map<String, List<RecordDetails>> mapForId = readRecordById(
						resultSet.getInt(ApplicationConstant.DOCTOR_ID));
				String key = (String) mapForId.keySet().toArray()[NumericConstants.ZERO];
				recordMap.put(key, mapForId.get(key));
			}
			if (recordMap.size() == NumericConstants.ZERO) {
				throw new RecordNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.RECORD_NOT_FOUND);
			}

		} catch (RecordNotFoundException error) {
			throw new RecordNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return recordMap;
	}

}
