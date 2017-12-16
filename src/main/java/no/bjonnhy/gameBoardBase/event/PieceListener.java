package no.bjonnhy.gameBoardBase.event;

/**
 * Listens for change in pieces
 * @author bjonnhy
 */
public interface PieceListener {

	/**
	 * Handle that a piece has moved
	 * @param event - A {@linkplain PieceEvent}
	 */
	public void piceMoved(PieceEvent event);
}
