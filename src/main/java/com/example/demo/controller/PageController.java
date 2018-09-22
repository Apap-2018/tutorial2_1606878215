package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;


@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challange")
	public String challange(@RequestParam(value = "name") String name, Model model){
		model.addAttribute("name", name);
		return "challange";
	}
	
	@RequestMapping(value = {"/challange","/challange/{name}"})
	public String challangePath(@PathVariable Optional<String> name, Model model){
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challange";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", defaultValue = "0") Integer a, @RequestParam(value = "b", defaultValue = "0") Integer b, Model model){
		String numOfHm = "";
		if (a.toString().equals("0")) {
			String hm = "h" + StringUtils.repeat("m", 1) + " ";
			if (b.toString().equals("0")) {
				numOfHm = StringUtils.repeat(hm, 1);
			} else {
				numOfHm = StringUtils.repeat(hm, b);
			}
		} else {
			String hm = "h" + StringUtils.repeat("m", a) + " ";
			numOfHm = StringUtils.repeat(hm, b);
		}
		model.addAttribute("hm", numOfHm);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		return "generator";
	}
}
