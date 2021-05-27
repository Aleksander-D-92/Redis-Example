package com.example.demo.repos.firstWay;

import com.example.demo.dto.User;

import java.util.Map;

public interface RedisRepository {

   void save(User user);

   User findById(String id);

   Map<String, User> findAll();

   void updateUser(User user);

   void delete(String id);
}
