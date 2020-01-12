package global.coda.hms.dao.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import global.coda.hms.constant.NumericConstants;
import global.coda.hms.constant.TestConstants;
import global.coda.hms.dao.DoctorDao;
import global.coda.hms.model.Doctor;

/**
 *
 * @author Vishal
 *
 */
public class DoctorDaoTest {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(DoctorDaoTest.class);

	/**
	 * Read doctor by id.
	 */
	@Test
	public void readDoctorById() {
		logger.traceEntry();
		try {
			DoctorDao doctorDao = new DoctorDao();
			Doctor doctor = doctorDao.readDoctorByIdDao(NumericConstants.ONE);
			assertEquals(doctor.getUsername(), TestConstants.DOCTOR_NAME);
		} catch (Exception error) {
			logger.error(error.getMessage());
		}
		logger.traceExit();
	}

	/**
	 * Read all doctor.
	 */
	@Test
	public void readAllDoctor() {
		logger.traceEntry();
		try {
			DoctorDao doctorDao = new DoctorDao();
			List<Doctor> doctorList = doctorDao.readAllDoctorDao();
			assertEquals(doctorList.get(NumericConstants.ZERO).getUsername(), TestConstants.DOCTOR_NAME);
		} catch (Exception error) {
			logger.error(error.getMessage());
		}
		logger.traceExit();
	}

}
