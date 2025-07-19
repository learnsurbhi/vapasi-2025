package com.tw.service;

import com.tw.entity.Customer;
import com.tw.repo.CustomerRepository;
import com.tw.util.CustomerNotFoundException;
import com.tw.util.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByCustId(int custId) {
        return customerRepository.findById(custId).orElseThrow(()-> new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public Customer authenticate(String custPhone, String password) {
        return customerRepository.findByCustPhoneAndPassword(custPhone, password).orElseThrow(()-> new InvalidCredentialsException("Invalid credentials"));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
