package com.example.demo.controller;

import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/my")
public class RestControllerDemo {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/address")
	public List<Object> getAddress() {
		String url = "http://localhost:8080/address";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(objects);
	}

	@GetMapping("/question")
	public List<Object> getQuestion() {
		String url = "http://localhost:8080/question";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(objects);
	}

	@GetMapping("/user")
	public List<Object> getUser() {
		String url = "http://localhost:8080/user";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(objects);
	}

	@GetMapping("/answer")
	public List<Object> getAnswer() {
		String url = "http://localhost:8080/answer";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(objects);
	}

}
