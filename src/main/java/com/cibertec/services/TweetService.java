package com.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Tweet;
import com.cibertec.repositories.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository repoTweet;
	
	public void guardar(Tweet bean) {
		repoTweet.save(bean);
	}
	
	public List<Tweet> buscarTodos() {
		// TODO Auto-generated method stub
		return repoTweet.findAll();
	}
}
