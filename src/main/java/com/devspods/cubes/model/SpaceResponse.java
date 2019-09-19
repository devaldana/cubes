package com.devspods.cubes.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpaceResponse {
    private Number[][][] space;
    private BigDecimal sum;
}
