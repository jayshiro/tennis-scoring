package com.dius.service;

import com.dius.model.Game;
import com.dius.model.PlayerEnum;

/**
 * The service class that will do computations on the scores.
 * Created by Jay on 1/02/2017.
 */
public class ScoringService {

    private Game game;

    public ScoringService(Game game) {
        this.game = game;
    }

    /**
     * Add point to a given player
     * @param playerEnum enum object of the player who won a point
     */
    public void pointWonBy(PlayerEnum playerEnum) {
        if(winnerIsPresent()) {
            return;
        }

        game.addPointToPlayer(playerEnum);
    }

    public void printScore() {

    }

    /**
     * Check to see if any player has passed 3 points (40)
     * @return
     */
    private boolean onePlayerIsMoreThan3Points() {
        return (game.getPointsPlayer1() > 3 || game.getPointsPlayer2() > 3);
    }

    /**
     * Check to see if there is already a winner. A player wins if he/she goes over 3 points (40) and has a point
     * differential of 2 against the opposing player
     * @return
     */
    public boolean winnerIsPresent() {
        return (onePlayerIsMoreThan3Points() && getPointDiffBetweenPlayers() >= 2);
    }

    /**
     * Get the points difference between the two players
     * @return
     */
    private int getPointDiffBetweenPlayers() {
        return Math.abs(game.getPointsPlayer1() - game.getPointsPlayer2());
    }
}
