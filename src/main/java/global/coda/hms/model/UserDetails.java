package global.coda.hms.model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetails.
 *
 * @author Vishal
 */
/**
 * The Class UserDetails.
 *
 * @author Vishal
 */
public class UserDetails {

	/** The user id. */
	private int userId;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The phone number. */
	private String phoneNumber;

	/** The role id. */
	private int roleId;

	/** The user first name. */
	private String userFirstName;

	/** The user last name. */
	private String userLastName;

	/** The user city. */
	private String userCity;

	/** The user state. */
	private String userState;

	/** The is active. */
	private int isActive;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets updatedDate.
	 *
	 * @return Value of updatedDate.
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Gets username.
	 *
	 * @return Value of username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets userState.
	 *
	 * @return Value of userState.
	 */
	public String getUserState() {
		return userState;
	}

	/**
	 * Gets userCity.
	 *
	 * @return Value of userCity.
	 */
	public String getUserCity() {
		return userCity;
	}

	/**
	 * Sets new updatedDate.
	 *
	 * @param updatedDate New value of updatedDate.
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets userId.
	 *
	 * @return Value of userId.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets new userId.
	 *
	 * @param userId New value of userId.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets isActive.
	 *
	 * @return Value of isActive.
	 */
	public int getIsActive() {
		return isActive;
	}

	/**
	 * Sets new username.
	 *
	 * @param username New value of username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets userFirstName.
	 *
	 * @return Value of userFirstName.
	 */
	public String getUserFirstName() {
		return userFirstName;
	}

	/**
	 * Sets new userFirstName.
	 *
	 * @param userFirstName New value of userFirstName.
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	/**
	 * Sets new createdDate.
	 *
	 * @param createdDate New value of createdDate.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Sets new password.
	 *
	 * @param password New value of password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets userLastName.
	 *
	 * @return Value of userLastName.
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * Sets new userLastName.
	 *
	 * @param userLastName New value of userLastName.
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	/**
	 * Gets password.
	 *
	 * @return Value of password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets createdDate.
	 *
	 * @return Value of createdDate.
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Gets roleId.
	 *
	 * @return Value of roleId.
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Sets new roleId.
	 *
	 * @param roleId New value of roleId.
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * Sets new userCity.
	 *
	 * @param userCity New value of userCity.
	 */
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	/**
	 * Sets new isActive.
	 *
	 * @param isActive New value of isActive.
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	/**
	 * Sets new userState.
	 *
	 * @param userState New value of userState.
	 */
	public void setUserState(String userState) {
		this.userState = userState;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", roleId=" + roleId + ", userFirstName=" + userFirstName + ", userLastName="
				+ userLastName + ", userCity=" + userCity + ", userState=" + userState + ", isActive=" + isActive
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
