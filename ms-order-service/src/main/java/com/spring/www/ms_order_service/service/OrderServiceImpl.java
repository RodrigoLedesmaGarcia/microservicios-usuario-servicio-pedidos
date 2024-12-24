package com.spring.www.ms_order_service.service;

import com.spring.www.ms_order_service.client.IUserClientFeign;
import com.spring.www.ms_order_service.model.Order;
import com.spring.www.ms_order_service.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository repository;

    @Autowired
    public IUserClientFeign userClient;


    @Override
    public List<Order> listarOrdenes() {
        return (List<Order>) repository.findAll();
    }

    @Override
    public Optional<Order> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order guardar(Order order) {
        return repository.save(order);
    }

    @Override
    public void eliminar(Long id) {
          repository.deleteById(id);
    }

    public String getOrderWithUser(Long id){
        Order order = repository.findById(id).orElse(null);
        if (order == null){
            return "Order not found";
        }
        String userName = userClient.buscarPorId(order.getUserId());
        return "Order for " + userName+" "+order.getProduct();

    }
}
