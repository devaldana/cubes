package com.devspods.cubes.model;

import com.devspods.cubes.domain.Point;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class SpaceRequest {
    private int depth;
    private Point<BigDecimal> pointA;
    private Point<BigDecimal> pointB;
    private List<Point<BigDecimal>> points;
}
