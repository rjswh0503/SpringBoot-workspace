package com.kh.board.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.board.service.BoardService;
import com.kh.board.vo.Board;

@Controller
@RequestMapping("/boards")
public class BoardController {
	private final BoardService boardService;
	
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	//모든 게시물 
	@GetMapping
	public String getAllBoards(Model model) {
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		return "board_list";
	}
	
	
	//제품 상세보기 
	@GetMapping("/detail/{id}")
	public String getBoardById(@PathVariable Long id, Model model) {
		Optional<Board> board = boardService.getBoardById(id);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "board_detail";
	}
	
	
	//insert Get Post Mapping
	
	@GetMapping("/new")
	public String displayboardForm(Model model) {
		model.addAttribute("board", new Board());
		return "board_form";
		
	}
	
	@PostMapping("/save")
	public String saveBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/boards";
	}
	
	
	@GetMapping("/update/{id}")
	public String updateBoard(@PathVariable Long id, Model model) {
		Optional<Board> board = boardService.getBoardById(id);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "board_form";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable Long id) {
	    boardService.deleteBoardById(id);
	    return "redirect:/boards";
	}
	
	
	//모두 삭제하기 
	@GetMapping("/delete/all")
	public String deleteAllBoards() {
		boardService.deleteAllBoards();
		return "redirect:/boards";
	}
	
	
	
	
	

}
