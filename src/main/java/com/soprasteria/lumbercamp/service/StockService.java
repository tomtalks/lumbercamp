package com.soprasteria.lumbercamp.service;


import com.soprasteria.lumbercamp.api.dto.StockDto;
import com.soprasteria.lumbercamp.model.Stock;
import com.soprasteria.lumbercamp.model.WoodTypes;
import com.soprasteria.lumbercamp.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.soprasteria.lumbercamp.LumberCampApplication.NEW_STOCK;

/**
 * Primary must be set to be the default one when conditional is true
 * Conditional is used to enable this bean when corresponding propertie is set
 */
@Service
@Slf4j
public class StockService {

  @Autowired
  StockRepository stockRepository;

  public List<String> getTypes(){
    return stockRepository.findType();
  }

  public List<StockDto> sumQuantityByType(){
      return stockRepository.sumQuantityByType().stream().map(StockDto::new).collect(Collectors.toList());
  }

  public void collectWood() {
    Arrays.stream(WoodTypes.values()).forEach(this::refill);
  }

  private void refill(WoodTypes type){
    Random r = new Random();
    Integer current =  r.nextInt(NEW_STOCK);
    stockRepository.save(new Stock(type.getName(), current));
    log.info("Jack came back from the forest with {} of {}",current,type.getName());
  }



}
