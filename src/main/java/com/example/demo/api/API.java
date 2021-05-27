package com.example.demo.api;

import com.example.demo.dto.User;
import com.example.demo.repos.firstWay.RedisRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class API {

   private final RedisRepository redisRepository;

   @PostMapping("/user")
   public String createUser(@RequestBody User user) {
      this.redisRepository.save(user);
      return "Ok";
   }

   @GetMapping("/user/{id}")
   public User findById(@PathVariable String id) {
      return this.redisRepository.findById(id);
   }

   @GetMapping("/user/all")
   public Map<String, User> findById() {
      return this.redisRepository.findAll();
   }

   @PutMapping("/user")
   public String updateUser(@NonNull @RequestBody User user) {
      this.redisRepository.updateUser(user);
      return "Ok";
   }

   @DeleteMapping("/user/{id}")
   public String updateUser(@PathVariable String id) {
      this.redisRepository.delete(id);
      return "Ok";
   }
}
