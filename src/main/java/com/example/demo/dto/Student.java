package com.example.demo.dto;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Student")
public class Student {

   private String id;
   private String name;
   private int grade;
}
