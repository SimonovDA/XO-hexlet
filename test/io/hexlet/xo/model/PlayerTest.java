package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getName() throws Exception {

        final String inputValue = "Slava";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue,null);

        final String actuaValue = player.getName();


        assertEquals(expectedValue,actuaValue);
    }

    @Test
    public void getFigure() throws Exception {

        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null,inputValue);

        final Figure actuaValue = player.getFigure();


        assertEquals(expectedValue,actuaValue);
    }

}