package com.cinema.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityControleur {

	@GetMapping("/notAuthorized")
	public String error() {
		return "notAuthorized";
	}
}
