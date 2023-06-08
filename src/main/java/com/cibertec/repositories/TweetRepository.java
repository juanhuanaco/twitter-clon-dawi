package com.cibertec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.models.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long>{
	
	public List<Tweet> findAll();
	
}
