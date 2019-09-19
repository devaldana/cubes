package com.devspods.cubes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static java.util.Objects.isNull;

@Data
@AllArgsConstructor
public class Point<T extends Number> implements Comparable<Point<T>> {

    private int x;
    private int y;
    private int z;
    @EqualsAndHashCode.Exclude
    private T value;

    public Point(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(final Point<T> point) {
        if(isNull(point)) return 1;
        if(this.equals(point)) return 0;

        if(this.z > point.z) return 1;
        if(this.z < point.z) return -1;
        if(this.y > point.y) return 1;
        if(this.y < point.y) return -1;
        if(this.x > point.x) return 1;

        return -1;
    }
}