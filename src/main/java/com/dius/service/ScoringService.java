package com.dius.service;

import com.dius.model.Game;

/**
 * The service class that will do computations on the scores.
 * Created by Jay on 1/02/2017.
 */
public class ScoringService {

    private Game game;

    public ScoringService(Game game) {
        this.game = game;
    }

    public void pointWonBy(String player) {

    }

    public void printScore() {

    }

    public boolean onePlayerIsMoreThan3Points() {
        return (game.getPointsPlayer1() > 3 || game.getPointsPlayer2() > 3);
    }
}
