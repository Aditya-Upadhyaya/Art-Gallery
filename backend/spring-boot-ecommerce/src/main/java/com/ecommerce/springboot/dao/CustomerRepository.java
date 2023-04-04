package com.ecommerce.springboot.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.springboot.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
