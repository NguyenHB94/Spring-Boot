package com.example.spring_day_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

    @GetMapping("/first-day")

    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/var/{ten}")

    public String helloWithName(@PathVariable("ten") String name) {
        return "Hello World: " + name;
    }
}
