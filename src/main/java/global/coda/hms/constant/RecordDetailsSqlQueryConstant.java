package global.coda.hms.constant;

/**
 *
 * @author Vishal
 */
public final class RecordDetailsSqlQueryConstant {

	/**
	 * Instantiates a new record details sql query constant.
	 */
	private RecordDetailsSqlQueryConstant() {

	}

	public static final String UNIQUE_DOCTOR_ID = "SELECT DISTINCT  fk_doctor_id FROM `hms`.`t_record`";

	public static final String READ_RECORD_BY_DOCTOR_ID = "SELECT * FROM `hms`.`t_record` WHERE fk_doctor_id=?";

}
