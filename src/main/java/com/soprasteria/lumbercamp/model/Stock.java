package com.soprasteria.lumbercamp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

  @Id
  @SequenceGenerator(name = "stock_id_seq")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;

  private Integer quantity;

  @CreationTimestamp
  @Column
  private Timestamp timestamp;

  public Stock(String type, Integer quantity) {
    this.type = type;
    this.quantity = quantity;
  }

}
