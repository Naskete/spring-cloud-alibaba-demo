package com.naskete.service;

import com.naskete.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    void saveOrder(Order order);
}
