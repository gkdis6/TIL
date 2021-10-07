package com.example.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.bean.Member;

//action과 같아서 Rest가 없으면 이름이 같은 jsp파일을 찾음
@Controller
public class HelloController {

	//RestController가 들어가면 @ResponseBody를 생략할 수 있다.
	@GetMapping
	public @ResponseBody String hello() {
		return "Hello World";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		
//		setAttribute와 비슷하지만 범용성이 더 좋
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestParam("id") String id,@RequestParam("name") String name, Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	@RequestMapping("/test3/{studentid}/{name}")
	public String test3(@PathVariable String studentid, @PathVariable String name, Model model) {
		model.addAttribute("id",studentid);
		model.addAttribute("name",name);
		
		return "test1";
	}
	
	@RequestMapping("/test4")
	public String test4(Member member) {
		
		return "test2";
	}
}
