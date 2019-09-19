package com.devspods.cubes.engines;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SpaceEngineTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    private SpaceEngine<Integer> engine;

    @Before
    public void init() {
        engine = new SpaceEngine<>(4);

        engine.setPoint(0, 0, 1, 4);
        engine.setPoint(0, 0, 2, 4);
        engine.setPoint(1, 0, 0, 1);
        engine.setPoint(1, 0, 1, 1);
        engine.setPoint(0, 1, 0, 1);
        engine.setPoint(1, 1, 2, 1);
        engine.setPoint(2, 2, 3, 7);
        engine.setPoint(3, 2, 2, 6);
        engine.setPoint(2, 3, 1, 9);
        engine.setPoint(3, 3, 0, 13);
        engine.setPoint(1, 2, 1, 18);
        engine.setPoint(1, 2, 2, 57);
        engine.setPoint(1, 2, 3, 29);
    }

    @Test
    public void setPointTest() {

        assertEquals(new BigDecimal("1"), engine.sumPointsInsideSpace(0, 0, 0, 0, 1, 0));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(0, 0, 0, 1, 1, 0));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(1, 0, 0, 1, 0, 1));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(0, 1, 0, 1, 1, 2));
        assertEquals(new BigDecimal("3"), engine.sumPointsInsideSpace(1, 0, 0, 1, 1, 2));
        assertEquals(new BigDecimal("6"), engine.sumPointsInsideSpace(0, 0, 0, 1, 0, 1));
        assertEquals(new BigDecimal("7"), engine.sumPointsInsideSpace(0, 0, 0, 2, 1, 1));
        assertEquals(new BigDecimal("7"), engine.sumPointsInsideSpace(2, 2, 3, 3, 3, 3));
        assertEquals(new BigDecimal("12"), engine.sumPointsInsideSpace(0, 0, 0, 1, 1, 2));
        assertEquals(new BigDecimal("13"), engine.sumPointsInsideSpace(3, 3, 0, 3, 3, 0));
        assertEquals(new BigDecimal("104"), engine.sumPointsInsideSpace(1, 2, 0, 1, 2, 3));
        assertEquals(new BigDecimal("104"), engine.sumPointsInsideSpace(1, 2, 1, 1, 2, 3));
        assertEquals(new BigDecimal("151"), engine.sumPointsInsideSpace(0, 0, 0, 3, 3, 3));
        assertEquals(new BigDecimal("1"), engine.sumPointsInsideSpace(0, 1, 0, 0, 0, 0));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(1, 1, 0, 0, 0, 0));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(1, 0, 1, 1, 0, 0));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(1, 1, 2, 0, 1, 0));
        assertEquals(new BigDecimal("3"), engine.sumPointsInsideSpace(1, 1, 2, 1, 0, 0));
        assertEquals(new BigDecimal("6"), engine.sumPointsInsideSpace(1, 0, 1, 0, 0, 0));
        assertEquals(new BigDecimal("7"), engine.sumPointsInsideSpace(2, 1, 1, 0, 0, 0));
        assertEquals(new BigDecimal("7"), engine.sumPointsInsideSpace(3, 3, 3, 2, 2, 3));
        assertEquals(new BigDecimal("12"), engine.sumPointsInsideSpace(1, 1, 2, 0, 0, 0));
        assertEquals(new BigDecimal("13"), engine.sumPointsInsideSpace(3, 3, 0, 3, 3, 0));
        assertEquals(new BigDecimal("104"), engine.sumPointsInsideSpace(1, 2, 3, 1, 2, 0));
        assertEquals(new BigDecimal("104"), engine.sumPointsInsideSpace(1, 2, 3, 1, 2, 1));
        assertEquals(new BigDecimal("151"), engine.sumPointsInsideSpace(3, 3, 3, 0, 0, 0));
        assertEquals(new BigDecimal("76"), engine.sumPointsInsideSpace(1, 1, 0, 2, 2, 2));
        assertEquals(new BigDecimal("27"), engine.sumPointsInsideSpace(1, 2, 1, 2, 3, 1));
        assertEquals(new BigDecimal("84"), engine.sumPointsInsideSpace(1, 2, 1, 2, 3, 2));
        assertEquals(new BigDecimal("27"), engine.sumPointsInsideSpace(2, 3, 1, 1, 2, 1));
    }

    @Test
    public void notEnclosingSpaceTest() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Points are not enclosing any space, please validate the starting and the end point");
        assertEquals(new BigDecimal("84"), engine.sumPointsInsideSpace(1, 2, 0, 2, 1, 2));
    }
}
