package com.test.jpa.demo;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyService {
  private final PregnancyRepository pregnancyRepository;
  private final DisabledRepository disabledRepository;
  private final CustomerRepository customerRepository;

  @Transactional
  public void join(CreateCustomer req) {
    if(req.getWeakInfo().equals("pregnancy")) {
      Customer customer = new Customer(req.getName(), CustomerType.WEAK);
      customerRepository.save(customer);
      Pregnancy pregnancy = new Pregnancy("123", "123", customer, "!23", LocalDateTime.now().plusMonths(7));
      pregnancyRepository.save(pregnancy);
    } else if(req.getWeakInfo().equals("disabled")) {
      Customer customer = new Customer(req.getName(), CustomerType.WEAK);
      customerRepository.save(customer);
      Disabled disabled = new Disabled("12", "34",customer,"sss", 1);
      disabledRepository.save(disabled);
    } else if(req.getWeakInfo().equals("common")){
      Customer customer = new Customer(req.getName(), CustomerType.COMMON);
      customerRepository.save(customer);
    } else {
      throw new IllegalStateException("x");
    }
  }

  @Transactional
  public List<Pregnancy> getAllPregnancies() {
    return pregnancyRepository.findAll();
  }

  @Transactional
  public Customer getDetailCustomer(Long id) {
    Customer customer = customerRepository.findById(id).orElseThrow(IllegalStateException::new);
    return customer;
  }
}
