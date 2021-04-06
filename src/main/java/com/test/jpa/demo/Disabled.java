package com.test.jpa.demo;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Disabled extends WeakCustomer {
  private String disableName;
  private int level;

  public Disabled(String weakLevel, String comment, Customer customer, String disableName, int level) {
    super(weakLevel, comment, customer);
    this.disableName = disableName;
    this.level = level;
  }
}
