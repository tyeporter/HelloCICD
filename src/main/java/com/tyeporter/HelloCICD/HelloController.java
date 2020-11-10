package com.tyeporter.HelloCICD;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {

	@GetMapping("/")
	public String getHello() {
		return "Hello, guest!";
	}


	@GetMapping("/{name}")
	public String getHelloName(@PathVariable String name) {
		return "Hello, " + name + "!";
	}

}