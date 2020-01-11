package global.coda.hms.exception;

/**
 *
 * @author Vishal
 */
public class BusinessException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new business exception.
	 *
	 * @param msg the msg
	 */
	public BusinessException(String msg) {
		super(msg);
	}
}
