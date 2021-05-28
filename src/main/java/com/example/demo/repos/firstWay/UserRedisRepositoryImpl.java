package com.example.demo.repos.firstWay;

import com.example.demo.dto.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRedisRepositoryImpl implements UserRedisRepository {

   private final HashOperations<String, String, User> hashOperations;
   public static final String USER_KEY = "user";

   public UserRedisRepositoryImpl(
         @Qualifier(value = "defaultRedisTemplate") RedisTemplate<String, User> redisTemplate) {
      this.hashOperations = redisTemplate.opsForHash();
   }

   @Override
   public void save(User user) {
      hashOperations.put(USER_KEY, user.getId(), user);
   }

   @Override
   public User findById(String id) {
      return hashOperations.get(USER_KEY, id);
   }

   @Override
   public Map<String, User> findAll() {
      return hashOperations.entries(USER_KEY);
   }

   @Override
   public void updateUser(User user) {
      hashOperations.put(USER_KEY, user.getId(), user);
   }

   @Override
   public void delete(String id) {
      hashOperations.delete(USER_KEY, id);
   }
}
