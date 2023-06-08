package com.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cibertec.models.Tweet;
import com.cibertec.repositories.TweetRepository;
import com.cibertec.services.TweetService;

@Controller
public class MainController {

	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private TweetService tweetService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getAuthorities().stream().count() > 0){
			List<Tweet> tweets = tweetService.buscarTodos();
			model.addAttribute("tweets", tweets);
			return "home";
		}
		return "access_denied";
	}
	
}
