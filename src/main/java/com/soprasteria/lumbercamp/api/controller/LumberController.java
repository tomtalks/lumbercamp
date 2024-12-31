package com.soprasteria.lumbercamp.api.controller;

import com.soprasteria.lumbercamp.api.dto.OrderDTO;
import com.soprasteria.lumbercamp.model.WoodOrder;
import com.soprasteria.lumbercamp.service.OrderService;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LumberController {

    @Autowired
    OrderService orderService;

    Meter meter =null;

    @PostMapping("/order")
    OrderDTO newOrder(@RequestBody WoodOrder oder) {
        return orderService.placeOder(oder.getCustomer(), oder.getType(), oder.getQuantity());
    }




}
