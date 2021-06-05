package com.example.springwebflux.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.example.springwebflux.model.HelloWorld;

@Configuration
public class RedisConfiguration {

	
	/*
	 * @Bean RedisTemplate<String,Object> redisTemplate(){
	 * RedisTemplate<String,Object> redis = new RedisTemplate<>();
	 * redis.setConnectionFactory(jedisConnectionFactory()); return redis; }
	 */
	
	/*
	 * @Bean JedisConnectionFactory jedisConnectionFactory() {
	 * JedisConnectionFactory conn=new JedisConnectionFactory();
	 * conn.getPoolConfig().setMaxIdle(30); conn.getPoolConfig().setMinIdle(10);
	 * //conn.setHostName("localhost"); //conn.setPort(6379); return conn; }
	 */

	
    @Primary
	@Bean
	ReactiveRedisOperations<String,String> reactiveRedisOperations(ReactiveRedisConnectionFactory factory){


	   /* RedisSerializationContext.RedisSerializationContextBuilder<String, String> builder =RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

	    RedisSerializationContext<String, String> context = builder.value(new StringRedisSerializer()).build();*/
		return new ReactiveStringRedisTemplate(factory);
	}
}
