package com.kh.springdb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kh.springdb.service.StmemberService;
import com.kh.springdb.vo.STMEMBER;

@Controller
@RequestMapping("/members")
public class StmemberController {
	

	private StmemberService stService;
	
	
	@Autowired
	public StmemberController(StmemberService stService) {
		this.stService = stService;
	}
	
	
	
	
	@GetMapping
	public String getAllMember(Model model) {
		model.addAttribute("members", stService.getAllMember());
		return "member_list";
		
	}
	
	//insert
	@GetMapping("/new")
	public String showMemberForm(Model model) {
		model.addAttribute("member", new STMEMBER());
		return "member_form";
	}
	
	
	@PostMapping("/save")
	public String saveMember(@ModelAttribute STMEMBER stmember) {
		stService.saveMember(stmember);
		return "redirect:/members";
	}
	
	
	//update
	@GetMapping("/update/{memberId}")
	public String updateMember(@PathVariable Long id, Model model) {
		Optional<STMEMBER> member = stService.getMemberById(id);
		member.ifPresent(value -> model.addAttribute("member", value));
		//옵셔널 이용해서 아이디 값 가지고 오기
		//람다시 사용해서 member에 값을 추가하는 코드 작성
		return "member_form";
		
	}
	

	//delete
	@GetMapping("/delete/{memberId}")
	public String deleteMember(@PathVariable Long id) {
		stService.deleteMemberById(id);
		return "redirect/members";
		
	}
	
	
	
	
	
	

}
