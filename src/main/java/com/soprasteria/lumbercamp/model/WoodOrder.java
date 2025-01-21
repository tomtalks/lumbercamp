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
public class WoodOrder {

  @Id
  @SequenceGenerator(name = "order_id_seq")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String customer;

  private String type;

  private Integer quantity;

  private Integer honored;

  @CreationTimestamp
  @Column
  private Timestamp timestamp;

  public WoodOrder(String customer, String type, Integer quantity, Integer honored) {
    this.customer = customer;
    this.type = type;
    this.quantity = quantity;
    this.honored = honored;
  }
  public WoodOrder(String customer, String type, Integer quantity) {
    this.customer = customer;
    this.type = type;
    this.quantity = quantity;
  }
}
