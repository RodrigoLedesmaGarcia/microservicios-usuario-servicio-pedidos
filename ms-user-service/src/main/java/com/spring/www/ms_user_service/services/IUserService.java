package com.spring.www.ms_user_service.services;

import com.spring.www.ms_user_service.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> listarUsuarios();
    Optional<User> buscarPorId(Long id);
    User guardar (User user);
    void eliminar (Long id);

}
