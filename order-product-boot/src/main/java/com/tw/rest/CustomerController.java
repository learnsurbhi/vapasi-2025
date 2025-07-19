package com.tw.rest;

import com.tw.entity.Customer;
import com.tw.repo.CustomerRepository;
import com.tw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@CrossOrigin //for communication
@RestController
@RequestMapping(value="/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value="/add",consumes ="application/json",produces="application/json")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.addCustomer(customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

    @GetMapping(value="/{custId}",produces = "application/json")
    public ResponseEntity<Customer> findByCustId(@PathVariable int custId){
        Customer customer1= customerService.findByCustId(custId);
        if(customer1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        else
            return new ResponseEntity<>(customer1, HttpStatus.OK);
        }

    @GetMapping(value="/listofcustomers",produces="application/json")
     public ResponseEntity<List<Customer>> findAllCustomers(){
        List<Customer> customer1= customerService.findAll();
        return new ResponseEntity<>(customer1, HttpStatus.OK);
     }

     @GetMapping(value="/auth",produces = "application/json")
     public ResponseEntity<Customer> authenticateCustomer(@RequestParam String custPhone,@RequestParam String password){
        Customer c=customerService.authenticate(custPhone,password);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    }


