package no.bjonnhy.gameBoardBase.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import no.bjonnhy.gameBoardBase.comunication.Chat;
import no.bjonnhy.gameBoardBase.comunication.Client;
import no.bjonnhy.gameBoardBase.comunication.Game;
import no.bjonnhy.gameBoardBase.comunication.Message;
import no.bjonnhy.gameBoardBase.comunication.MessageReader;
import no.bjonnhy.gameBoardBase.comunication.RequestMessage;

/**
 * Contains some standard methods for the server for
 * boardgames built on this package
 * @author bjonnhy
 */
public class BaseServer {
	/** The standard port for a gameserver */
	public static final int STD_PORT = 12345;
	
	private static Logger logger = Logger.getLogger(BaseServer.class.getName());
	
	/** Keeps track of the socket we comuicate with */
	private ServerSocket serverSocket;
	/** Controlls threads */
	private ExecutorService executorService;
	/** Holds a list of all conected clients */
	private ArrayList<Client> clients;
	/** Holds a list of all hosted games */
	private ArrayList<Game> games;
	/** Holds a list of all hosted chats */
	private ArrayList<Chat> chats;
	/** Holds the executor status */
	private boolean shutdown = false;

	/**
	 * Calls standard constructor with standard params
	 */
	public BaseServer() {
		this(STD_PORT);
	}
	
	/**
	 * Standard constructor. We need both params to establish
	 * connection
	 * @param port - The port the socket should listen to
	 */
	public BaseServer(int port) {
		try {
			this.serverSocket = new ServerSocket(port);			
		} catch (IOException ioe) {
			logger.log(Level.WARNING, ioe.getMessage(), ioe);
		}
		
		executorService = Executors.newCachedThreadPool();
		
		
		connectionMonitor();
		//startResponseHandler();
	}
	

	private void startResponseHandler() {
		
	}
	
	/**
	 * Handles all new connections to this server
	 */
	private void connectionMonitor() {
		executorService.execute(() ->{
			while(!shutdown) {
				try {
					Socket s = serverSocket.accept();
					Client client = new Client(s);
					
					synchronized (clients) {
						Message msg = MessageReader.readMessage(client.getSocket());
						
						while(msg == null) {
							TimeUnit.MILLISECONDS.sleep(50);
							msg = MessageReader.readMessage(client.getSocket());
						}
						
						handleInitMessage(msg);
					}
					
				} catch (IOException ioe) {
					logger.log(Level.WARNING, ioe.getMessage(), ioe);
				} catch (InterruptedException ie) {
					logger.log(Level.WARNING, ie.getMessage(), ie);
				}
			}
		});
	}
	
	/**
	 * Handles the first connections we have with a client, should it
	 * be a new one, which who have to register, or a returning client
	 * which are just logging in
	 * @param message - The {@linkplain Message} recieved
	 */
	private void handleInitMessage(Message message) {
		if(message instanceof RequestMessage) {
			RequestMessage reqMessage = (RequestMessage) message;
			
			switch (reqMessage.getRequestType()) {
				case LOGIN:
					System.err.println(reqMessage.getMessage());
					break;
					
				case REGISTRATION:
					break;
					
				default:
					logger.log(Level.INFO, "Wrong request. Was: " + reqMessage.getRequestType());
					break;
			}
		} else {
			logger.log(Level.INFO, "Wrong message. Was: " + message.getMessageType());
		}
	}
}
