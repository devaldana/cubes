package com.devspods.cubes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
public class Point<T extends Number> {

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
}