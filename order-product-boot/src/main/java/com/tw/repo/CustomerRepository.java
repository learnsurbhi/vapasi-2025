package com.tw.repo;

import com.tw.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Optional<Customer> findByCustPhoneAndPassword(String custPhone, String password);
}
