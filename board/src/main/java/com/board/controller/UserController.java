package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.dto.UserDetail;
import com.board.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping(value="/userSignUp", method=RequestMethod.GET)
	public void UserSignUp() {
		
	}
	
	@RequestMapping(value="/userSignUp", method=RequestMethod.POST)
	public String UserSignUp(UserDetail vo) {
		try {
			vo.setPassword(bcryptPasswordEncoder.encode(vo.getPassword()));
			service.userSignUp(vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	public int idCheck(@RequestParam(value="id") String id) {
		System.out.println("idCheck Controller");
		int result = 0;
		try {
			result = service.idCheck(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
