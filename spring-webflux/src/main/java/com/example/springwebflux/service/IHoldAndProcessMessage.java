package com.example.springwebflux.service;

import com.example.springwebflux.model.HelloWorld;

import reactor.core.publisher.Mono;

public interface IHoldAndProcessMessage {
	public Mono<HelloWorld> getGreetDetail(String name) throws InterruptedException;
	public void saveGreetDetail(String name,String msg) throws InterruptedException;
	public void saveGreetDetailObject(HelloWorld hello) throws InterruptedException;
	public Mono<HelloWorld> getGreetDetailObj(String name) throws InterruptedException;
}
