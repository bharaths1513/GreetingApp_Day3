package com.example.Demo.service;

import org.springframework.stereotype.Service;

import com.example.Demo.model.Greeting;

@Service
public interface IGreetingService {

	Greeting greetingMessage();
}
