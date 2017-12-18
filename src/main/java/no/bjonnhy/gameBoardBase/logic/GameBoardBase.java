package no.bjonnhy.gameBoardBase.logic;

import java.util.ArrayList;
import java.util.HashMap;

import no.bjonnhy.gameBoardBase.enums.GameType;
import no.bjonnhy.gameBoardBase.event.DiceListener;
import no.bjonnhy.gameBoardBase.event.PieceListener;
import no.bjonnhy.gameBoardBase.event.PlayerListener;
import no.bjonnhy.gameBoardBase.exception.IllegalPlayerNameException;
import no.bjonnhy.gameBoardBase.exception.NotEnoughPlayersException;

/**
 * Provides functionality to board games 
 * @author bjonnhy
 */
public class GameBoardBase {
		
	/** The value of the current dice */
	private int dice;
	/** What type of game it is*/
	private GameType gameType;
	/** The players in the game */
	private ArrayList<Integer> players;
	/** Mapping the player index to the player name */
	private HashMap<Integer, String> playerMap; 
	
	/** Holds all the {@linkplain PlayerListener}s for this game */
	private static ArrayList<PlayerListener> playerListeners;
	/** Holds all the {@linkplain PieceListener}s for this game */
	private static ArrayList<PieceListener> pieceListeners;
	/** Holds all the {@linkplain DiceListener}s for this game */
	private static ArrayList<DiceListener> diceListners;
	
	
	/**
	 * Constructs a game where people can join
	 * later by {@linkplain}
	 * @param gameType
	 */
	public GameBoardBase(GameType gameType) {
		
	}
	
	/**
	 * Tries to construct a game with the given players
	 * @param gameType - The type of game
	 * @param players - A list of participating players
	 * @throws NotEnoughPlayersException if there are less players
	 * than requiered to start a game.
	 * @throws IllegalPlayerNameException if one of the players
	 * has an illegal name
	 */
	public GameBoardBase(GameType gameType, ArrayList<String> players)
		throws NotEnoughPlayersException,
			   IllegalPlayerNameException {
		
		if(notNullEntries(players) < 2) {
			throw new NotEnoughPlayersException();
		} else {
			
			for(String player : players) {
				checkUsername(player);
			}
		}
	}
	
	/**
	 * Tries to add a player to this game
	 * @param player - Name of the player
	 * @return True if the player was added, false
	 * otherwise
	 */
	public boolean addPlayer(String player) {
		try {
			checkUsername(player);
		} catch(IllegalPlayerNameException ipne) {
			// TODO might want to rethrow this
			return false;
		}
		
		int s = players.size();
		
		// TODO insert max value for the GameType
		if(s <= 1 && s >= 4) {
			players.add(s + 1);
			playerMap.put(s + 1, player);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Checks if the given player has a valid
	 * name (for this game)
	 * @param player - The player-name
	 * @throws IllegalPlayerNameException if the name is
	 * not allowed
	 */
	private void checkUsername(String player)
		throws IllegalPlayerNameException {
	
		if(player.startsWith("****")
			|| player.startsWith("!")) {
			
			throw new IllegalPlayerNameException();
		}
		
		for(int i : players) {
			if(player == playerMap.get(i)) {
				throw new IllegalPlayerNameException();
			}
		}
	}
	
	/**
	 * Checks any ArrayList for non null entries
	 * @param list - The ArrayList to check
	 * @return Number of non-null entries
	 */
	private int notNullEntries(ArrayList<?> list) {
		int i = 0;
		
		for(Object o : list) {
			if(o != null) i++;
		}
		
		return i;
	}

}
