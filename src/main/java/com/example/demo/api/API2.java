package com.example.demo.api;

import com.example.demo.dto.Student;
import com.example.demo.repos.secondWay.StudentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class API2 {

   private final StudentRepository studentRepository;

   @PostMapping("/user")
   public String createUser(@RequestBody Student user) {
      this.studentRepository.save(user);
      return "Ok";
   }

   @PutMapping("/user")
   public String updateUser(@NonNull @RequestBody Student user) {
      this.studentRepository.save(user);
      return "Ok";
   }

   @GetMapping("/student/{id}")
   public Student findById(@PathVariable String id) {
      return this.studentRepository.findById(id).get();
   }

   @GetMapping("/student/all")
   public Iterable<Student> findById() {
      return this.studentRepository.findAll();
   }

   @DeleteMapping("/student/{id}")
   public String updateUser(@PathVariable String id) {
      this.studentRepository.deleteById(id);
      return "Ok";
   }
}
