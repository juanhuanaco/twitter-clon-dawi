package com.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.repositories.TweetDao;
import com.cibertec.models.Tweet;

@Service
public class TweetService {
	@Autowired
	private TweetDao tweetRepository;

	public List<Tweet> buscarTodos() {
		// TODO Auto-generated method stub
		return tweetRepository.findAll();
	}
}
