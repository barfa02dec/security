package com.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	@GetMapping("/")
	public @ResponseBody String test(@RequestParam("name")String name) {
		return name;
	}
	@GetMapping("/admin")
	public @ResponseBody String testAdmin(@RequestParam("name")String name) {
		return "Admin "+name;
	}
	@GetMapping("/user")
	public @ResponseBody String testUser(@RequestParam("name")String name) {
		return "User "+ name;
	}
}
