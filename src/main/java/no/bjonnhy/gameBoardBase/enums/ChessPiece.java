package no.bjonnhy.gameBoardBase.enums;

/**
 * Provides enums for the different chess pieces
 * and an asosiated id (1 - 6 [inclusive])
 * @author bjonnhy
 */
public enum ChessPiece {
	KING   (1),
	QUEEN  (2),
	ROOK   (3),
	BISHOP (4),
	KNIGHT (5),
	PAWN   (6);
	
	/** The id of the ChessPiece */
	private int id;
	
	/**
	 * Default constructor. Needs id.
	 * (only private...)
	 * @param id - ID of the piece
	 */
	private ChessPiece(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the id of the ChessPiece
	 * @return - ID of the piece
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Gets the ChessPiece the given id is
	 * @param id - ID of a piece
	 * @return A ChessPiece value if valid id, null otherwise
	 */
	public static ChessPiece getPieceType(int id) {
		ChessPiece cp = null;
		
		switch (id) {
		case 1: cp = KING; 		break;
		case 2: cp = QUEEN;		break;
		case 3: cp = ROOK;		break;
		case 4: cp = BISHOP; 	break;
		case 5: cp = KNIGHT;	break;
		case 6: cp = PAWN;		break;
		default: 				break;
		}
		
		return cp;
	}
}
