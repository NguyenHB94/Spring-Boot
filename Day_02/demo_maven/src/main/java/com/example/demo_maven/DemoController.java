package com.example.demo_maven;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class DemoController {
    // HOST:PORT/test/method1
    @RequestMapping("/method1")
    public String testF() {
        System.out.println("Test Function");
        return "Hello";
    }
}
