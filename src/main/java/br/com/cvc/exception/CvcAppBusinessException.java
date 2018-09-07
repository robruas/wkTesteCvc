package br.com.cvc.exception;
public class CvcAppBusinessException extends Exception {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -209806032835078973L;

	/**
	 * Construtor da classe UserAppDaoException
	 */
	public CvcAppBusinessException() {
		super();
	}

	/**
	 * Construtor da classe UserAppDaoException
	 *
	 * @param message
	 */
	public CvcAppBusinessException(String message) {
		super(message);
	}

	/**
	 * Construtor da classe UserAppDaoException
	 *
	 * @param cause
	 */
	public CvcAppBusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construtor da classe UserAppDaoException
	 *
	 * @param message
	 * @param cause
	 */
	public CvcAppBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor da classe UserAppDaoException
	 *
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CvcAppBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
