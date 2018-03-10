package no.bjonnhy.gameBoardBase.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class that aids the server and client with sending
 * information over the sockets
 * @author bjonnhy
 */
public class MessageSender {
	private static Logger logger = Logger.getLogger(MessageSender.class.getName());
	
	private MessageSender() {
		// make the class static
	}
	
	/**
	 * Sends the given message through the socket
	 * @param message
	 */
	public static void sendMessage(Socket socket, Message message) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(message);
			oos.flush();
			
			oos.close();
		} catch (IOException ioe) {
			logger.log(Level.WARNING, ioe.getMessage(), ioe);
		}
	}
}
