package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Tweet;
import com.cibertec.repositories.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository repoTweet;
	
	public List<Tweet> listarTweet() {
		return repoTweet.findAll();
	}
	
	public void guardar(Tweet bean) {
		repoTweet.save(bean);
	}
}
