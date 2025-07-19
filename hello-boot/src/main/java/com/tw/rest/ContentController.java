package com.tw.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/content")
public class ContentController {

    @GetMapping(value="/text",produces = "text/plain")
    public String textGreeting(){
        return "Text: Welcome to Spring ";
    }

    @GetMapping(value="/html",produces = "text/html")
    public String htmlGreeting(){
        return "<h1>Hello World!</h1>";
    }

    @GetMapping(value="/xml",produces = "text/xml")
    public String xmlGreeting(){
        return "<? xml version=\"1.0\"?><greeting>XML: Welcome to Spring XML!</greeting>";
    }

    @GetMapping(value="/json",produces ="application/json")
    public String jsonGreeting(){
        return "{\"greeting\":\"Hello World!\"}";
    }

}
