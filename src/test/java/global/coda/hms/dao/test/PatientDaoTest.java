package global.coda.hms.dao.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import global.coda.hms.constant.NumericConstants;
import global.coda.hms.constant.TestConstants;
import global.coda.hms.dao.PatientDao;
import global.coda.hms.model.Patient;

/**
 *
 * @author Vishal
 *
 */
public class PatientDaoTest {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(PatientDaoTest.class);

	/**
	 * Read patient by id.
	 */
	@Test
	public void readPatientById() {
		logger.traceEntry();
		try {
			PatientDao patientDao = new PatientDao();
			Patient patient = patientDao.readPatientByIdDao(NumericConstants.TWO);
			assertEquals(patient.getUsername(), TestConstants.PATIENT_NAME);
		} catch (Exception error) {
			logger.error(error.getMessage());
		}
		logger.traceExit();
	}

	/**
	 * Read all patient.
	 */
	@Test
	public void readAllPatient() {
		logger.traceEntry();
		try {
			PatientDao patientDao = new PatientDao();
			List<Patient> patientList = patientDao.readAllPatientDao();
			assertEquals(patientList.get(NumericConstants.ZERO).getUsername(), TestConstants.PATIENT_NAME);
		} catch (Exception error) {
			logger.error(error.getMessage());
		}
		logger.traceExit();
	}

}
