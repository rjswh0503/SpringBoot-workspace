package com.kh.springdb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.SecurityUser;
import com.kh.springdb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	//회원가입을 할 경우 비밀번호를 암호화 해서 DB에 저장할 수 있도록 구현
	
	public SecurityUser create(String username, String email, String password) {
		SecurityUser user = new SecurityUser();
		user.setUserName(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
							// passwordEncoder를 사용해서 입력받은 비밀번호를 암호화 처리해서 입력하는 것 
		
		this.userRepository.save(user);
		return user;
	}
	

}
