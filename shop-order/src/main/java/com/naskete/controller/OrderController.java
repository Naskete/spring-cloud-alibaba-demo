package com.naskete.controller;

import com.alibaba.fastjson.JSON;
import com.naskete.entity.Order;
import com.naskete.entity.Product;
import com.naskete.service.OrderService;
import com.naskete.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单,这时候要调用商品微服务查询商品信息");
        Product product = productService.findByPid(pid);
        log.info(">>商品查询结果: " + JSON.toJSONString(product));
        Order order = new Order();
        order.setOid(3L);
        order.setUid(1001);
        order.setUsername("zero");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.saveOrder(order);
        return order;
    }
}
