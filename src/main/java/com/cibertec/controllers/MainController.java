package com.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.models.Tweet;
import com.cibertec.repositories.TweetDao;
import com.cibertec.services.TweetService;

@Controller
public class MainController {

	@Autowired
	private TweetDao tweetRepository;
	@Autowired
	private TweetService tweetService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		List<Tweet> tweets = tweetService.buscarTodos();
		model.addAttribute("tweets", tweets);
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
