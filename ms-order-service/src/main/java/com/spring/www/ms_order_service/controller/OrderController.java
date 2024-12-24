package com.spring.www.ms_order_service.controller;

import com.spring.www.ms_order_service.model.Order;
import com.spring.www.ms_order_service.service.OrderServiceImpl;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order/")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/")
    public ResponseEntity<?> listar(){
        List<Order> optional = orderService.listarOrdenes();
        if (optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(Map.of("message", "No hay elementso para mostrar"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(orderService.listarOrdenes());
        }
    } //---

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id){
        return orderService.getOrderWithUser(id);
    } //---

    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Order order){
        try {
            Order orderNew = orderService.guardar(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(orderService.guardar(orderNew));
        }catch (Exception e){
          Map<String, Object> errores = new HashMap<>();
          errores.put("message", "No se pudo crear esa orden");
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }
    }//----
}
