package com.example.Demo.service;

import java.util.List;
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

	private static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting greetingMessage() {
		 return greetingRepository.save(new Greeting(counter.incrementAndGet(), String.format(template)));
	}

	@Override
	public String gettingMessageByName(UserDto userDto) {
		User user = new User();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userDto, user);
		return ("Hello" + " " + user.getFirstName() + " " + user.getLastName() + "...");
	}

	@Override
	public Greeting findById(long id) {
		return greetingRepository.findById(id).get();
	}

	@Override
	public List<Greeting> getMessages() {
		return greetingRepository.findAll();
	}

	@Override
	public Greeting editMessage(Greeting greeting) {
		return greetingRepository.save(new Greeting(2, "Hello World..."));
	}

	

//	@Override
//	public Greeting addGreeting(User user) {
//		String message = String.format(template,(user.toString().isEmpty()) ? "Hello World" : user.toString());
//		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
//	}



}
