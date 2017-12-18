package no.bjonnhy.gameBoardBase.event;

import java.util.EventObject;

import no.bjonnhy.gameBoardBase.enums.PlayerState;

/**
 * Events about players in the game
 * @author bjonnhy
 */
public class PlayerEvent extends EventObject{
	
	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	
	/** The active player index */
	private int player;
	/** The state of the active player */
	private PlayerState state;
	
	/**
	 * Constructs a PlayerEvent with the given parameters
	 * @param player - Player index
	 * @param state - The state
	 */
	public PlayerEvent(Object source, int player, PlayerState state) {
		super(source);
		this.player = player;
		this.state = state;
	}

	
	/**
	 * Gets the player that caused the event
	 * @return The players index
	 */
	public int getPlayer() {
		return player;
	}

	
	/**
	 * Sets the players index
	 * @param player - The new player index
	 */
	public void setPlayer(int player) {
		this.player = player;
	}

	
	/**
	 * Gets the {@linkplain PlayerState} this
	 * player is in
	 * @return The {@linkplain PlayerState}
	 */
	public PlayerState getState() {
		return state;
	}

	
	/**
	 * Sets the {@linkplain PlayerState} the player
	 * is in
	 * @param state - {@linkplain PlayerState} of this player
	 */
	public void setState(PlayerState state) {
		this.state = state;
	}
}
