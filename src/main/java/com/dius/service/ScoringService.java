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

    /**
     * Get the normal String scoring representation of each player's points
     * @param point the number of points the player currently has
     * @return
     */
    private String getNormalScore(int point){
        String result = "";
        switch (point) {
            case 0: result = "0";
                break;
            case 1: result = "15";
                break;
            case 2: result = "30";
                break;
            case 3: result = "40";
                break;
            default: throw new IllegalStateException("No more point after 40.");

        }
        return result;
    }

    /**
     * Returns the String representation of the current score between the two players
     * @return
     */
    public String getScore() {
        if(winnerIsPresent()) {
            if(game.getPointsPlayer1() > game.getPointsPlayer2()) {
                return PlayerEnum.PLAYER1.getDisplayName() + " wins";
            } else {
                return PlayerEnum.PLAYER2.getDisplayName() + " wins";
            }
        }

        if((game.getPointsPlayer1() >= 3 && game.getPointsPlayer2() >= 3)) {
            if(game.getPointsPlayer1() == game.getPointsPlayer2()) {
                return "Deuce";
            } else {
                if(game.getPointsPlayer1() > game.getPointsPlayer2()) {
                    return "Advantage " + PlayerEnum.PLAYER1.getDisplayName();
                } else {
                    return "Advantage " + PlayerEnum.PLAYER2.getDisplayName();
                }
            }
        }

        return getNormalScore(game.getPointsPlayer1()) + "-" + getNormalScore(game.getPointsPlayer2());
    }
}
