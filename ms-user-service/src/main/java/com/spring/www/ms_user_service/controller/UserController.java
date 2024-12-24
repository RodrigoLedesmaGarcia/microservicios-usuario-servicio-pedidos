package com.spring.www.ms_user_service.controller;


import com.spring.www.ms_user_service.models.User;
import com.spring.www.ms_user_service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/") // http://localhost:7000/api/users
    public ResponseEntity<?> listar(){
        List<User> optional = service.listarUsuarios();
        if (optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message" , "No hay elementos para mostrar"));
        } else {
            return ResponseEntity.ok(service.listarUsuarios());
        }
    } //---


    @GetMapping("/{id}") // http://localhost:7000/api/users({id}
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<User> optional = service.buscarPorId(id);
        if (optional.isPresent()){
            return ResponseEntity.ok(service.buscarPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "No se encontro a ese usuario en particular"));
        }
    }//---

    @PostMapping ("/")// http://localhost:7000/api/users/
    public ResponseEntity<?> crearUsuario(@RequestBody User user){
        try {
           User userNew = service.guardar(user);
           return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(userNew));
        } catch (Exception ex){
            Map<String, Object> errorCreacion = new HashMap<>();
            errorCreacion.put("message", "error al crear el usuario");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorCreacion);
        }
    } // ---

    @PutMapping("/{id}")  // http://localhost:7000/api/users/{id}
    public ResponseEntity<?> editarUsuario(@RequestBody User user, @PathVariable Long id){
        Optional<User> optional = service.buscarPorId(id);
        if (optional.isPresent()){
            User userEditable = optional.get();
            userEditable.setName(user.getName());
            return ResponseEntity.status(HttpStatus.OK).body(service.guardar(userEditable));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "No se pudo editar el usuario"));
        }
    } //---

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  eliminar(@PathVariable Long id){
        Optional<User> optional = service.buscarPorId(id);
        if (optional.isPresent()){
            service.eliminar(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "usuario borrado con exito"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "no se pudo ejecutar el eliminado"));
        }
    } //---
}
