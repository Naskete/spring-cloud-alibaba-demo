package com.naskete.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController3 {
    @GetMapping("/order/message1")
    public String message1() {
        return "message1";
    }

    @GetMapping("/order/message2")
    public String message2() {
        return "message2";
    }
}
