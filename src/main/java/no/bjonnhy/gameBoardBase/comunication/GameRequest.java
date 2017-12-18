package no.bjonnhy.gameBoardBase.comunication;

import no.bjonnhy.gameBoardBase.enums.GameType;
import no.bjonnhy.gameBoardBase.enums.MessageType;
import no.bjonnhy.gameBoardBase.enums.RequestType;
import no.bjonnhy.gameBoardBase.event.PieceEvent;

/**
 * Used to send request to the server through sockets
 * @author bjonnhy
 */
public class GameRequest extends Message {

	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	
	/** The ID of the client that sends the request */
	private int clientID;
	/** The ID of the game the client sends request for */
	private int gameID;
	/** The type of game */
	private GameType gameType;
	/** The type of request that is made */
	private RequestType requestType;
	/** Used to store info about a move a player wants to do*/
	private PieceEvent pieceEvent;
	
	/**
	 * Constructs a GameRequest with the given parameters. <br>
	 * This is for all {@linkplain RequestType}s, except {@linkplain RequestType#MOVE MOVE}.
	 * See the other constructor
	 * 
	 * @param clientID - The ID of the client that caused the event
	 * @param gameID - The ID of the game that caused the event
	 * @param gameType - The type of the game
	 * @param requestType - The type of request
	 */
	public GameRequest(int clientID, int gameID, GameType gameType, RequestType requestType) {
		super(MessageType.REQUEST);
		this.clientID = clientID;
		this.gameID = gameID;
		this.gameType = gameType;
		this.requestType = requestType;
		this.pieceEvent = null;
	}
	
	/**
	 * ONLY used when a player wants to move a piece,
	 * and therefore the {@linkplain RequestType} is locked
	 * as {@linkplain RequestType#MOVE MOVE}. <br>
	 * Constructs a GameRequest with the given parameters 
	 * 
	 * @param clientID - The ID of the client that asks
	 * @param gameID - The ID of the game that the player
	 * wants to move his piece in
	 * @param gameType - The type of game 
	 * @param pieceEvent - Used to hold information about a
	 * move the player wants to do
	 */
	public GameRequest(int clientID, int gameID, GameType gameType, PieceEvent pieceEvent) {
		super(MessageType.REQUEST);
		this.clientID = clientID;
		this.gameID = gameID;
		this.gameType = gameType;
		this.requestType = RequestType.MOVE;
		this.pieceEvent = pieceEvent;
	}

	
	/**
	 * Gets the ID of the client
	 * @return The ID of the client
	 */
	public int getClientID() {
		return clientID;
	}

	/**
	 * Sets the ID of the client
	 * @param clientID - The new clientID
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	/**
	 * Gets the ID of the game
	 * @return The ID of the game
	 */
	public int getGameID() {
		return gameID;
	}

	/**
	 * Sets the ID of the game
	 * @param gameID - The new gameID
	 */
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	/**
	 * Gets the {@linkplain GameType} of the game
	 * @return The {@linkplain GameType}
	 */
	public GameType getGameType() {
		return gameType;
	}

	/**
	 * Sets the {@linkplain GameType} of the game
	 * @param gameType - The new {@linkplain GameType}
	 */
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	/**
	 * Gets the {@linkplain RequestType} of this event
	 * @return The {@linkplain RequestType}
	 */
	public RequestType getRequestType() {
		return requestType;
	}

	/**
	 * Sets the {@linkplain RequestType} of this event
	 * @param requestType - The new {@linkplain RequestType}
	 */
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	/**
	 * Gets the {@linkplain PieceEvent} associated with
	 * this request.
	 * @return The {@linkplain PieceEvent}, or null if
	 * {@linkplain RequestType} is not {@linkplain RequestType#MOVE MOVE}
	 */
	public PieceEvent getPieceEvent() {
		return pieceEvent;
	}

	/**
	 * Sets the {@linkplain PieceEvent} associated with
	 * this request. Should not be used expect when
	 * {@linkplain RequestType} is {@linkplain RequestType#MOVE MOVE}.
	 * 
	 * @param pieceEvent - The new {@linkplain PieceEvent}
	 */
	public void setPieceEvent(PieceEvent pieceEvent) {
		this.pieceEvent = pieceEvent;
	}
	
	@Override
	public String toString() {
		String ret = "CID: " + this.clientID
					+ ", GID: " + this.gameID
					+ " - " + this.gameType
					+ ", Request: " + this.requestType;
		
		if(this.requestType.equals(RequestType.MOVE)) {
			ret	+= " -> " + this.pieceEvent.toString();
		}
		
		return ret;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean ret = false;
		
		if(object instanceof GameRequest) {
			GameRequest gr = (GameRequest) object;
			
			if(this.clientID == gr.getClientID()
				&& this.gameID == gr.gameID
				&& this.gameType.equals(gr.getGameType())
				&& this.requestType.equals(gr.getRequestType())) {
				
				if(gr.requestType.equals(RequestType.MOVE)) {
					ret = this.pieceEvent.equals(gr.getPieceEvent());
				} else {
					ret = true;
				}
			}
		}
		
		
		return ret;
	}
}
