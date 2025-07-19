package com.tw.service;

import com.tw.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer findByCustId(int custId);

    Customer authenticate(String custPhone, String password);

    List<Customer> findAll();
}
