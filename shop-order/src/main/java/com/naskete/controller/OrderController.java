package com.naskete.controller;

import com.alibaba.fastjson.JSON;
import com.naskete.entity.Order;
import com.naskete.entity.Product;
import com.naskete.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
        return new Order();
    }
}
