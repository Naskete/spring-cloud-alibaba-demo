package com.naskete.service.Imp;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl3 {
    @SentinelResource
    public void message() {
        System.out.println("message");
    }
}
