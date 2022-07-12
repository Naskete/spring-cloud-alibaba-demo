package com.naskete.service;

import com.naskete.entity.Product;
import com.naskete.service.Imp.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "service-product", fallback = ProductServiceFallBack.class)
public interface ProductService {
    @GetMapping(value = "/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);
}
