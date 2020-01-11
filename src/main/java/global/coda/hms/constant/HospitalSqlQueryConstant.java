package global.coda.hms.constant;

/**
 *
 * @author Vishal
 */
public final class HospitalSqlQueryConstant {

	/**
	 * Instantiates a new hospital sql query constant.
	 */
	private HospitalSqlQueryConstant() {
	}

	public static final String CREATE_HOSPITAL = "INSERT INTO `hms`.`t_hospital` (`hospital_name`) VALUES (?)";

	public static final String READ_HOSPITAL_BY_ID = "select * from t_hospital where pk_hospital_id = ? and is_active = 1";

	public static final String READ_HOSPITAL_ALL = "select * from t_hospital where is_active = 1";

	public static final String UPDATE_HOSPTIAL_BY_ID = "UPDATE `t_hospital` SET `hospital_name` = ? WHERE (`pk_hospital_id` = ?)";

	public static final String DELETE_HOSPITAL_BY_ID = "update t_hospital set is_active = 0 where pk_hospital_id = ?";

}
