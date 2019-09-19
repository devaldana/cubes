package com.devspods.cubes;

import com.devspods.cubes.domain.Point;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PointTests {

    @Test
    public void equalsAndHashCodeHappyPathTest() {

        Point<?> startingPoint = new Point<>(1, 1, 1);
        Point<?> endPoint = new Point<>(1, 1, 1);
        assertEquals(startingPoint, endPoint);
        assertEquals(startingPoint.hashCode(), endPoint.hashCode());

        Point<Byte> a = new Point<>(1, 1, 1, (byte) 1);
        Point<Byte> b = new Point<>(1, 1, 1, (byte) 1);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());

        Point<Short> c = new Point<>(1, 1, 1, (short) 1);
        Point<Short> d = new Point<>(1, 1, 1, (short) 1);
        assertEquals(c, d);
        assertEquals(c.hashCode(), d.hashCode());

        Point<Integer> e = new Point<>(1, 1, 1, 1);
        Point<Integer> f = new Point<>(1, 1, 1, 1);
        assertEquals(e, f);
        assertEquals(e.hashCode(), f.hashCode());

        Point<Long> g = new Point<>(1, 1, 1, 1L);
        Point<Long> h = new Point<>(1, 1, 1, 1L);
        assertEquals(g, h);
        assertEquals(g.hashCode(), h.hashCode());

        Point<Float> i = new Point<>(1, 1, 1, 1F);
        Point<Float> j = new Point<>(1, 1, 1, 1F);
        assertEquals(i, j);
        assertEquals(i.hashCode(), j.hashCode());

        Point<Double> k = new Point<>(1, 1, 1, 1.0D);
        Point<Double> l = new Point<>(1, 1, 1, 1.0D);
        assertEquals(k, l);
        assertEquals(k.hashCode(), l.hashCode());

        Point<BigInteger> m = new Point<>(1, 1, 1, BigInteger.ONE);
        Point<BigInteger> n = new Point<>(1, 1, 1, BigInteger.ONE);
        assertEquals(m, n);
        assertEquals(m.hashCode(), n.hashCode());

        Point<BigDecimal> o = new Point<>(1, 1, 1, BigDecimal.ONE);
        Point<BigDecimal> p = new Point<>(1, 1, 1, BigDecimal.ONE);
        assertEquals(o, p);
        assertEquals(o.hashCode(), p.hashCode());
    }

    @Test
    public void equalsAndHashCodeNotHappyPathTest() {

        Point<Byte> a = new Point<>(1, 1, 1, (byte) 1);
        Point<Byte> b = new Point<>(1, 1, 1, (byte) 2);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());

        Point<Short> c = new Point<>(1, 1, 1, (short) 1);
        Point<Short> d = new Point<>(1, 1, 2, (short) 1);
        assertNotEquals(c, d);
        assertNotEquals(c.hashCode(), d.hashCode());

        Point<Integer> e = new Point<>(1, 1, 1, 1);
        Point<Integer> f = new Point<>(1, 2, 1, 1);
        assertNotEquals(e, f);
        assertNotEquals(e.hashCode(), f.hashCode());

        Point<Long> g = new Point<>(1, 1, 1, 1L);
        Point<Long> h = new Point<>(2, 1, 1, 1L);
        assertNotEquals(g, h);
        assertNotEquals(g.hashCode(), h.hashCode());

        Point<?> i = new Point<>(1, 1, 2);
        Point<?> j = new Point<>(1, 1, 1);
        assertNotEquals(i, j);
        assertNotEquals(i.hashCode(), j.hashCode());

        Point<?> k = new Point<>(1, 2, 1);
        Point<?> l = new Point<>(1, 1, 1);
        assertNotEquals(k, l);
        assertNotEquals(k.hashCode(), l.hashCode());

        Point<?> m = new Point<>(2, 1, 1);
        Point<?> n = new Point<>(1, 1, 1);
        assertNotEquals(m, n);
        assertNotEquals(m.hashCode(), n.hashCode());
    }
}