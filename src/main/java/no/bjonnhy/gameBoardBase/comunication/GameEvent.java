package no.bjonnhy.gameBoardBase.comunication;

import java.util.EventObject;

import no.bjonnhy.gameBoardBase.enums.GameType;
import no.bjonnhy.gameBoardBase.enums.MessageType;

/**
 * Event used to send game related events from client to server
 * @author bjonnhy
 */
public class GameEvent extends Message {
	
	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	
	/** The type of game */
	private GameType gameType;
	/** The ID of the client */
	private int clientID;
	/** The ID of the game */
	private int gameID;
	/** The event that occurred */
	private EventObject event;

	/**
	 * Constructs a game event with the given parameters
	 * @param gameType - The type of game that is played
	 * @param gameID - The id of the game
	 * @param clientID - The id of the client
	 * @param event - The actual event that occured
	 */
	public GameEvent(GameType gameType, int clientID, int gameID, EventObject event) {
		super(MessageType.GAME);
		this.gameType = gameType;
		this.clientID = clientID;
		this.gameID = gameID;
		this.event = event;
	}

	/**
	 * Gets the type of game this is sent from
	 * @return The {@linkplain GameType} of this game
	 */
	public GameType getGameType() {
		return gameType;
	}

	/**
	 * Sets the type of game this is sent from
	 * @param gameType - A {@linkplain GameType}
	 */
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	/**
	 * Gets the ID of the client who sendt this.
	 * @return The senders clientID
	 */
	public int getClientID() {
		return clientID;
	}

	/**
	 * Set the senders clientID
	 * @param clientID - The new clientID
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	/**
	 * Gets the ID of the game that produced the event
	 * @return The ID of the game
	 */
	public int getGameID() {
		return gameID;
	}

	/**
	 * Sets the ID of the game that produced this event
	 * @param gameID - The ID of a game
	 */
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	/**
	 * Gets the event that happened
	 * @return The event
	 */
	public EventObject getEvent() {
		return event;
	}

	/**
	 * Set the event that happened
	 * @param event - The event
	 */
	public void setEvent(EventObject event) {
		this.event = event;
	}
	
	@Override
	public String toString() {
		return gameType.toString()
				+ " - CID: " + this.clientID
				+ ", GID: "  + this.gameID
				+ " -> "     + this.event.toString();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof GameEvent) {
			GameEvent ge = (GameEvent) object;
			
			if(this.gameType.equals(ge.getGameType())
				&& this.clientID == ge.getClientID()
				&& this.gameID == ge.getGameID()
				&& this.event.equals(ge.getEvent()))
			{
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
