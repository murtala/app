package com.moortala.hello.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.moortala.hello.model.Greeting;

@RestController
	@RequestMapping("/hello-world")
	public class HelloController {

		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();

		@RequestMapping(method = RequestMethod.GET)
		public Greeting sayHello(
				@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}

	}
