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

}
