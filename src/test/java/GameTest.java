import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {


    Game game = new Game();
    public Player player1 = new Player(1, "Name1", 233);
    public Player player2 = new Player(2, "Name2", 50);
    public Player player3 = new Player(3, "Name3", 233);
    public Player player4 = new Player(4, "Name4", 25);
    public Player player5 = new Player(5, "Name5", 400);


    @BeforeEach
    public void setUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void findPlayer() {

        ArrayList<Player> actual = game.getAllPlayers();
        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        expected.add(player4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundPlayer() {

        Assertions.assertEquals(1, game.round("Name1", "Name4"));
    }

    @Test
    public void roundPlayer2() {

        Assertions.assertEquals(2, game.round("Name2", "Name3"));
    }

    @Test
    public void roundPlayer3() {

        Assertions.assertEquals(0, game.round("Name1", "Name3"));
    }

    @Test
    public void NotRegisterPlayer2() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Name1", "Name5");
        });
    }

    @Test
    public void NotRegisterPlayer1() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Name5", "Name1");
        });
    }
}
