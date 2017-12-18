package no.bjonnhy.gameBoardBase.exception;

/**
 * Exception for not enough players in a game
 * @author bjonnhy
 */
@SuppressWarnings("serial")
public class NotEnoughPlayersException extends Exception {

	/** Default constructor */
	public NotEnoughPlayersException() {
		// does nothing
	}

	/**
	 * Constructs the exception with the given string
	 * @param message - The exception message
	 */
	public NotEnoughPlayersException(String message) {
		super(message);
	}
}
