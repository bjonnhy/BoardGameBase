package no.bjonnhy.gameBoardBase.comunication;

import java.util.ArrayList;

/**
 * Used to keep track of a chat (serverside)
 * @author bjonnhy
 */
public class Chat {
	private int chatID;
	private String chatWindowName;
	private ArrayList<Integer> clientIDs;
	//private boolean isGameChat;

	/**
	 * Constructs a {@linkplain Chat} with the given params
	 * @param chatID - The chat ID
	 * @param chatWindowName - The UI-name of the window this chat
	 *                       resides in
	 */
	public Chat(int chatID, String chatWindowName) {
		this.chatID = chatID;
		this.chatWindowName = chatWindowName;
	}
	
	/**
	 * Adds a client ID to this chat
	 * @param clientID - The client ID to add
	 */
	public void addClient(int clientID) {
		if(clientIDs == null) {
			clientIDs = new ArrayList<Integer>();
		}
		
		clientIDs.add(clientID);
	}
	
	/**
	 * Removes a client ID from this chat
	 * @param clientID - The ID to remove
	 */
	public void removeClient(int clientID) {
		clientIDs.remove(clientID);
	}

}
