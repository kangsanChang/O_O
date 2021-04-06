package com.test.jpa.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisabledRepository extends JpaRepository<Disabled, Long> {
}
