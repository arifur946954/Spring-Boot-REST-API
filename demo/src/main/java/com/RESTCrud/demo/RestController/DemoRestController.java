package com.RESTCrud.demo.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    @GetMapping("/hello")
    public  String sayHello(){
        System.out.println("Hello world");
        return "Hello world";
    }
}
