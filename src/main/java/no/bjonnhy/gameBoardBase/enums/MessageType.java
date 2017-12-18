package no.bjonnhy.gameBoardBase.enums;

import java.io.Serializable;

/**
 * The diffent types of messages accepted by the server 
 * @author bjonnhy
 */
public enum MessageType implements Serializable {
	REQUEST,
	GAME,
	CHAT,
	ERROR;
}
