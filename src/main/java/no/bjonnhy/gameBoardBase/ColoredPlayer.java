package no.bjonnhy.gameBoardBase;

/**
 * Enum for the players in a game
 * where each player has a distincitive color
 * @author bjonnhy
 */
public enum ColoredPlayer {
	RED			 (0),
	BLUE		 (1),
	YELLOW		 (2),
	GREEN		 (3),
	BLACK		 (4),
	MAGENTA		 (5),
	PURPLE		 (6),
	PINK		 (7),
	ORANGE		 (8),
	BROWN		 (9),
	TURQUOISE	(10),
	GRAY		(11),
	WHITE		(12);
	
	/** Holds the id of the player */
	private int id;

	
	private ColoredPlayer(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the ColoredPlayer with the given id
	 * @param id - ID of a player
	 * @return A ColoredPlayer if valid id, null otherwise
	 */
	public ColoredPlayer getPlayer(int id) {
		ColoredPlayer cp = null;
		
		switch(id){
			case  0: cp = RED; 		break;
			case  1: cp = BLUE;		break;
			case  2: cp = YELLOW; 	break;
			case  3: cp = GREEN;	break;
			case  4: cp = BLACK;	break;
			case  5: cp = MAGENTA;	break;
			case  6: cp = PURPLE;	break;
			case  7: cp = PINK;		break;
			case  8: cp = ORANGE;	break;
			case  9: cp = BROWN;	break;
			case 10: cp = TURQUOISE;break;
			case 11: cp = GRAY;		break;
			case 12: cp = WHITE;	break;
			default:				break;
		}
		
		return cp;
	}
	
}
