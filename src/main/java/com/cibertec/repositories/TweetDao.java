package com.cibertec.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.models.Tweet;

@Repository
public interface TweetDao extends CrudRepository<Tweet, Long>{
	
	public List<Tweet> findAll();
	
}
