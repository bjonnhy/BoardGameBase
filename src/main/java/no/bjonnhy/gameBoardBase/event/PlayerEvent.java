package no.bjonnhy.gameBoardBase.event;

import java.util.EventObject;

/**
 * Events about players in the game
 * @author bjonnhy
 */
@SuppressWarnings("serial")
public class PlayerEvent extends EventObject{
	// STATES
	/** Marks the active player */
	public static final int PLAYING = 0;
	/** Marks that the player is waiting for its turn */
	public static final int WAITING = 1;
	/** Marks that a player is moving (might want
	 * to use {@linkplain DiceEvent})*/
	public static final int MOVING = 2;
	/** Marks that a player left the game */
	public static final int LEFT_GAME = 3;
	/** Mars that a player has won */
	public static final int WON = 4;
	
	// MEMBERS
	/** The active player index */
	private int player;
	/** The state of the active player */
	private int state;
	
	/** Default constructor */
	public PlayerEvent(Object source) {
		super(source);
	}
	
	/**
	 * Constructs a PlayerEvent with the given parameters
	 * @param player - Player index
	 * @param state - The state
	 */
	public PlayerEvent(Object source, int player, int state) {
		super(source);
		this.player = player;
		this.state = state;
	}
}
