package GameBoardBase;

import junit.framework.TestCase;
import no.bjonnhy.gameBoardBase.client.BaseClient;
import no.bjonnhy.gameBoardBase.comunication.Game;
import no.bjonnhy.gameBoardBase.enums.GameType;

/**
 * Thestcase for the classes in the client package
 */
public class Client_Test extends TestCase {

    public void testClientAndGame() {
        BaseClient bc = new BaseClient(24, "Mamma Mia");
        Game game1 = new Game(GameType.CHESS, 54);
        Game game2 = new Game(GameType.LUDO, 55);

        bc.addGame(game1);
        bc.addGame(game2);

        assertEquals("CID: 24, User: Mamma Mia -> GT: CHESS, GID: 54 | GT: LUDO, GID: 55 | ", bc.toString());

        bc.removeGame(game2);
        assertEquals("CID: 24, User: Mamma Mia -> GT: CHESS, GID: 54 | ", bc.toString());

        assertEquals(54, game1.getGameID());
        assertEquals(GameType.LUDO, game2.getGameType());

        game1.setGameType(GameType.LADDERS);

        assertEquals(GameType.LADDERS, game1.getGameType());
    }
}
