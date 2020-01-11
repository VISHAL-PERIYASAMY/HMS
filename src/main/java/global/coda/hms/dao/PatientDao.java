package global.coda.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.config.DataBaseConfig;
import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.constant.NumericConstants;
import global.coda.hms.constant.PatientSqlQueryConstant;
import global.coda.hms.constant.UserSqlQueryConstant;
import global.coda.hms.exception.PatientNotFoundException;
import global.coda.hms.exception.UserNameAlreadyExistException;
import global.coda.hms.model.Patient;

/**
 *
 * @author Vishal
 */
public class PatientDao {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(PatientDao.class);

	/**
	 * Adds the patient dao.
	 *
	 * @param patient the patient
	 * @return true when created
	 * @throws UserNameAlreadyExistException the user name already exist exception
	 * @throws SQLException                  the SQL exception
	 * @throws Exception                     Connection error and other error
	 */
	public boolean addPatientDao(Patient patient) throws UserNameAlreadyExistException, SQLException, Exception {
		logger.traceEntry();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatementPatient = connection
					.prepareStatement(UserSqlQueryConstant.CHECK_USER_NAME);
			preparedStatementPatient.setString(NumericConstants.ONE, patient.getUsername());
			ResultSet resultSet = preparedStatementPatient.executeQuery();
			if (resultSet.next()) {
				throw new UserNameAlreadyExistException(
						HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE + ApplicationConstant.NAME_EXIST);
			}
			preparedStatementPatient = connection.prepareStatement(UserSqlQueryConstant.USER_DETAIL_INSERT,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatementPatient.setString(NumericConstants.ONE, patient.getUsername());
			preparedStatementPatient.setString(NumericConstants.TWO, patient.getPassword());
			preparedStatementPatient.setInt(NumericConstants.THREE, patient.getRoleId());
			preparedStatementPatient.setString(NumericConstants.FOUR, patient.getUserFirstName());
			preparedStatementPatient.setString(NumericConstants.FIVE, patient.getUserLastName());
			preparedStatementPatient.setString(NumericConstants.SIX, patient.getUserCity());
			preparedStatementPatient.setString(NumericConstants.SEVEN, patient.getUserState());
			preparedStatementPatient.setString(NumericConstants.EIGHT, patient.getPhoneNumber());
			preparedStatementPatient.execute();
			ResultSet key = preparedStatementPatient.getGeneratedKeys();
			key.next();
			preparedStatementPatient = connection.prepareStatement(PatientSqlQueryConstant.PATIENT_INSERT);
			preparedStatementPatient.setInt(NumericConstants.ONE, key.getInt(NumericConstants.ONE));
			preparedStatementPatient.setString(NumericConstants.TWO, patient.getBloodGroup());
			preparedStatementPatient.setInt(NumericConstants.THREE, patient.getWeight());
			preparedStatementPatient.execute();
		} catch (UserNameAlreadyExistException error) {
			throw new UserNameAlreadyExistException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return true;
	}

	/**
	 * Delete patient dao.
	 *
	 * @param id the id
	 * @return true when deleted
	 * @throws Exception Connection error and other error
	 */
	public boolean deletePatientDao(int id) throws Exception {
		logger.traceEntry();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueryConstant.USER_DELETE_BY_ID);
			preparedStatement.setInt(NumericConstants.ONE, id);
			int rows = preparedStatement.executeUpdate();
			if (rows == NumericConstants.ZERO) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			preparedStatement = connection.prepareStatement(PatientSqlQueryConstant.PATIENT_DELETE_BY_ID);
			preparedStatement.setInt(NumericConstants.ONE, id);
			rows = preparedStatement.executeUpdate();

		} catch (PatientNotFoundException error) {
			throw new PatientNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return true;
	}

