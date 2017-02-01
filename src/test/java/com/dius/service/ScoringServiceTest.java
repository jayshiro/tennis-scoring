package com.dius.service;

import com.dius.model.Game;
import org.junit.Before;
import org.junit.Test;

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
}
