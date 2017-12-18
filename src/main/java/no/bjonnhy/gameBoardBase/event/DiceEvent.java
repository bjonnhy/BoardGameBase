package no.bjonnhy.gameBoardBase.event;

import java.util.EventObject;

/**
 * Contains information about a DiceEvent
 * @author bjonnhy
 */
public class DiceEvent extends EventObject {
	
	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	/** The index of the player that threw */
	private int player;
	/** The value of the thrown dice */
	private int dice;

	/**
	 * Default constructor. Needs a source
	 * @param source - Who caused the event
	 */
	public DiceEvent(Object source) {
		super(source);
	}
	
	/**
	 * Constructs a DiceEvent with the given parameters
	 * @param source - Who caused the event
	 * @param player - Index of player who threw
	 * @param dice - Vaule of dice thrown
	 */
	public DiceEvent(Object source, int player, int dice) {
		super(source);
		this.player = player;
		this.dice = dice;
	}

}
