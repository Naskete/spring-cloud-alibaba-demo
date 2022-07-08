package com.naskete.service;

import com.naskete.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Product findByPid(Integer pid);
}
