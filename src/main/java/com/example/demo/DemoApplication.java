package com.example.demo;

import com.example.demo.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class DemoApplication {

   @Bean
   JedisConnectionFactory jedisConnectionFactory() {
      JedisConnectionFactory factory = new JedisConnectionFactory();
      factory.setHostName("localhost");
      factory.setPort(6379);
      return factory;
   }

   @Bean(name = "defaultRedisTemplate")
   @Primary
   RedisTemplate<String, User> redisTemplate() {
      RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
      redisTemplate.setConnectionFactory(this.jedisConnectionFactory());
      return redisTemplate;
   }

   public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
   }

}
