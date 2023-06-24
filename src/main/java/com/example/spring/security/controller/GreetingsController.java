package com.example.spring.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {

    @GetMapping
    public ResponseEntity<String> sayHello(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(String.format("Hello Good morning! %s", Optional.ofNullable(name).orElse("")));
    }

    @GetMapping("/bye")
    public ResponseEntity<String> goodBye() {
        return ResponseEntity.ok("Dua me yad!!");
    }

}
