package no.bjonnhy.gameBoardBase.logic;

/**
 * Exception that marks that a players name is illegal
 * @author bjonnhy
 */
@SuppressWarnings("serial")
public class IllegalPlayerNameException extends Exception {

	/** Default constructor */
	public IllegalPlayerNameException() {
		// empty / does nothing
	}
	
	/**
	 * Constructs the exception with the given message
	 * @param message - The exception message
	 */
	public IllegalPlayerNameException(String message) {
		super(message);
	}
}
