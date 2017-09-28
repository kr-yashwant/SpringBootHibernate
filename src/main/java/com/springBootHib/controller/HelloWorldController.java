package com.springBootHib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class HelloWorldController {
	@GetMapping(value = "hello")
	public String checkRest() {
		return "Rest working smooth on this server!";
	}
}
