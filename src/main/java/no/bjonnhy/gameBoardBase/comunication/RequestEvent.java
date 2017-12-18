package no.bjonnhy.gameBoardBase.comunication;

import no.bjonnhy.gameBoardBase.enums.MessageType;

/**
 * Used to send request to the server through sockets
 * @author bjonnhy
 */
public class RequestEvent extends Message {

	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	
	
	private int clientID;
	private int gameID;
	
	
	public RequestEvent() {
		super(MessageType.REQUEST);
	}

}
