package no.bjonnhy.gameBoardBase.logic;

/**
 * Exception that marks that a game is full
 * @author bjonnhy
 */
@SuppressWarnings("serial")
public class GameFullException extends Exception {

	/** Default constructor */
	public GameFullException() {
		// empty / does nothing
	}

	/**
	 * Constructs the exception with the given message
	 * @param message - The exception message
	 */
	public GameFullException(String message) {
		super(message);
	}
}
