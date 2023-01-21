package com.tweteroo.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.model.Tweets;

public interface TweetRepository extends JpaRepository<Tweets, Long> {
    
}
