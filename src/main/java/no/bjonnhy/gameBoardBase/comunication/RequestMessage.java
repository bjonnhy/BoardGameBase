package no.bjonnhy.gameBoardBase.comunication;

import no.bjonnhy.gameBoardBase.enums.MessageType;
import no.bjonnhy.gameBoardBase.enums.RequestType;

/**
 * Handles all request (done to the server from a client) messages
 * @author bjonnhy
 */
public class RequestMessage extends Message {
	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	
	/** Holds which type of request this message is */
	private RequestType requestType;

	/**
	 * Standard constructor for a request message
	 * @param messageType - A type from {@linkplain MessageType}
	 * @param requestType - A type from {@linkplain RequestType}
	 * @param message - The message content
	 */
	public RequestMessage(MessageType messageType, RequestType requestType, String message) {
		super(messageType, message);
		this.requestType = requestType;
	}

	/**
	 * Sets the type of request this message is
	 * @param requestType - A type from {@linkplain RequestType}
	 */
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	
	/**
	 * Gets the type of request this message is
	 * @return A type from {@linkplain RequestType}
	 */
	public RequestType getRequestType() {
		return this.requestType;
	}
}
