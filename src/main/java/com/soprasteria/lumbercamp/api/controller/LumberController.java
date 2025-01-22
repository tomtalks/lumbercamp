package com.soprasteria.lumbercamp.api.controller;

import com.soprasteria.lumbercamp.api.dto.OrderDTO;
import com.soprasteria.lumbercamp.model.WoodOrder;
import com.soprasteria.lumbercamp.service.OakException;
import com.soprasteria.lumbercamp.service.OrderService;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LumberController {

    @Autowired
    OrderService orderService;

    Meter meter =null;

    @PostMapping("/order")
    OrderDTO newOrder(@RequestBody WoodOrder oder) {
        try {
            return orderService.placeOder(oder.getCustomer(), oder.getType(), oder.getQuantity());
        }catch (OakException exc) {
            throw new ResponseStatusException(
                HttpStatus.I_AM_A_TEAPOT, exc.getMessage(), exc);
        }
    }

}
