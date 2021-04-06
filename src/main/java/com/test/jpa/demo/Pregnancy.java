package com.test.jpa.demo;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Pregnancy extends WeakCustomer {
  private String babyName;
  private LocalDateTime deliveryExpected;

  public Pregnancy(String weakLevel, String comment, Customer customer, String babyName, LocalDateTime deliveryExpected) {
    super(weakLevel, comment, customer);
    this.babyName = babyName;
    this.deliveryExpected = deliveryExpected;
  }
}
