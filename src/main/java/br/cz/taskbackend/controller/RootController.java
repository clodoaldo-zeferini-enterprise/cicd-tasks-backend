package br.cz.taskbackend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/")
public class RootController {
	@GetMapping
	public String hello() {
		return "Hello World!";
	}
}
