package com.example.Demo.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.Demo.model.Greeting;
@Service
public class GreetingService implements IGreetingService {
  
	private static final String template = "Hello world";
	 private final AtomicLong counter = new AtomicLong();
	 
	 public Greeting greetingMessage() {
		 return new Greeting(counter.incrementAndGet(), String.format(template));
	 }
} 
