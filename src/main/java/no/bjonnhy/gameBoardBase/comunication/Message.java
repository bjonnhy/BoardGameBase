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
	
	/**
	 * Gets the type of message this is
	 * @return A {@linkplain MessageType}
	 */
	public MessageType getMessageType() {
		return this.messageType;
	}

	/**
	 * Sets the {@linkplain MessageType} of this message.
	 * @param messageType - A {@linkplain MessageType}
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
	/**
	 * Gets the message in this Message
	 * @return The message
	 */
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * Sets the message in this Message
	 * @param message - The message to send
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return messageType.toString() + ": " + message;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Message) {
			Message msg = (Message) object;
			if(msg.getMessageType().equals(this.messageType)
					&& msg.getMessage().equals(this.message)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
