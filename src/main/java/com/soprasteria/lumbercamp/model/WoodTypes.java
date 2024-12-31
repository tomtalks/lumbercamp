package com.soprasteria.lumbercamp.model;

import lombok.Getter;

@Getter
public enum WoodTypes {
  OAK("oak"),
  TEAK("teak"),
  PINE("pine"),
  CEDAR("cedar"),
  ASH("ash"),
  FIR("fir"),
  MAPLE("maple"),
  WALNUT("walnut");

  private String name;

  WoodTypes(String name) {
    this.name= name;
  }

}
