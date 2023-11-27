package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.springdb.model.Board;
import com.kh.springdb.service.BoardService;

@Controller
public class BoardContoller {
	
	@Autowired // 인스턴스를 대신 해줌 
	private BoardService boardService;
	
	@GetMapping("/boardList")
	public String displayBoardList(Model model) {
		model.addAttribute("boards", boardService.getAllBoards());
		return "boardList";
	}
	
	
	
	
	
	
	
	
	
}