	/**
	 * Read all patient dao.
	 *
	 * @return List of all Patient object
	 * @throws Exception the exception
	 */
	public List<Patient> readAllPatientDao() throws Exception {
		logger.traceEntry();
		List<Patient> listOfPatient = null;
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement(PatientSqlQueryConstant.PATIENT_SELECT_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			listOfPatient = new ArrayList<Patient>();
			while (resultSet.next()) {
				Patient patient = new Patient();
				patient.setUsername(resultSet.getString(ApplicationConstant.USERNAME));
				patient.setUserFirstName(resultSet.getString(ApplicationConstant.FIRSTNAME));
				patient.setUserLastName(resultSet.getString(ApplicationConstant.LASTNAME));
				patient.setUserCity(resultSet.getString(ApplicationConstant.CITY));
				patient.setUserState(resultSet.getString(ApplicationConstant.STATE));
				patient.setPhoneNumber(resultSet.getString(ApplicationConstant.PHONENUMBER));
				patient.setBloodGroup(resultSet.getString(ApplicationConstant.BLOODGROUP));
				patient.setWeight(resultSet.getInt(ApplicationConstant.WEIGHT));
				listOfPatient.add(patient);
			}
			if (listOfPatient.size() == NumericConstants.ZERO) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
		} catch (PatientNotFoundException error) {
			throw new PatientNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return listOfPatient;
	}

	/**
	 * Read patient by id dao.
	 *
	 * @param id of patient
	 * @return Patient Object
	 * @throws Exception the exception
	 */
	public Patient readPatientByIdDao(int id) throws Exception {
		logger.traceEntry();
		Patient patient = null;
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement(PatientSqlQueryConstant.PATIENT_SELECT_BY_ID);
			preparedStatement.setInt(NumericConstants.ONE, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				patient = new Patient();
				patient.setUsername(resultSet.getString(ApplicationConstant.USERNAME));
				patient.setUserFirstName(resultSet.getString(ApplicationConstant.FIRSTNAME));
				patient.setUserLastName(resultSet.getString(ApplicationConstant.LASTNAME));
				patient.setUserCity(resultSet.getString(ApplicationConstant.CITY));
				patient.setUserState(resultSet.getString(ApplicationConstant.STATE));
				patient.setPhoneNumber(resultSet.getString(ApplicationConstant.PHONENUMBER));
				patient.setBloodGroup(resultSet.getString(ApplicationConstant.BLOODGROUP));
				patient.setWeight(resultSet.getInt(ApplicationConstant.WEIGHT));
			}
			if (patient == null) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
		} catch (PatientNotFoundException error) {
			throw new PatientNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return patient;
	}

	/**
	 * Update patient dao.
	 *
	 * @param patient the patient
	 * @return true when updated
	 * @throws Exception Connection error and other error
	 */
	public boolean updatePatientDao(Patient patient) throws Exception {
		logger.traceEntry();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueryConstant.UPDATE_BY_ID);
			preparedStatement.setString(NumericConstants.ONE, patient.getPassword());
			preparedStatement.setString(NumericConstants.TWO, patient.getUserFirstName());
			preparedStatement.setString(NumericConstants.THREE, patient.getUserLastName());
			preparedStatement.setString(NumericConstants.FOUR, patient.getUserCity());
			preparedStatement.setString(NumericConstants.FIVE, patient.getUserState());
			preparedStatement.setString(NumericConstants.SIX, patient.getPhoneNumber());
			preparedStatement.setInt(NumericConstants.SEVEN, patient.getUserId());
			int rows = preparedStatement.executeUpdate();
			if (rows == NumericConstants.ZERO) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			preparedStatement = connection.prepareStatement(PatientSqlQueryConstant.PATIENT_UPDATE_BY_ID);
			preparedStatement.setString(NumericConstants.ONE, patient.getBloodGroup());
			preparedStatement.setInt(NumericConstants.TWO, patient.getWeight());
			preparedStatement.setInt(NumericConstants.THREE, patient.getUserId());
			preparedStatement.execute();
		} catch (PatientNotFoundException error) {
			throw new PatientNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return true;
	}

}
