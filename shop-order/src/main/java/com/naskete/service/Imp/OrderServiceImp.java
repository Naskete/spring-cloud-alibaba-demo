package com.naskete.service.Imp;

import com.naskete.dao.OrderDao;
import com.naskete.entity.Order;
import com.naskete.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void saveOrder(Order order) {
        orderDao.save(order);
    }
}
