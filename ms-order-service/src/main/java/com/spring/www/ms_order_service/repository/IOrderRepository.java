package com.spring.www.ms_order_service.repository;

import com.spring.www.ms_order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
