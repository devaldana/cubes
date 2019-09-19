package com.devspods.cubes.controllers;

import com.devspods.cubes.engines.SpaceEngine;
import com.devspods.cubes.model.SpaceRequest;
import com.devspods.cubes.model.SpaceResponse;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("space")
public class SpaceController {

    @PostMapping("calculate")
    public SpaceResponse touchPoints(@RequestBody final SpaceRequest request) {
        final SpaceEngine<BigDecimal> engine = new SpaceEngine<>(request.getDepth());
        request.getPoints().forEach(engine::setPoint);

        final SpaceResponse response = new SpaceResponse();
        response.setSpace(engine.getSpace());
        response.setSum(engine.sumPointsInsideSpace(request.getPointA(), request.getPointB()));
        return response;
    }
}