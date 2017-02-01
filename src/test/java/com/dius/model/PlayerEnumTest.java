package com.dius.model;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Test the PlayerEnum class
 * Created by Jay on 1/02/2017.
 */
public class PlayerEnumTest {

    @Test
    public void shouldThrowExceptionWhenEnumValueIsMissing() {
        assertEquals(PlayerEnum.PLAYER1.getDisplayName(), "Player 1");
    }

    @Test
    public void enumContentsShouldBeCorrect() {
        List<PlayerEnum> playerEnums = Arrays.asList(PlayerEnum.values());

        assertThat(playerEnums, hasItems(PlayerEnum.PLAYER1));
        assertThat(playerEnums, hasItems(PlayerEnum.PLAYER2));
        assertThat(playerEnums.size(), is(2));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenLookingForUnsupportedEnum() {
        PlayerEnum.getByDisplayName("Player 3");
    }
}
