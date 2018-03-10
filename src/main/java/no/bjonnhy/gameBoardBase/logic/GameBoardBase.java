package no.bjonnhy.gameBoardBase.logic;

import java.util.ArrayList;
import java.util.HashMap;

import no.bjonnhy.gameBoardBase.enums.GameType;
import no.bjonnhy.gameBoardBase.event.DiceEvent;
import no.bjonnhy.gameBoardBase.event.DiceListener;
import no.bjonnhy.gameBoardBase.event.PieceEvent;
import no.bjonnhy.gameBoardBase.event.PieceListener;
import no.bjonnhy.gameBoardBase.event.PlayerEvent;
import no.bjonnhy.gameBoardBase.event.PlayerListener;
import no.bjonnhy.gameBoardBase.exception.IllegalPlayerNameException;
import no.bjonnhy.gameBoardBase.exception.NotEnoughPlayersException;

/**
 * Provides functionality to board games 
 * @author bjonnhy
 */
public class GameBoardBase {
	private static final int MIN_PLAYERS = 2; 
		
	/** The value of the current dice */
	private int dice;
	/** Holds the number of throws a player have thrown */
	private int numOfThrows;
	/** The id of the game */
	private int gameID;
	/** What type of game it is*/
	private GameType gameType;
	/** The players in the game */
	private ArrayList<Integer> players;
	
	private int[][] playerPieces;
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
		this.gameType = gameType;
		setUpGame();
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
		
		// stop with nepe
		if(notNullEntries(players) < MIN_PLAYERS) {
			throw new NotEnoughPlayersException();
		}
			
		// stop with ipne
		for(String player : players) {
			checkUsername(player);
		}
		
		// all good, setup!
		setUpGame();
		
		
		// fill / overwrite array with the
		// players
		int i = 0;
		int s = this.players.size();
		
		for(String p : players) {
			
			// increment i until we have a valid slot
			// in the list, unless we are full
			while(this.players.get(i) != -1 && i <= s) i++;
			
			// if we have filled all available slots
			// expand the list
			// else add in the available spot
			if(i == s) {
				this.players.add(s + 1);
				playerMap.put(s + 1, p);
			} else {
				this.players.set(i, i);
				playerMap.put(i, p);
			}
		}
		
	}
	
	/**
	 * Sets up all the differnt things needed
	 * so a game can be started
	 */
	private void setUpGame() {
		// set appropriate values
		dice = 0;
		numOfThrows = 0;
		
		// fill up players array
		players = new ArrayList<Integer>();
		
		// ensures "empty" array
		// empty slots are marked with -1
		for(int i : players) {
			players.set(i, -1);
		}
		
		playerMap = new HashMap<Integer, String>();
		
		
		// filling playerPieces
		int noOfPl = gameType.getPlayers();
		int noOfPi = gameType.getPieces();
		
		playerPieces = new int[noOfPl][noOfPi];
		
		for(int pl = 0; pl < noOfPl; pl++) {
			for(int pi = 0; pi < noOfPi; pi++ ) {
				playerPieces[pl][pi] = 0;
			}
		}
		
		// setting up listenerlists
		playerListeners = new ArrayList<PlayerListener>();
		pieceListeners  = new ArrayList<PieceListener>();
		diceListners	= new ArrayList<DiceListener>();
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
	
	/**
	 * Alerts all registered PlayerListeners about
	 * the given PlayerEvent.
	 * @param event - PlayerEvent that occurred
	 */
	public void alertPlayers(PlayerEvent event) {
		for(PlayerListener pl : playerListeners) {
			pl.playerStateChanged(event);
		}
	}
	
	/**
	 * Alerts all registered PieceListeners about
	 * the given PieceEvent.
	 * @param event - PieceEvent that occurred
	 */
	public void alertPieces(PieceEvent event) {
		for(PieceListener pl : pieceListeners) {
			pl.piceMoved(event);
		}
	}
	
	/**
	 * Alerts all registered DiceListeners about
	 * the given PieceEvent.
	 * @param event - PieceEvent that occurred
	 */
	public void alertDice(DiceEvent event) {
		for(DiceListener dl : diceListners) {
			dl.diceThrown(event);
		}
	}
}
