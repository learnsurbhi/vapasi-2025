package com.tw.service;

import com.tw.dto.OrderDto;
import com.tw.entity.Customer;
import com.tw.entity.Order;
import com.tw.entity.Product;
import com.tw.repo.CustomerRepository;
import com.tw.repo.OrderRepository;
import com.tw.repo.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    //to place order we need products and customer so autowiring

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)//everytime placing new order it is transaction
    public Order placeOrder(OrderDto dto) {
        Order order = new Order();
        Customer customer = customerService.findByCustId(dto.getCustId());
        Product product= productService.findByCode(dto.getCode());
        order.setCustomer(customer);
        order.setProd(product);
        order.setOrderDate(LocalDate.now());
        order.setPayMode(dto.getPayMode());
        double pf=product.getPrice() *0.2;
        order.setPlatformFee(pf);
        productService.updateStock(product.getCode());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> ordersByCustomer(int custId) {
        return orderRepository.findByCustomerCustId(custId);
    }

    @Override
    public List<Order> ordersByPayMode(String payMode, int custId) {
        return orderRepository.findAllbyCustomerPayMode(payMode, custId);
    }

    @Override
    public List<Order> ordersWithDates(LocalDate start, LocalDate end, int custId) {
        return orderRepository.findbyDateRange(start,end,custId);
    }

    @Override
    public int totalOrders(int custId) {
        return orderRepository.countByCustomerCustId(custId);
    }

    @Override
    public List<Order> orderForProduct(int code) {
        return orderRepository.findByProdCode(code);
    }
}
