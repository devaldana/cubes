package com.devspods.cubes.engines;

import com.devspods.cubes.domain.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static com.devspods.cubes.engines.SpaceEngineHelper.*;
import static java.util.Objects.isNull;

public class SpaceEngine<T extends Number> {
    private static final Logger logger = LoggerFactory.getLogger(SpaceEngine.class);

    private static final Point<?> SPACE_STARTING_POINT = new Point<>(0, 0, 0);
    private final Point<?> SPACE_END_POINT;

    private T[][][] space;
    private Set<Point<T>> touchedPoints = new HashSet<>();

    @SuppressWarnings("unchecked")
    public SpaceEngine(final int spaceDepth) {
        validateParams(spaceDepth);
        final int depth = spaceDepth - 1;
        SPACE_END_POINT = new Point<>(depth, depth, depth);

        logger.info("Creating space with depth of {} units", spaceDepth);
        space = (T[][][]) new Number[spaceDepth][spaceDepth][spaceDepth];
        logger.info("Space created with depth of {} units", spaceDepth);
    }

    public void setPoint(final int x, final int y, final int z, T value) {
        final Point<T> pointToSet;
        validateValue(value);
        validatePoint(pointToSet = new Point<>(x, y, z, value));

        logger.info("Setting {}", pointToSet);
        space[x][y][z] = value;
        touchPoint(pointToSet);
    }

    public BigDecimal sumPointsInsideSpace(final int x1, final int y1, final int z1,
                                           final int x2, final int y2, final int z2) {
        logger.info("Starting process to sum points inside enclosing space");
        BigDecimal pointsSum = BigDecimal.ZERO;
        final Point<T> pointA = new Point<>(x1, y1, z1);
        final Point<T> pointB = new Point<>(x2, y2, z2);
        final Point endPoint = greatest(pointA, pointB);
        final Point startingPoint = endPoint.equals(pointA)? pointB: pointA;

        validateEnclosingSpace(startingPoint, endPoint);

        for(final Point<T> point: touchedPoints)
            if(isPointInsideSpace(startingPoint, endPoint, point))
                pointsSum = addPointValue(point, pointsSum);

        logger.info("Sum finished, returning sum value");
        return pointsSum;
    }

    public T[][][] getSpace() {
        return space;
    }

    private void touchPoint(final Point<T> point) {
        touchedPoints.remove(point);
        touchedPoints.add(point);
    }

    private BigDecimal addPointValue(final Point<T> point, final BigDecimal pointsSum) {
        logger.info("Adding point {} to the sum", point);
        return pointsSum.add(getPointValue(point));
    }

    private void validateParams(final int spaceDepth) {
        logger.info("Validating space depth before space creation");
        if(spaceDepth < 1)
            throw new IllegalArgumentException("Space depth must be equal or greater than one (1)");
    }

    private void validateValue(final T value) {
        if(isNull(value))
            throw new IllegalArgumentException("A value for the point must be provided");

        if(isNegative(value))
            throw new IllegalArgumentException("Value for the point must be equal or greater than zero (0)");
    }

    private void validatePoint(final Point<T> point) {
        if(isPointOutsideSpace(point))
            throw new IllegalArgumentException("The provided point is outside of space");
    }

    private boolean isPointOutsideSpace(final Point<T> point) {
        return !isPointInsideSpace(SPACE_STARTING_POINT, SPACE_END_POINT, point);
    }

    private void validateEnclosingSpace(final Point startingPoint, final Point endPoint) {
        logger.info("Validating enclosing space");
        if(endPoint.getX() < startingPoint.getX() ||
           endPoint.getY() < startingPoint.getY() ||
           endPoint.getZ() < startingPoint.getZ())
            throw new IllegalArgumentException("Points are not enclosing any space, please validate the starting and the end point");
    }
}
