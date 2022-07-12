package com.naskete.controller;

import com.naskete.service.Imp.OrderServiceImpl3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController3 {
    @Autowired
    OrderServiceImpl3 orderServiceImpl3;
    @GetMapping("/order/message1")
    public String message1() {
        orderServiceImpl3.message();
        return "message1";
    }

    @GetMapping("/order/message2")
    public String message2() {
        orderServiceImpl3.message();
        return "message2";
    }
}
