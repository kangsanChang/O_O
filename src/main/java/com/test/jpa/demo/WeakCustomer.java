package com.test.jpa.demo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@NoArgsConstructor
@Setter
public class WeakCustomer {
  @Id @GeneratedValue
  private Long id;
  private String weakLevel;
  private String comment;

  @OneToOne
  @JoinColumn(name = "CUSTOMER_ID")
  @JsonIgnore
  private Customer customer;

  public WeakCustomer(String weakLevel, String comment, Customer customer) {
    this.weakLevel = weakLevel;
    this.comment = comment;
    this.customer = customer;
  }
}
