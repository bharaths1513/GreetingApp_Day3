package com.example.Demo.Controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.dto.UserDto;
import com.example.Demo.model.Greeting;
import com.example.Demo.model.User;
import com.example.Demo.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@GetMapping(value = {"","/","/home"})
	public Greeting greeting (@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting (counter.incrementAndGet(),String.format(template, name));
	}
	
	
	@PostMapping("/postDetails")
	public Greeting greetings(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting (counter.incrementAndGet(),String.format(template, name));
	}
	
	
	/**
	 * Using Service layer
	 */
	
	@Autowired
	private IGreetingService greetingService;
	
	
//		//Tried But not Working
//	@GetMapping("/greet")
//	public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
//		User user = new User();
//		user.setFirstName(name);
//		return greetingService.addGreeting(user);
//	}

	@GetMapping("/service")
	public Greeting greeting() {
	     return greetingService.greetingMessage();
	}
	
	@PostMapping("/greet")
	public String greetingMessage(@RequestBody UserDto userDto) {
		return greetingService.gettingMessageByName(userDto);
	}
	
	@GetMapping("/service/{id}")
	public Greeting findById(@PathVariable String id) {
		return this.greetingService.findById(Long.parseLong(id));
	}
	
	@GetMapping("/ListAll")
	public List<Greeting> getMessages(){
		return this.greetingService.getMessages();
	}
	
	@PutMapping("/edit")
	public Greeting editMessage(Greeting greeting) {
		return this.greetingService.editMessage(greeting);
	}
}
