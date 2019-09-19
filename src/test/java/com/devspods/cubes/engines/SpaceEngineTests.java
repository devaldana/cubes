package com.devspods.cubes.engines;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SpaceEngineTests {

    @Test
    public void setPointTest() {
        SpaceEngine<Integer> engine = new SpaceEngine<>(4);

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

        assertEquals(new BigDecimal("1"), engine.sumPointsInsideSpace(0, 0, 0, 0, 1, 0));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(0, 0, 0, 1, 1, 0));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(1, 0, 0, 1, 0, 1));
        assertEquals(new BigDecimal("2"), engine.sumPointsInsideSpace(0, 1, 0, 1, 1, 2));
        assertEquals(new BigDecimal("3"), engine.sumPointsInsideSpace(1, 0, 0, 1, 1, 2));
        assertEquals(new BigDecimal("6"), engine.sumPointsInsideSpace(0, 0, 0, 1, 0, 1));
        assertEquals(new BigDecimal("7"), engine.sumPointsInsideSpace(0, 0, 0, 2, 1, 1));
        assertEquals(new BigDecimal("12"), engine.sumPointsInsideSpace(0, 0, 0, 1, 1, 2));
        assertEquals(new BigDecimal("7"), engine.sumPointsInsideSpace(2, 2, 3, 3, 3, 3));
        assertEquals(new BigDecimal("13"), engine.sumPointsInsideSpace(3, 3, 0, 3, 3, 0));
        assertEquals(new BigDecimal("104"), engine.sumPointsInsideSpace(1, 2, 0, 1, 2, 3));
        assertEquals(new BigDecimal("104"), engine.sumPointsInsideSpace(1, 2, 1, 1, 2, 3));
        assertEquals(new BigDecimal("151"), engine.sumPointsInsideSpace(0, 0, 0, 3, 3, 3));
    }

    @Test
    public void sumSpaceTest() {

    }
}
