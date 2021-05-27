package com.example.demo.api;

import com.example.demo.repos.secondWay.StudentRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API2 {

   private final StudentRepository studentRepository;

   public API2(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
   }

}
