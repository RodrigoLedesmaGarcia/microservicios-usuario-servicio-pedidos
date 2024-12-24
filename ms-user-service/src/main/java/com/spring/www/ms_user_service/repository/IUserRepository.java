package com.spring.www.ms_user_service.repository;

import com.spring.www.ms_user_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
