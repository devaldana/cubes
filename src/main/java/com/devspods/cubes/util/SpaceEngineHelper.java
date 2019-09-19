package com.devspods.cubes.util;

import com.devspods.cubes.domain.Point;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public final class SpaceEngineHelper {

    // Utility class, no reasons to have instances of it
    private SpaceEngineHelper() {}

    public static boolean isThePointInsideTheSpace(final Point<?> startingPoint,
                                                   final Point<?> endPoint,
                                                   final Point<?> targetPoint) {

        if(isNull(startingPoint) || isNull(endPoint))
            throw new IllegalArgumentException("Space must have a starting point and an end point");

        if(isNull(targetPoint)) return false;

        return targetPoint.getX() >= startingPoint.getX() && targetPoint.getX() <= endPoint.getX() &&
               targetPoint.getY() >= startingPoint.getY() && targetPoint.getY() <= endPoint.getY() &&
               targetPoint.getZ() >= startingPoint.getZ() && targetPoint.getZ() <= endPoint.getZ();
    }

    public static <T extends Number> BigDecimal getPointValue(final Point<T> point) {
        return new BigDecimal(point.getValue().toString());
    }
}
