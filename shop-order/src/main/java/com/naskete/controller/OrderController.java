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

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("service-product");
//        int idx = new Random().nextInt(instanceList.size());
//        ServiceInstance serviceInstance = instanceList.get(idx);
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        String url = "service-product";
        Product product = restTemplate.getForObject("http://" + url + "/product/" + pid, Product.class);
        log.info(">>商品查询结果: " + JSON.toJSONString(product));
        Order order = new Order();
        order.setOid(2L);
        order.setUid(1001);
        order.setUsername("zero");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setStock(product.getStock());
        orderService.saveOrder(order);
        return order;
    }
}
