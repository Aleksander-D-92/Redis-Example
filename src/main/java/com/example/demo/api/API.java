package com.example.demo.api;

import com.example.demo.dto.User;
import com.example.demo.repos.firstWay.UserRedisRepository;
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

   private final UserRedisRepository userRedisRepository;

   @PostMapping("/user")
   public String createUser(@RequestBody User user) {
      this.userRedisRepository.save(user);
      return "Ok";
   }

   @GetMapping("/user/{id}")
   public User findById(@PathVariable String id) {
      return this.userRedisRepository.findById(id);
   }

   @GetMapping("/user/all")
   public Map<String, User> findById() {
      return this.userRedisRepository.findAll();
   }

   @PutMapping("/user")
   public String updateUser(@NonNull @RequestBody User user) {
      this.userRedisRepository.updateUser(user);
      return "Ok";
   }

   @DeleteMapping("/user/{id}")
   public String updateUser(@PathVariable String id) {
      this.userRedisRepository.delete(id);
      return "Ok";
   }
}
