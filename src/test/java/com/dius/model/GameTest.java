package com.dius.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for Game
 * Created by Jay on 1/02/2017.
 */
public class GameTest {

    private Game game;

    @Before
    public void setup() {
        this.game = new Game(0, 0);
    }

    @Test
    public void shouldCorrectlyAddAPointToTheRightPlayer() {
        game.addPointToPlayer(PlayerEnum.PLAYER1);
        assertEquals(game.getPointsPlayer1(), 1);

        game.addPointToPlayer(PlayerEnum.PLAYER2);
        game.addPointToPlayer(PlayerEnum.PLAYER2);
        assertEquals(game.getPointsPlayer2(), 2);
    }
}
