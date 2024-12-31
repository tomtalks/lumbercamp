package com.soprasteria.lumbercamp.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDto implements IStockDto {
  private String type;

  private Integer quantity;

  public StockDto(IStockDto isd){
      this.type = isd.getType();
      this.quantity = isd.getQuantity();
  }

}
