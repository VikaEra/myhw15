package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testSecondPlayerWin() {
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 90);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Player2", "Player1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerWin() {
        Player player1 = new Player(1, "Player1", 80);
        Player player2 = new Player(2, "Player2", 60);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStrengthsEqual() {
        Player player1 = new Player(1, "Player1", 80);
        Player player2 = new Player(2, "Player2", 80);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerNotRegistered() {
        Player player1 = new Player(1, "Player1", 80);

        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }

    @Test
    public void testSecondPlayerNotRegistered() {
        Player player2 = new Player(2, "Player2", 80);

        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player2", "Player1");
        });
    }

    @Test
    public void bothPlayersNotRegistered() {
        Player player1 = new Player(1, "Player1", 80);
        Player player2 = new Player(2, "Player2", 60);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player4", "Player5");
        });
    }
}


