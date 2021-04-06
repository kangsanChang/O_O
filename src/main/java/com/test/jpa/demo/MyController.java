package com.test.jpa.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MyController {
  private final MyService myService;

  @PostMapping("/insert")
  public void insert(@RequestBody CreateCustomer req) {
    myService.join(req);
  }

  @GetMapping("/give/{id}")
  public Customer get(@PathVariable Long id) {
    Customer detailCustomer = myService.getDetailCustomer(id);
    return detailCustomer;
  }
}
