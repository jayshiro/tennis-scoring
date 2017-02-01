package com.dius;

import com.dius.model.PlayerEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Test class for TennisScoring
 * Created by Jay on 1/02/2017.
 */
public class TennisScoringTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldAddAScoreToPlayer1AndPrintScoreAfterwards(){
        TennisScoring.process(PlayerEnum.PLAYER1.getDisplayName());
        TennisScoring.process("score");
        assertEquals(outContent.toString().trim(), "15-0");
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowANullPointerExceptionWhenPassingAnInvalidPlayerAsInput() {
        TennisScoring.process("Player 3");
    }

}
