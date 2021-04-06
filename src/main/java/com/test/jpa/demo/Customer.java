package com.test.jpa.demo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Customer {
  @Id @GeneratedValue
  private Long id;
  private String name;
  @Enumerated(EnumType.STRING)
  private CustomerType type;

  @OneToOne(mappedBy = "customer")
  private WeakCustomer weakCustomer;

  public Customer(String name, CustomerType type) {
    this.name = name;
    this.type = type;
  }
}
