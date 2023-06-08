package com.cibertec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.models.Tweet;
import com.cibertec.repositories.TweetDao;

@Controller
public class MainController {

	@Autowired
	private TweetDao tweetRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home(){
		return "home";
	}
	
	
	
	@GetMapping("/createTweet")
	public String createTweet(@ModelAttribute("tweet") Tweet tweet) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getAuthorities().stream().count() > 0 ? "createTweet" : "access_denied";
	}
	
	@PostMapping("/createTweet")
	public String createTweet(@Validated @ModelAttribute("tweet") Tweet tweet, BindingResult bindingResult) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getAuthorities().stream().count() > 0){
			if(bindingResult.hasErrors()) {
				return "createTweet";
			}
			tweetRepository.save(tweet);
			return "redirect:/home";
			
		}
		return "access_denied";
		
	}
	
}
