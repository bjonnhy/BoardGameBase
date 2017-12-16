package no.bjonnhy.gameBoardBase;

import java.util.ArrayList;
import java.util.HashMap;

import no.bjonnhy.gameBoardBase.event.DiceListner;
import no.bjonnhy.gameBoardBase.event.PieceListener;
import no.bjonnhy.gameBoardBase.event.PlayerListener;

/**
 * Provides functionality to board games 
 * @author bjonnhy
 */
public class GameBoardBase {
		
	/** The value of the current dice */
	private int dice;
	/** The players in the game */
	private static ArrayList<Integer> players;
	/** Mapping the player index to the player name */
	private static HashMap<Integer, String> playerMap; 
	
	/** Holds all the {@linkplain PlayerListener}s for this game */
	private static ArrayList<PlayerListener> playerListeners;
	/** Holds all the {@linkplain PieceListener}s for this game */
	private static ArrayList<PieceListener> pieceListeners;
	/** Holds all the {@linkplain DiceListener}s for this game */
	private static ArrayList<DiceListner> diceListners;
	
	
	
	public GameBoardBase() {
	}

}
