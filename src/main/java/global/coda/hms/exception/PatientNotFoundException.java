package global.coda.hms.exception;

/**
 *
 * @author Vishal
 */
public class PatientNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new patient not found exception.
	 *
	 * @param errorMessage the error message
	 */
	public PatientNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
