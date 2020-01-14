package global.coda.hms.constant;

/**
 * The Class UserSqlQueryConstant.
 */
public final class UserSqlQueryConstant {

	/**
	 * Instantiates a new user sql query constant.
	 */
	private UserSqlQueryConstant() {
	}

	public static final String USER_DELETE_BY_ID = "update t_user_details set is_active = 0 where pk_user_id = ? and is_active = 1";

	public static final String UPDATE_BY_ID = "UPDATE `t_user_details` SET  `password` = ?, `firstname` = ?, `lastname` = ?, `city` = ?, "
			+ "`state` = ? ,`phone_number`=? WHERE (`pk_user_id` = ? and `is_active` = 1)";

	public static final String CHECK_USER_NAME = "select * from `hms`.`t_user_details` where username=?";

}
