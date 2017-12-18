package no.bjonnhy.gameBoardBase.comunication;

import java.io.Serializable;

import no.bjonnhy.gameBoardBase.enums.MessageType;

/**
 * A class for sending messages through sockets
 * @author bjonnhy
 */
public class Message implements Serializable {
	
	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
	
	/** What kind of message this is */
	private MessageType messageType;
	
	/** Contents */
	private String message;
	
	/**
	 * Constructs a Message withouth a String message.
	 * Used by classes who extends this one.
	 * @param messageType - The type of message sent
	 */
	public Message(MessageType messageType) {
		this.messageType = messageType;
	}
	
	/**
	 * Constructs a Message with the given String message
	 * @param messageType - The type of message
	 * @param message - The actual message
	 */
	public Message(MessageType messageType, String message) {
		this.messageType = messageType;
		this.message = message;
	}

}
