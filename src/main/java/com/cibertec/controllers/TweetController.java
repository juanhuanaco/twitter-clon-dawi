package com.cibertec.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.models.Tweet;
import com.cibertec.services.TweetService;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	
	@Autowired
	private TweetService serviTweet;

	
	@RequestMapping("/nuevo")
	public String registro(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getAuthorities().stream().count() > 0) {
			
			Tweet objTweet = new Tweet();
			objTweet.setId(0);
			model.addAttribute("tweet", objTweet);
			model.addAttribute("autor", auth.getName());
			return "register";
		}
		
		
		return "access_denied";
	}

	@RequestMapping("/guardar")
	public String grabar(
	                     @RequestParam("idMensaje") String idMensaje,
	                     Model model,
	                     RedirectAttributes redirect) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getAuthorities().stream().count() == 0)
			return "access_denied";
		
	    try {
	        Tweet objTweet = new Tweet();

	        objTweet.setId(0);
	        objTweet.setAuthor(auth.getName());
	        Date defaultValue = new Date();
	        objTweet.setTime(defaultValue);
	        objTweet.setContent(idMensaje);

	        serviTweet.guardar(objTweet);

	    } catch (Exception e) {
	        redirect.addAttribute("mensaje", "Ocurrió un error al intentar guardar tweet!");
	        e.printStackTrace();
	    }

	    return "redirect:/home";
	}

}
