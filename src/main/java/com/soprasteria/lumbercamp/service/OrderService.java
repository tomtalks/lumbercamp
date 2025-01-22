package com.soprasteria.lumbercamp.service;


import com.soprasteria.lumbercamp.api.dto.OrderDTO;
import com.soprasteria.lumbercamp.model.WoodOrder;
import com.soprasteria.lumbercamp.model.Stock;
import com.soprasteria.lumbercamp.repository.OrderRepository;
import com.soprasteria.lumbercamp.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Primary must be set to be the default one when conditional is true
 * Conditional is used to enable this bean when corresponding propertie is set
 */
@Service
@Slf4j
public class OrderService {

  @Autowired
  OrderRepository orderRepository;
  @Autowired
  StockRepository stockRepository;

  public OrderDTO placeOder(String customer, String type, Integer quantity) {
    var currentOrder = OrderDTO.builder().customer(customer).type(type).quantity(quantity).honored(0);
    if(quantity <= 0){
      log.warn("No quantity required for {} -{} ",customer,type);
      return currentOrder.build();
    }
    List<Integer> rs = stockRepository.getStock(type);
    if (rs.size() == 0) {
      log.warn("Store is empty");
      return currentOrder.build();
    }

    Integer stock = rs.get(0);

    if (stock == null || stock <= 0) {
      log.warn("No more {} in stock",type);
      return currentOrder.build();
    }
    var honored = (stock - quantity <0 ? stock:quantity);
    currentOrder.honored(honored);

    stockRepository.save(new Stock(type, - honored));
    orderRepository.save(new WoodOrder(customer,type,quantity,honored));
    log.info("Delivery to {} registred for {}/{} of {} ",customer,honored,quantity,type);
    log.info("Delivery pending on current status");

    if(honored < quantity){
      log.warn("Delivery pending for {} of {} ",quantity-honored,type);
      if(type.equals("oak")){
        stockRepository.save(new Stock(type, honored));
        throw new OakException(honored,quantity);
      }
    }


    return currentOrder.build();
  }


}
