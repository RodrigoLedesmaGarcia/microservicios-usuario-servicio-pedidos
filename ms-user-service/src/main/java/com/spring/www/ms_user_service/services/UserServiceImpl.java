package com.spring.www.ms_user_service.services;

import com.spring.www.ms_user_service.models.User;
import com.spring.www.ms_user_service.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> listarUsuarios() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Optional<User> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public User guardar(User user) {
        return repository.save(user);
    }

    @Override
    public void eliminar(Long id) {
         repository.deleteById(id);
    }
}
