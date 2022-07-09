package com.naskete.controller;

import com.alibaba.fastjson.JSON;
import com.naskete.entity.Order;
import com.naskete.entity.Product;
import com.naskete.service.OrderService;
import com.naskete.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController2 {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/order/product/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info(">>接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        Product product = productService.findByPid(pid);
        log.info(">>查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order order = new Order();
        order.setOid(3L);
        order.setUid(1001);
        order.setUsername("zero");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
//        为了不产生太多垃圾数据,暂时不做订单保存
//        orderService.saveOrder(order);
        return order;
    }

    @GetMapping(value = "/order/message")
    public String message() {
        return "高并发下的问题测试";
    }
}