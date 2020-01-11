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
import global.coda.hms.constant.DoctorSqlQueryConstant;
import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.constant.NumericConstants;
import global.coda.hms.constant.UserSqlQueryConstant;
import global.coda.hms.exception.DoctorNotFoundException;
import global.coda.hms.exception.UserNameAlreadyExistException;
import global.coda.hms.model.Doctor;

/**
 *
 * @author Vishal
 */
public class DoctorDao {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(DoctorDao.class);

	/**
	 * Adds the doctor dao.
	 *
	 * @param doctor the doctor
	 * @return true when created
	 * @throws UserNameAlreadyExistException the user name already exist exception
	 * @throws SQLException                  the SQL exception
	 * @throws Exception                     Connection error and other error
	 */
	public boolean addDoctorDao(Doctor doctor) throws UserNameAlreadyExistException, SQLException, Exception {
		logger.traceEntry();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatementdoctor = connection
					.prepareStatement(UserSqlQueryConstant.CHECK_USER_NAME);
			preparedStatementdoctor.setString(NumericConstants.ONE, doctor.getUsername());
			ResultSet resultSet = preparedStatementdoctor.executeQuery();
			if (resultSet.next()) {
				throw new UserNameAlreadyExistException(
						HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE + ApplicationConstant.NAME_EXIST);
			}
			preparedStatementdoctor = connection.prepareStatement(UserSqlQueryConstant.USER_DETAIL_INSERT,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatementdoctor.setString(NumericConstants.ONE, doctor.getUsername());
			preparedStatementdoctor.setString(NumericConstants.TWO, doctor.getPassword());
			preparedStatementdoctor.setInt(NumericConstants.THREE, doctor.getRoleId());
			preparedStatementdoctor.setString(NumericConstants.FOUR, doctor.getUserFirstName());
			preparedStatementdoctor.setString(NumericConstants.FIVE, doctor.getUserLastName());
			preparedStatementdoctor.setString(NumericConstants.SIX, doctor.getUserCity());
			preparedStatementdoctor.setString(NumericConstants.SEVEN, doctor.getUserState());
			preparedStatementdoctor.setString(NumericConstants.EIGHT, doctor.getPhoneNumber());
			preparedStatementdoctor.execute();
			ResultSet key = preparedStatementdoctor.getGeneratedKeys();
			key.next();
			preparedStatementdoctor = connection.prepareStatement(DoctorSqlQueryConstant.DOCTOR_INSERT);
			preparedStatementdoctor.setString(NumericConstants.ONE, doctor.getSpecilization());
			preparedStatementdoctor.setInt(NumericConstants.TWO, key.getInt(NumericConstants.ONE));
			preparedStatementdoctor.execute();
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
	 * Delete doctor dao.
	 *
	 * @param id the id
	 * @return true when deleted
	 * @throws Exception Connection error and other error
	 */
	public boolean deleteDoctorDao(int id) throws Exception {
		logger.traceEntry();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueryConstant.USER_DELETE_BY_ID);
			preparedStatement.setInt(NumericConstants.ONE, id);
			int rows = preparedStatement.executeUpdate();
			if (rows == NumericConstants.ZERO) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			preparedStatement = connection.prepareStatement(DoctorSqlQueryConstant.DOCTOR_DELETE_BY_ID);
			preparedStatement.setInt(NumericConstants.ONE, id);
			rows = preparedStatement.executeUpdate();

		} catch (DoctorNotFoundException error) {
			throw new DoctorNotFoundException(error.getMessage());
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
	 * Read all doctor dao.
	 *
	 * @return List of all doctor object
	 * @throws Exception the exception
	 */
	public List<Doctor> readAllDoctorDao() throws Exception {
		logger.traceEntry();
		List<Doctor> listOfDoctor = null;
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(DoctorSqlQueryConstant.DOCTOR_SELECT_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			listOfDoctor = new ArrayList<Doctor>();
			while (resultSet.next()) {
				Doctor doctor = new Doctor();
				doctor.setUsername(resultSet.getString(ApplicationConstant.USERNAME));
				doctor.setUserFirstName(resultSet.getString(ApplicationConstant.FIRSTNAME));
				doctor.setUserLastName(resultSet.getString(ApplicationConstant.LASTNAME));
				doctor.setSpecilization(resultSet.getString(ApplicationConstant.DOCTORSPECIALIZATION));
				doctor.setUserCity(resultSet.getString(ApplicationConstant.CITY));
				doctor.setUserState(resultSet.getString(ApplicationConstant.STATE));
				doctor.setPhoneNumber(resultSet.getString(ApplicationConstant.PHONENUMBER));
				listOfDoctor.add(doctor);
			}
			if (listOfDoctor.size() == NumericConstants.ZERO) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
		} catch (DoctorNotFoundException error) {
			throw new DoctorNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return listOfDoctor;
	}

	/**
	 * Read doctor by id dao.
	 *
	 * @param id of doctor
	 * @return doctor Object
	 * @throws Exception the exception
	 */
	public Doctor readDoctorByIdDao(int id) throws Exception {
		logger.traceEntry();
		Doctor doctor = null;
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement(DoctorSqlQueryConstant.DOCTOR_SELECT_BY_ID);
			preparedStatement.setInt(NumericConstants.ONE, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				doctor = new Doctor();
				doctor.setUsername(resultSet.getString(ApplicationConstant.USERNAME));
				doctor.setUserFirstName(resultSet.getString(ApplicationConstant.FIRSTNAME));
				doctor.setUserLastName(resultSet.getString(ApplicationConstant.LASTNAME));
				doctor.setSpecilization(resultSet.getString(ApplicationConstant.DOCTORSPECIALIZATION));
				doctor.setUserCity(resultSet.getString(ApplicationConstant.CITY));
				doctor.setUserState(resultSet.getString(ApplicationConstant.STATE));
				doctor.setPhoneNumber(resultSet.getString(ApplicationConstant.PHONENUMBER));
			}
			if (doctor == null) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
		} catch (DoctorNotFoundException error) {
			throw new DoctorNotFoundException(error.getMessage());
		} catch (SQLException sqlError) {
			throw new SQLException(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + sqlError.getMessage());
		} catch (Exception error) {
			throw new Exception(
					HttpStatusConstant.INTERNAL_SERVER_ERROR + ApplicationConstant.SPACE + error.getMessage());
		}
		logger.traceExit();
		return doctor;
	}

	/**
	 * Update doctor dao.
	 *
	 * @param doctor Object
	 * @return true when updated
	 * @throws Exception Connection error and other error
	 */
	public boolean updateDoctorDao(Doctor doctor) throws Exception {
		logger.traceEntry();
		try (Connection connection = DataBaseConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(UserSqlQueryConstant.UPDATE_BY_ID);
			preparedStatement.setString(NumericConstants.ONE, doctor.getPassword());
			preparedStatement.setString(NumericConstants.TWO, doctor.getUserFirstName());
			preparedStatement.setString(NumericConstants.THREE, doctor.getUserLastName());
			preparedStatement.setString(NumericConstants.FOUR, doctor.getUserCity());
			preparedStatement.setString(NumericConstants.FIVE, doctor.getUserState());
			preparedStatement.setString(NumericConstants.SIX, doctor.getPhoneNumber());
			preparedStatement.setInt(NumericConstants.SEVEN, doctor.getUserId());
			int rows = preparedStatement.executeUpdate();
			if (rows == NumericConstants.ZERO) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			preparedStatement = connection.prepareStatement(DoctorSqlQueryConstant.DOCTOR_UPDATE_BY_ID);
			preparedStatement.setString(NumericConstants.ONE, doctor.getSpecilization());
			preparedStatement.setInt(NumericConstants.TWO, doctor.getUserId());
			preparedStatement.execute();
		} catch (DoctorNotFoundException error) {
			throw new DoctorNotFoundException(error.getMessage());
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
