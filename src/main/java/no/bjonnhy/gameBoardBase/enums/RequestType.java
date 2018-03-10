package no.bjonnhy.gameBoardBase.enums;

/**
 * The different request the server handles.
 * Some of these are only valid for certain
 * requests
 * @author bjonnhy
 */
public enum RequestType {
	ROLL_DICE,
	MOVE,
	JOIN_GAME,
	LEAVE_GAME,
	JOIN_CHAT,
	LEAVE_CHAT,
	LOGIN,
	REGISTRATION;
}
