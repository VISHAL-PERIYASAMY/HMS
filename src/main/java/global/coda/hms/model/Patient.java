package global.coda.hms.model;

import java.sql.Date;
// TODO: Auto-generated Javadoc

/**
 * The Class Patient.
 *
 * @author Vishal
 */

/**
 * The Class Patient.
 *
 * @author Vishal
 */
public class Patient extends UserDetails {

	/** The patient id. */
	private int patientId;

	/** The user id. */
	private int userId;

	/** The blood group. */
	private String bloodGroup;

	/** The weight. */
	private int weight;

	/** The is active. */
	private int isActive;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;



	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Patient{"
				+ "patientId=" + patientId
				+ ", userId=" + userId
				+ ", bloodGroup='" + bloodGroup + '\''
				+ ", weight=" + weight
				+ ", isActive=" + isActive
				+ ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate
				+ '}';
	}


	/**
	 * Gets bloodGroup.
	 *
	 * @return Value of bloodGroup.
	 */
	public String getBloodGroup() {
		return bloodGroup;
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
	 * Sets new weight.
	 *
	 * @param weight New value of weight.
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Gets createdDate.
	 *
	 * @return Value of createdDate.
	 */
	@Override
	public Date getCreatedDate() {
		return createdDate;
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

	/**
	 * Gets patientId.
	 *
	 * @return Value of patientId.
	 */
	public int getPatientId() {
		return patientId;
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
	 * Sets new userId.
	 *
	 * @param userId New value of userId.
	 */
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Sets new patientId.
	 *
	 * @param patientId New value of patientId.
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * Sets new bloodGroup.
	 *
	 * @param bloodGroup New value of bloodGroup.
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	 * Gets weight.
	 *
	 * @return Value of weight.
	 */
	public int getWeight() {
		return weight;
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
	 * Gets updatedDate.
	 *
	 * @return Value of updatedDate.
	 */
	@Override
	public Date getUpdatedDate() {
		return updatedDate;
	}
}
