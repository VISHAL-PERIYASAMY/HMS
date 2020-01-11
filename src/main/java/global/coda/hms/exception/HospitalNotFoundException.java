package global.coda.hms.exception;

/**
 *
 * @author Vishal
 */
public class HospitalNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new hospital not found exception.
	 *
	 * @param errorMessage the error message
	 */
	public HospitalNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
