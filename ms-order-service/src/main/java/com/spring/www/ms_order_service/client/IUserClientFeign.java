package com.spring.www.ms_order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-user-service", url = "http://localhost:7000/api/users/")
public interface IUserClientFeign {

    @GetMapping("/{id}") // http://localhost:7000/api/users({id}
    String buscarPorId(@PathVariable Long id);
}
