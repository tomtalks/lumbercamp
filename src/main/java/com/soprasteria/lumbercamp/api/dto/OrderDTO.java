package com.soprasteria.lumbercamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String customer;

    private String type;

    private Integer quantity;

    private Integer honored;
}
