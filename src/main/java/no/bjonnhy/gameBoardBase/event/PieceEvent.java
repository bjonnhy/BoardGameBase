package no.bjonnhy.gameBoardBase.event;

import java.util.EventObject;

/**
 * Contains information about a PieceEvent
 * @author bjonnhy
 */
public class PieceEvent extends EventObject {
	
	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	
	/** The index of the player that moved his piece */
	private int player;
	/** The index of the piece that moved */
	private int piece;
	/** The tile the player moves from */
	private int from;
	/** The tile the player moves to */
	private int to;
	
	/**
	 * Default constructor. Needs a source
	 * @param source - The source of the event
	 */
	public PieceEvent(Object source) {
		super(source);
	}
	
	/**
	 * Constructs a PieceEvent with given arguments
	 * @param source - The source of the event
	 * @param player - Index of the player that moved
	 * @param piece - Index of the piece that the player moved
	 * @param from - The tile the player moved from
	 * @param to - The tile the player moved to
	 */
	public PieceEvent(Object source, int player, int piece, int from, int to) {
		super(source);
		this.player = player;
		this.piece = piece;
		this.from = from;
		this.to = to;
	}

	
	/**
	 * Gets the index of the player that caused
	 * the event
	 * @return The playerindex
	 */
	public int getPlayer() {
		return player;
	}

	
	/**
	 * Sets the index of the player that caused
	 * the event
	 * @param player - The index of the player
	 */
	public void setPlayer(int player) {
		this.player = player;
	}

	/**
	 * Gets the index of the piece that the player
	 * moved
	 * @return The index of the piece
	 */
	public int getPiece() {
		return piece;
	}

	/**
	 * Set the index of the piece that the player
	 * moved
	 * @param piece - The index of the piece
	 */
	public void setPiece(int piece) {
		this.piece = piece;
	}

	/**
	 * Gets the tile the player moved from
	 * @return The tile to move from
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * Sets the tile the player moves from
	 * @param from - The tile to move from
	 */
	public void setFrom(int from) {
		this.from = from;
	}

	/**
	 * Gets the tile the player moved to
	 * @return The tile to move to
	 */
	public int getTo() {
		return to;
	}

	/**
	 * Sets the tile the player moves to
	 * @param to - The tile to move to
	 */
	public void setTo(int to) {
		this.to = to;
	}
}
