package com.example.validator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {

	public CalcController() {
		System.out.println("CalcController Created");
	}
	
	@GetMapping("/calc")
	public String calc() {
		return "/calc/form";
	}

	@PostMapping("/calc")
	public String calc(CalcVO calcVO, BindingResult result, Model model) {
		CalcValidator calcvalidator = new CalcValidator();
		calcvalidator.validate(calcVO, result);
		
		if(result.hasErrors()) {
			return "/calc/form";
		}else {
			int payment = calcVO.getPrice() * calcVO.getCount();
			model.addAttribute("payment", payment);
			return "/calc/proc";
		}
	}
}
