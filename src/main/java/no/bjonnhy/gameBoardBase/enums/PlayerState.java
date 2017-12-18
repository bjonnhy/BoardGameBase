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
	

	private int n;
	
	private PlayerState(int n) {
		this.n = n;
	}
}
