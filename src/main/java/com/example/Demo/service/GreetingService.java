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

	/**
	 * method to save the message
	 */
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

	/**
	 * Method to find the greeting message by Id
	 */
	
	@Override
	public Greeting findById(long id) {
		return greetingRepository.findById(id).get();
	}

	
	/**
	 * Method to list all greeting Messages
	 */
	@Override
	public List<Greeting> getMessages() {
		return greetingRepository.findAll();
	}

	
	/**
	 * method to edit message
	 */
	@Override
	public Greeting editMessage(Greeting greeting) {
		return greetingRepository.save(new Greeting(2, "Hello World..."));
	}

	
	/**
	 * Method to Delete the Greeting Message By ID
	 */
	@Override
	public String deleteMessageById(long id) {
		greetingRepository.deleteById(id);
		return "Message got Deleted...!";
	}

	

//	@Override
//	public Greeting addGreeting(User user) {
//		String message = String.format(template,(user.toString().isEmpty()) ? "Hello World" : user.toString());
//		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
//	}
    


}
