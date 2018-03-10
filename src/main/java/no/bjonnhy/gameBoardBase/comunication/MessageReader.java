package no.bjonnhy.gameBoardBase.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageReader {
	private static Logger logger = Logger.getLogger(MessageReader.class.getName());

	private MessageReader() {
		// static class
	}
	
	/**
	 * Reads a {@linkplain Message} from the given socket
	 * @param socket - Socket to the server/client
	 * @return A {@linkplain Message} or null if nothing were read
	 */
	public static Message readMessage(Socket socket) {
		Message m = null;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			m = (Message) ois.readObject();
			
			ois.close();
		} catch (IOException ioe) {
			logger.log(Level.WARNING, ioe.getMessage(), ioe);
		} catch (ClassNotFoundException cnfe) {
			logger.log(Level.WARNING, cnfe.getMessage(), cnfe);
		}
		
		return m;
	}

}
