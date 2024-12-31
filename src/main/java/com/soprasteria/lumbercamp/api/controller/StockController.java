package com.soprasteria.lumbercamp.api.controller;

import com.soprasteria.lumbercamp.api.dto.StockDto;
import com.soprasteria.lumbercamp.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@CrossOrigin()
public class StockController {


    @Autowired
    StockService stockServiceService;

    @GetMapping("/api/refill")
    @Scheduled(initialDelay = 2,fixedDelay = 20,timeUnit = TimeUnit.SECONDS)
    public void refill() {
        log.info("refill wood in progress");
        stockServiceService.collectWood();
    }

    @GetMapping("/api/stock/types")
    public List<String> listTypes() {
        log.info("retreive available Types");
        return stockServiceService.getTypes();
    }

    @GetMapping("/api/stock")
    public List<StockDto> getStockByTypes() {
        log.info("Get instant Stock");
        return stockServiceService.sumQuantityByType();
    }


}
