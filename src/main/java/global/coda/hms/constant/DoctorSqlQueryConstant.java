package global.coda.hms.constant;

/**
 *
 * @author Vishal
 */
public final class DoctorSqlQueryConstant {

	/**
	 * Instantiates a new doctor sql query constant.
	 */
	private DoctorSqlQueryConstant() {
	}

	public static final String USER_DETAIL_INSERT = "INSERT INTO `t_user_details` (`username`, `password`, `fk_role_id`,"
			+ " `firstname`, `lastname`, `city`, `state`,`phone_number`) VALUES (?, ?, 3, ?, ?, ?, ?,?);";

	public static final String DOCTOR_INSERT = "INSERT INTO `t_doctor` (`doctor_specialization`, `fk_user_id`) VALUES (?, ?)";

	public static final String DOCTOR_SELECT_ALL = "select * from hms.t_user_details as user LEFT JOIN hms.t_doctor as doctor ON user.pk_user_id ="
			+ " doctor.fk_user_id where user.is_active = 1 and user.fk_role_id = 3";

	public static final String DOCTOR_SELECT_BY_ID = "select * from hms.t_user_details "
			+ "as user LEFT JOIN hms.t_doctor as doctor "
			+ "ON user.pk_user_id = doctor.fk_user_id where user.is_active = 1 "
			+ "and user.fk_role_id = 3 and user.pk_user_id=?";

	public static final String DOCTOR_DELETE_BY_ID = "update t_doctor set is_active = 0 where fk_user_id = ?";

	public static final String DOCTOR_UPDATE_BY_ID = "UPDATE `t_doctor` SET `doctor_specialization` "
			+ "= ? WHERE (`pk_doctor_id` = ?)";

}
