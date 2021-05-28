package com.example.demo.config;

import com.example.demo.dto.User;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

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
}
