package com.dius;

import com.dius.model.Game;
import com.dius.model.PlayerEnum;
import com.dius.service.ScoringService;

import java.util.Scanner;

/**
 * Main class that handles the user input and prints out the result.
 * Created by Jay on 1/02/2017.
 */
public class TennisScoring {
    private static Game game = new Game(0, 0);
    private static ScoringService scoringService = new ScoringService(game);

    /**
     * Main method of the whole project
     * @param args
     */
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while(true) {
            input = sc.nextLine();

            process(input);

        }
    }

    /**
     * Processes the user input and prints out the result if requested.
     * @param input the user input String
     */
    public static void process(String input) {
        if(input.equals("quit")) {
            System.exit(0);
        }

        if(input.equals("score")) {
            System.out.println(scoringService.getScore());
        } else {
            scoringService.pointWonBy(PlayerEnum.getByDisplayName(input));
        }
    }
}
