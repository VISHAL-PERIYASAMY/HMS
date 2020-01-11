package global.coda.hms.model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Doctor.
 *
 * @author Vishal
 */
/**
 * The Class Doctor.
 *
 * @author vishal
 */
public class Doctor extends UserDetails {

	/** The doctor id. */
	private int doctorId;

	/** The user id. */
	private int userId;

	/** The specilization. */
	private String specilization;

	/** The is active. */
	private int isActive;

	/** The created time. */
	private Date createdTime;

	/** The updated time. */
	private Date updatedTime;

	/**
	 * Method to return Object String.
	 *
	 * @return the string
	 */

	@Override
	public String toString() {
		return "Doctor{" + "doctor_id=" + doctorId + ", userId=" + userId + ", specilization='" + specilization + '\''
				+ ", isActive=" + isActive + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + '}';
	}

	/**
	 * Sets new createdTime.
	 *
	 * @param createdTime New value of createdTime.
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * Gets createdTime.
	 *
	 * @return Value of createdTime.
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * Sets new specilization.
	 *
	 * @param specilization New value of specilization.
	 */
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}

	/**
	 * Gets userId.
	 *
	 * @return Value of userId.
	 */
	@Override
	public int getUserId() {
		return userId;
	}

	/**
	 * Gets isActive.
	 *
	 * @return Value of isActive.
	 */
	@Override
	public int getIsActive() {
		return isActive;
	}

	/**
	 * Gets updatedTime.
	 *
	 * @return Value of updatedTime.
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * Gets the doctor id.
	 *
	 * @return the doctor id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * Sets the doctor id.
	 *
	 * @param doctorId the new doctor id
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * Sets new userId.
	 *
	 * @param userId New value of userId.
	 */
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Sets new updatedTime.
	 *
	 * @param updatedTime New value of updatedTime.
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * Gets specilization.
	 *
	 * @return Value of specilization.
	 */
	public String getSpecilization() {
		return specilization;
	}

	/**
	 * Sets new isActive.
	 *
	 * @param isActive New value of isActive.
	 */
	@Override
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
}
