package global.coda.hms.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseBody.
 *
 * @author Vishal
 * @param <T> the generic type
 */
/**
 * The Class ResponseBody.
 *
 * @param <T> the generic type
 */
public class ResponseBody<T> {

	/** The status. */
	private int status;

	/** The message. */
	private T message;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public T getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(T message) {
		this.message = message;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ResponseBody [status=" + status + ", message=" + message + "]";
	}

}
