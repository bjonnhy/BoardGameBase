package no.bjonnhy.gameBoardBase.client;

import java.util.ArrayList;

/**
 * This class acts like the base for all gameclients that builds
 * on this package
 */
public class BaseClient {
    private int clientID;
    private String username;
    private ArrayList<Game> games;

    /**
     * Standard constructor for the baseclient. Needs the client ID
     * and the username.
     * @param clientID - This clients ID
     * @param username - The name of the user using this client
     */
    public BaseClient(int clientID, String username){
        this.clientID = clientID;
        this.username = username;
    }


    /**
     * Adds a {@linkplain Game} to this client
     * @param game - A {@linkplain Game} that this client has joined
     */
    public void addGame(Game game){
        if(this.games == null){
            this.games = new ArrayList<>();
        }

        this.games.add(game);
    }

    /**
     * Removes the {@linkplain Game} from this client
     * @param game - A {@linkplain Game} this client has left
     */
    public void removeGame(Game game){
        this.games.remove(game);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("CID: ").append(clientID).append(", ")
          .append("User: ").append(username).append(" -> ");

        for (Game game : games){
            sb.append(game.toString()).append(" | ");
        }

        return sb.toString();
    }
}
