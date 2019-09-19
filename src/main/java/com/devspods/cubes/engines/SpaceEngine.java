package com.devspods.cubes.engines;

import com.devspods.cubes.domain.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static com.devspods.cubes.util.SpaceEngineHelper.getPointValue;
import static com.devspods.cubes.util.SpaceEngineHelper.isThePointInsideTheSpace;

public class SpaceEngine<T extends Number> {

    private static final Logger logger = LoggerFactory.getLogger(SpaceEngine.class);
    private int spaceDepth;
    private T[][][] space;
    private Set<Point<T>> touchedPoints = new HashSet<>();

    public SpaceEngine(final int spaceDepth) {
        // TODO params validations
        logger.info("Creating space with depth of {} units", spaceDepth);
        this.spaceDepth = spaceDepth;
        space = (T[][][]) new Number[spaceDepth][spaceDepth][spaceDepth];
    }

    public void setPoint(final int x, final int y, final int z, T value) {
        // TODO params validations
        space[x][y][z] = value;
        touchPoint(new Point<>(x, y, z, value));
    }

    private void touchPoint(final Point<T> point) {
        touchedPoints.remove(point);
        touchedPoints.add(point);
    }

    public BigDecimal sumPointsInsideSpace(final int x1, final int y1, final int z1,
                                           final int x2, final int y2, final int z2) {
        // TODO params validations
        final Point<T> startingPoint = new Point<>(x1, y1, z1);
        final Point<T> endPoint = new Point<>(x2, y2, z2);
        BigDecimal pointsSum = BigDecimal.ZERO;

        for(final Point<T> point: touchedPoints)
            if(isThePointInsideTheSpace(startingPoint, endPoint, point))
                pointsSum = addPointValue(point, pointsSum);

        return pointsSum;
    }

    private BigDecimal addPointValue(final Point<T> point, final BigDecimal pointsSum) {
        return pointsSum.add(getPointValue(point));
    }
}
