package com.dius.model;

/**
 * The model that will hold the data for the players points.
 * Created by Jay on 1/02/2017.
 */
public class Game {

    private int pointsPlayer1;
    private int pointsPlayer2;

    public Game(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
    }

    public void setPointsPlayer2(int pointsPlayer2) {
        this.pointsPlayer2 = pointsPlayer2;
    }

    public int getPointsPlayer1() {
        return pointsPlayer1;
    }

    public int getPointsPlayer2() {
        return pointsPlayer2;
    }

    /**
     * Adds a point to the player that won a point
     * @param player
     */
    public void addPointToPlayer(PlayerEnum player) {
        if(player == PlayerEnum.PLAYER1) {
            pointsPlayer1++;
        } else {
            pointsPlayer2++;
        }
    }
}
