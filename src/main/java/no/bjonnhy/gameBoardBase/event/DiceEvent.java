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
	
	/**
	 * Gets the index of the player that caused the event
	 * @return The index of the player
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * Sets the index of the player who caused the event
	 * @param player - The new index of the player 
	 */
	public void setPlayer(int player) {
		this.player = player;
	}

	/**
	 * Gets the value of the thrown dice
	 * @return The value of the dice
	 */
	public int getDice() {
		return dice;
	}

	/**
	 * Sets the value of the dice throw
	 * @param dice - The value of the dice
	 */
	public void setDice(int dice) {
		this.dice = dice;
	}

	@Override
	public String toString() {
		return this.source.toString() + " / " + this.player + ", " + this.dice;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean ret = false;
		
		if(object instanceof DiceEvent) {
			DiceEvent de = (DiceEvent) object;
			ret = (this.source.equals(de.getSource())
					&& this.player == de.getPlayer()
					&& this.dice == de.getDice());
		}
		
		return ret;
	}

}
