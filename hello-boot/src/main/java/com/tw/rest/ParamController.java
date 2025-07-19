package com.tw.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/params")
public class ParamController {

    //http://localhost:8080/params/hello/Surbhi
    @GetMapping(value="/hello/{pname}")
    public String greet(@PathVariable("pname") String name){
        return "Hello" + name;
    }

    //http://localhost:8080/params/bye?pname=Surbhi
    @GetMapping(value="/bye")
    public String sayBye(@RequestParam("pname") String name){
        return "GoodBye" + name;
    }
}
