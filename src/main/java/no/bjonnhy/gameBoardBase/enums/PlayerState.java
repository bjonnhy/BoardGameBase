package no.bjonnhy.gameBoardBase.enums;

/**
 * The different states a player can be in
 * @author bjonnhy
 */
public enum PlayerState {
	PLAYING   (0),
	WAITING   (1),
	LEFT_GAME (2),
	WON 	  (3);
	
	
	/** The int representing the state */
	private int state;
	
	/** Only for private use. Constructs with
	 * the different int assoiatives
	 * @param state - The state
	 */
	private PlayerState(int state) {
		this.state = state;
	}
	
	/**
	 * Gets the integer representative
	 * of the given PlayerState
	 * @param state - A {@linkplain PlayerState}
	 * @return An int represesentative of the
	 * {@linkplain PlayerState}, or -1 if
	 * none where found (should never occur)
	 */
	public int toInt(PlayerState state) {
		int i = -1;
		
		switch(state) {
		case PLAYING:   i = 0; break;
		case WAITING:   i = 1; break;
		case LEFT_GAME: i = 2; break;
		case WON:		i = 3; break;
		default:			   break;
		}
		
		return i;
	}
	
	/**
	 * Gets the PlayerState representative of the
	 * given integer
	 * @param i - An integer
	 * @return A PlayerState, or null if the given
	 * integer is not valid
	 */
	public PlayerState getPlayerState(int i) {
		PlayerState ps = null;
		
		switch(i) {
		case 0: ps = PLAYING;	break;
		case 1: ps = WAITING; 	break;
		case 2: ps = LEFT_GAME; break;
		case 3: ps = WON;		break;
		default:				break;
		}
		
		return ps;
	}
}
