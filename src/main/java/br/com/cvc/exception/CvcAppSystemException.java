package br.com.cvc.exception;

public class CvcAppSystemException extends Exception {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -209806032835078973L;

	/**
	 * Construtor da classe UserAppDaoException
	 */
	public CvcAppSystemException() {
		super();
	}

	/**
	 * Construtor da classe UserAppDaoException
	 *
	 * @param message
	 */
	public CvcAppSystemException(String message) {
		super(message);
	}

	/**
	 * Construtor da classe UserAppDaoException
	 *
	 * @param cause
	 */
	public CvcAppSystemException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construtor da classe UserAppDaoException
	 *
	 * @param message
	 * @param cause
	 */
	public CvcAppSystemException(String message, Throwable cause) {
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
	public CvcAppSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
