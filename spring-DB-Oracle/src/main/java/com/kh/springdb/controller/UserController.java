package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.springdb.model.User;
import com.kh.springdb.service.UserSerivce;

@Controller
public class UserController {
	@Autowired
	private UserSerivce userService;

	
	//전체 아이디를 가지고 오기 위해서 @GetMapping 사용
	@GetMapping("/users-information")
	public String getAllUsers(Model model){
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users-infomation";

	}

	
	
	//하나의 아이디 가지고 오기 
	@GetMapping("/user-info/{id}")
	public String getUserById(@PathVariable int id, Model model) {
		User user =  userService.getUserById(id);
		model.addAttribute("user", user);
		return "user-info";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@GetMapping("/registersuccess")
	public String getRegistersuccess() {
		return "registersuccess";
	}
	
	@PostMapping("/api/user/register")
	public String registerMember(@ModelAttribute("user")  @Validated User user, BindingResult result) {
		userService.registerUser(user);
		//유저가 회원가입을 성공할 경우 이동하는 경로
		return "redirect:/registersuccess";
	}
	
	@GetMapping("/user-update/{id}")
	public String updateUserForm(@PathVariable int id, Model model) {
		//사용자 정보를 가져와서 모델에 추가해줘야 하기 떄문에
		// 사용자 정보를 가지고오는 모델 추가 코드를 작성
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user-update";
	}
	
	
	//@GetMapping()
		//사용자 정보를 가져와서 모델에 추가
	
	//return "user-update";
	
	
	//id에 해당하는 Update문을 사용해서 수
	@PostMapping("/api/user/update/{id}")
	public String updateUser(@PathVariable int id, @ModelAttribute("user") @Validated User user, BindingResult result) {
		
		//결과에 애러가 있는지 없는지 추가해주는 if문 
		if(result.hasErrors()) {
			return "에러가 발견되었습니다.";
		}
		user.setMno(id); //경로에서 받은 id를 이용해서 사용자 정보를 업데이트
		userService.updateUser(user);
		
		return "redurect:/user-info";
	}
	
	
	//Get과 Post를  한 번에 처리할 수 있는 방법이 없을까 ?  = > @RequestMapping을 사용해서 method get과 post를 한 번에 묶어서 해결
	
	
	
	@RequestMapping(value="/user-delete/{id}", method = {RequestMethod.GET,RequestMethod.POST})
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/user-info";
		
	}
	
	
	
	
	
	

}


/*
@PathVariable : 경로에 대한 변수를 메서드의 매개변수로 받을 때 사용
사용법 : @PathVariable int id
	{id}
@ModelAttribute("값")
	Thyeleaf 뷰에서 설정한 값의 이름을 사용해서 모델 속성에 엑서스 할 수 있음
	엑서스(access) : 컴퓨터 데이터 또는 리소스를 어떤 방식으로든 사용할 수 있도록
					권한을 주거나 권한이 담겨진 것을 의미
	@ModelAttribute("user") : user라는 이름으로 Model에 User 객체를 추가한 것
	
@Validated : 데이터 유효성 검사를 실시하도록 행하는 것
	@Validated(user) : User 객체에 대한 데이터 유효성 검사를 실시하겠다 한 것
	
BindingResult  : @Validated 실시한 유효성 검사 결과를 저장하는 객체
				유효성 검사에서 발생한 오류에 대한 정보가 담기는 공간


@RequestMapping : 사용자의 http 요청을 특정 메서드와 할 수 있도록 Mapping(감싸주는) 역할을 함


	value = "" : value는 사용자가 요청할 때 주고받는 url을 작성해줌
					예를들어 value="/user-delete/{id}" 값이 있을 때 {id}는 PathVariable(패스(경로)변수)로 실제 요청할 경우
					해당 url 위치로 들어오는 값을 변수로 활용할 수 있음
	
	method = "" : 메서드에서 처리할 http 요청을 메서드에 지정 
	 				 예를들어 RequestMethod.Get
	 					    RequestMethod.Post 사용할 수 있음
	 					    
	 					    RequestMethod.Get
	 					    HTTP GET 메서드는 주로 DB에 정보를 요청하기 위해 사용
	 					    사이트에서 url을 통한 직접 요청이나 링크를 클릭해야하는 상황에서 GET 메서드가 사용됨
	 					    데이터를 서버로 전송하지는 않고, 주로 데이터를 요청하거나 조회할 때 사용
	 					    
	 					    
	 					    ReqeustMethod.Post
	 					    주로 서버로 데이터를 제출하기 위해 사용 
	 					    데이터를 html 본문에 담아 전송하기 때문에 get보다는 대량의 데이터를 처리하기에 적합
	 					    
	 					    
	 					    
	 					    
	 					    
	 					

 * */











