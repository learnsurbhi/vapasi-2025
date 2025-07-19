package com.tw.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/greeting")
public class HelloController {
    //http://localhost:8080/greeting/hello
    @GetMapping(value = "/hello")
    public String sayGetHello() {
        return "Get: Hello Spring Boot";
    }

    @PostMapping(value = "/hello")
    public String sayPostHello() {
        return "Post: Hello Spring Boot";
    }

    @PutMapping(value = "/hello")
    public String sayPutHello() {
        return "Put: Hello Spring Boot";
    }

    @DeleteMapping(value = "/hello")
    public String sayDeleteHello() {
        return "Delete: Hello Spring Boot";
        }
    }


