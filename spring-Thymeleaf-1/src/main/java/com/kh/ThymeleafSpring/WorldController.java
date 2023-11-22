package com.kh.ThymeleafSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorldController {
	
	@GetMapping("/world")
	public String world(Model model) {
		model.addAttribute("message1", "안녕하세요.~~");
		model.addAttribute("message2", "반갑습니다.");
		return "world";
		
	}
	

}
