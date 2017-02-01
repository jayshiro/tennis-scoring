package com.dius.service;

import com.dius.model.Game;
import com.dius.model.PlayerEnum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for ScoringService.
 * Created by Jay on 1/02/2017.
 */
public class ScoringServiceTest {

    private ScoringService scoringService;
    private Game game;

    @Before
    public void setup() {
        this.game = new Game(0,0);
        this.scoringService = new ScoringService(game);
    }

    @Test
    public void shouldReturnTrueIfWinnerIsPresent() {
        game.setPointsPlayer2(4);
        assertTrue(scoringService.winnerIsPresent());
    }

    @Test
    public void shouldReturnFalseIfThereIsStillNoWinner() {
        game.setPointsPlayer2(3);
        assertFalse(scoringService.winnerIsPresent());
    }

    @Test
    public void shouldAddPointsToCorrectPlayerWhenWon() {
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        assertEquals(game.getPointsPlayer1(), 3);

        scoringService.pointWonBy(PlayerEnum.PLAYER2);
        scoringService.pointWonBy(PlayerEnum.PLAYER2);
        assertEquals(game.getPointsPlayer2(), 2);
    }

    @Test
    public void shouldNotAddMorePointsOnceAWinnerHasEmerged() {
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        scoringService.pointWonBy(PlayerEnum.PLAYER2);
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        scoringService.pointWonBy(PlayerEnum.PLAYER2);
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        scoringService.pointWonBy(PlayerEnum.PLAYER1);
        scoringService.pointWonBy(PlayerEnum.PLAYER1);

        assertEquals(game.getPointsPlayer1(), 4);
        assertEquals(game.getPointsPlayer2(), 2);
    }
}
