package com.spring.www.ms_order_service.service;

import com.spring.www.ms_order_service.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<Order> listarOrdenes();
    Optional<Order> buscarPorId(Long id);
    Order guardar(Order order);
    void eliminar(Long id);
}
