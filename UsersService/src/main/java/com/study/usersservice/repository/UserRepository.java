package com.study.usersservice.repository;

import com.study.usersservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
