package no.bjonnhy.gameBoardBase.enums;

import java.io.Serializable;

/**
 * Gametypes that the GameBoard can specifically handle
 * @author bjonnhy
 */
public enum GameType implements Serializable {
	CHESS,
	LUDO,
	TIC_TAC_TOE,
	LADDERS;
	
	/** Needs this so we can send this object through socket */
	private static final long serialVersionUID = 1L;
}
