package com.devspods.cubes.engines;

import com.devspods.cubes.domain.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

// This class should NOT be extended
public final class SpaceEngineHelper {

    private static final Logger logger = LoggerFactory.getLogger(SpaceEngineHelper.class);
    private static final int NEGATIVE = -1;

    // Utility class, no reasons to have instances of it
    private SpaceEngineHelper() {}

    public static boolean isPointInsideSpace(final Point startingPoint,
                                             final Point endPoint,
                                             final Point targetPoint) {
        logger.info("Validating if {} is inside enclosing space", targetPoint);
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

    public static <T extends Number> boolean isNegative(final T value) {
        return new BigDecimal(value.toString()).signum() == NEGATIVE;
    }

    @SuppressWarnings("unchecked")
    public static Point greatest(final Point pointA, final Point pointB) {
        logger.info("Calculating greatest point");
        if(pointA.equals(pointB)) return pointA;
        if(pointA.compareTo(pointB) > 0) return pointA;
        return pointB;
    }
}
