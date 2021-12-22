package com.example.Demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Demo.dto.UserDto;
import com.example.Demo.model.Greeting;


@Service
public interface IGreetingService {

//	Greeting addGreeting(User user);
	Greeting greetingMessage();
	String gettingMessageByName(UserDto userDto);
	Greeting findById(long id);
	List<Greeting> getMessages();
	Greeting editMessage(Greeting greeting);
	
	
}
