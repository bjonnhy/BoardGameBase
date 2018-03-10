package no.bjonnhy.gameBoardBase.enums;

/**
 * Gametypes that the GameBoard can specifically handle
 * @author bjonnhy
 */
public enum GameType {
	CHESS		(2, 20),
	LUDO		(4,  4),
	TIC_TAC_TOE (2,  0),
	LADDERS		(6,  1);
	
	/** The number of players allowed in
	 * this type of game */
	private int noOfPlayers;
	/** The number of pieces each player 
	 * has in this type of game */
	private int noOfPieces;
	
	/**
	 * Only for private use
	 * @param players - Max number of players
	 * @param pieces - Max number of Pieces
	 */
	private GameType(int players, int pieces) {
		this.noOfPlayers = players;
		this.noOfPieces  = pieces;
	}
	
	
	/**
	 * Gets the maximum allowed players for this
	 * GameType
	 * @return The max number of players
	 */
	public int getPlayers() {
		return this.noOfPlayers;
	}
	
	/**
	 * Gets the number of pieces each player should
	 * have in this game 
	 * @return 
	 */
	public int getPieces() {
		return this.noOfPieces;
	}
}
