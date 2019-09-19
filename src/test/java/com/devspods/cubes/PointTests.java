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

    @Test
    @SuppressWarnings("unchecked")
    public void compareToTest() {

        Point a = new Point<>(0, 0, 0);
        Point b = new Point<>(0, 0, 0);
        assertEquals(0, a.compareTo(b));
        assertEquals(0, b.compareTo(a));

        Point c = new Point<>(1, 2, 3);
        Point d = new Point<>(2, 1, 0);
        assertEquals(1, c.compareTo(d));
        assertEquals(-1, d.compareTo(c));

        Point e = new Point<>(1, 0, 1);
        Point f = new Point<>(0, 1, 0);
        assertEquals(1, e.compareTo(f));
        assertEquals(-1, f.compareTo(e));

        Point g = new Point<>(0, 0, 0);
        Point h = new Point<>(1, 0, 0);
        assertEquals(-1, g.compareTo(h));
        assertEquals(1, h.compareTo(g));

        Point i = new Point<>(1, 1, 0);
        Point j = new Point<>(2, 2, 0);
        assertEquals(-1, i.compareTo(j));
        assertEquals(1, j.compareTo(i));

        Point k = new Point<>(0, 1, 2);
        Point l = new Point<>(3, 4, 5);
        assertEquals(-1, k.compareTo(l));
        assertEquals(1, l.compareTo(k));

        Point m = new Point<>(5, 4, 3);
        Point n = new Point<>(2, 1, 0);
        assertEquals(1, m.compareTo(n));
        assertEquals(-1, n.compareTo(m));
    }
}