package com.test.jpa.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class DetailCustomerDto {
  private Customer customer;
  private WeakCustomer weakCustomer;
}
