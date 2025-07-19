package com.tw.rest;

import com.tw.dto.OrderDto;
import com.tw.entity.Order;
import com.tw.service.CustomerService;
import com.tw.service.OrderService;
import com.tw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/order-placed", produces = "application/json")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderDto) {

        Order order = orderService.placeOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/listorder", produces = "application/json")
    public ResponseEntity<List<Order>> findAllOrders() {
        List<Order> order = orderService.findAll();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/{order_cust}", produces = "application/json")
    public ResponseEntity<List<Order>> getOrderByCustomer(@PathVariable int custId) {
        List<Order> order = orderService.ordersByCustomer(custId);
        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    @GetMapping(value = "/order_paymode", produces = "application/json")
    public ResponseEntity<List<Order>> getOrderByPayMode(@RequestParam String payMode, @RequestParam int custId) {
        List<Order> order = orderService.ordersByPayMode(payMode, custId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/order_date", produces = "application/json")
    public ResponseEntity<List<Order>> getOrderwithDate(@RequestParam LocalDate start, @RequestParam LocalDate end, @RequestParam int custId) {
        List<Order> order = orderService.ordersWithDates(start, end, custId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/{order_pro}", produces = "application/json")
    public ResponseEntity<List<Order>> getOrderForProduct(@PathVariable int code) {
        List<Order> order = orderService.orderForProduct(code);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<Integer> getTotalOrdersByCustomer(@RequestParam int custId) {
        Integer total = orderService.totalOrders(custId);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
