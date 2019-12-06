package com.serjer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.serjer.domain.LastLetter;
import com.serjer.repo.LastLetterRepo;
import com.serjer.repo.TextRepo;
import com.serjer.service.TextService;

@Controller
public class MainController {
	
	@Autowired
	private TextService textService;
	
	@Autowired
	private LastLetterRepo lastLetterRepo;
	
	@Autowired
	private TextRepo textRepo;
	
	@GetMapping("/")
	public String main(Model model) {

	return "input";
	}
	
	@PostMapping("/")
	public String inputText(Model model, @RequestParam String inputText) {
	textService.countWordsByLastLetter(inputText);
	List <LastLetter> list = lastLetterRepo.findAllByTextTextBody(inputText);
	model.addAttribute("list", list);
		return "input";
	}
	
	@GetMapping("/history")
	public String showHistory(Model model) {
	model.addAttribute("historyList", textRepo.findAll());
	return "history";
	}
}
