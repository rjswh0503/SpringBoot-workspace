package com.kh.springPj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//localhost:8080/intro

@Controller
public class IntroController {
	@GetMapping("/intro")
		
	
	public String getIntro() {
		return "intro";
	}

}
