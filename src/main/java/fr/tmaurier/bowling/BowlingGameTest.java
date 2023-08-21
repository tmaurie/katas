package fr.tmaurier.bowling;

import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    @Test
    void edgeCasesTest() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assert game.score() == 0;
    }

    @Test
    void basicTest() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assert game.score() == 20;
    }

    @Test
    void spareTest() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assert game.score() == 16;
    }

    @Test
    void strikeTest() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }
        assert game.score() == 24;
    }

    @Test
    void perfectGameTest() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assert game.score() == 300;
    }

    @Test
    void allSparesTest() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 21; i++) {
            game.roll(5);
        }
        assert game.score() == 150;
    }
}
