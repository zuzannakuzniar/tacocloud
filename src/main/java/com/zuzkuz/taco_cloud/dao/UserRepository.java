package com.zuzkuz.taco_cloud.dao;

import com.zuzkuz.taco_cloud.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
