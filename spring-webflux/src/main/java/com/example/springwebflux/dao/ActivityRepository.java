package com.example.springwebflux.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Repository;


import com.example.springwebflux.model.HelloWorld;


import reactor.core.publisher.Mono;

@Repository
public class ActivityRepository{

		@Autowired
		private ReactiveRedisOperations<String,String> operatons;
		
		public void save(HelloWorld actDtl)
		{
			ReactiveValueOperations<String,String> valueOper=operatons.opsForValue();
	        valueOper.set(actDtl.getName(),actDtl.getGreetMsg());
	
		}
		
		public Mono<HelloWorld> getMessageByName(String name)
		{
		Mono<HelloWorld> hello= operatons.opsForValue().get(name).map(result -> new HelloWorld(name,result));
		
		return hello;
		}
}
																																																																																										