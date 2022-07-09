package com.naskete.dao;

import com.naskete.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
