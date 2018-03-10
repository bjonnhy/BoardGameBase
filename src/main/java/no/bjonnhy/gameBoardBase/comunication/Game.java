package no.bjonnhy.gameBoardBase.comunication;

import no.bjonnhy.gameBoardBase.enums.GameType;

/**
 * This class should hold information about one game
 * client side
 */
public class Game {
    /** Holds the {@linkplain GameType} for this game */
    private GameType gameType;
    /** Holds the ID (from server) of this game */
    private int gameID;

    /**
     * Constructs a standard game object with the given params
     * @param gameType - The type of game this is
     * @param gameID - The ID of this game
     */
    public Game(GameType gameType, int gameID){
        this.gameType = gameType;
        this.gameID = gameID;
    }

    /**
     * Gets the gameID of this game
     * @return - The ID of the game
     */
    public int getGameID(){
        return this.gameID;
    }

    /**
     * Sets this games ID
     * @param id - New ID
     */
    public void setGameID(int id){
        this.gameID = id;
    }

    /**
     * Gets the Type of this game
     * @return - The type of game
     */
    public GameType getGameType(){
        return this.gameType;
    }

    /**
     * Sets the {@linkplain GameType} of this game
     * @param gameType - A {@linkplain GameType}
     */
    public void setGameType(GameType gameType){
        this.gameType = gameType;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("GT: ").append(gameType).append(", ")
          .append("GID: ").append(gameID);

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Game){
            Game g = (Game) obj;
            if(   this.gameID == g.getGameID()
               && this.gameType == g.getGameType()){
                return true;
            }
        }

        return false;
    }
}
