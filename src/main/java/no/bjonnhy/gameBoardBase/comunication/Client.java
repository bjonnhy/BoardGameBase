package no.bjonnhy.gameBoardBase.comunication;

import java.net.Socket;
import java.util.ArrayList;

/**
 * Holds information about one client (serverside)
 * @author bjonnhy
 */
public class Client {
	/** The ID of the client */
	private int clientID;
	/** The name of the user using this client */
	private String username;
	/** Holds all games this client is in */
	private ArrayList<Integer> gameIDs;
	/** Holds all chats this client is in */
	private ArrayList<Integer> chatIDs;
	
	private Socket clientSocket;
	
	/**
	 * Basic constructor
	 * @param clientID - The ID of the client
	 * @param clientSocket - The socket that is connected to
	 *                     one given client
	 */
	public Client(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	/**
	 * Sets the ID of this client
	 * @param clientID - The ID to set
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	/**
	 * Gets the socket this client has
	 * @return The socket this client hass
	 */
	public Socket getSocket() {
		return clientSocket;
	}
	
	/**
	 * Adds the given game to this clients list of games
	 * @param gameID - ID of a game this client joins
	 */
	public void joinGame(int gameID) {
		if(gameIDs == null) {
			gameIDs = new ArrayList<Integer>();
		}
		
		// TODO: print this to gamechat: $(username) joined the game!
		
		gameIDs.add(gameID);
	}
	
	/**
	 * Removes the given game from this clients list
	 * of games
	 * @param gameID - The ID of the game to leave
	 */
	public void leaveGame(int gameID) {
		// TODO: print to this gamechat: $(username) left the game
		gameIDs.remove(gameID);
	}

	/**
	 * Adds the given chat to this clients list of chats
	 * @param chatID - ID og a chat this client joins
	 */
	public void joinChat(int chatID) {
		if(chatIDs == null) {
			chatIDs = new ArrayList<Integer>();
		}
		
		// TODO: print this to chat: $(username) joined the chat!
		
		chatIDs.add(chatID);
	}
	
	public void leaveChat(int chatID) {
		// TODO: print to this gamechat: $(username) left the game
		chatIDs.remove(chatID);
	}
	
	public void sendMessage(Message message) {
		MessageSender.sendMessage(clientSocket, message);
	}
}
