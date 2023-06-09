package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/demo")
	public Demo greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Demo(counter.incrementAndGet(), String.format(template, name));
	}
}
