package com.example.Demo.service;

import java.util.concurrent.atomic.AtomicLong;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.Repository.GreetingRepository;
import com.example.Demo.dto.UserDto;
import com.example.Demo.model.Greeting;
import com.example.Demo.model.User;
@Service
public class GreetingService implements IGreetingService {
  
	private static final String template = "Hello world";
	 private final AtomicLong counter = new AtomicLong();
	 
	 @Autowired
	 private GreetingRepository greetingRepository;
	 
	 @Override
	 public Greeting greetingMessage() {
		 return greetingRepository.save(new Greeting(counter.incrementAndGet(), String.format(template)) );
	 }
	 
	 @Override
	 public String gettingMessageByName(UserDto userDto) {
		 User user = new User();
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.map(userDto, user);
		 return ("Hello" +" "+ user.getFirstName() + " " + user.getLastName()+"...");
	}
} 
