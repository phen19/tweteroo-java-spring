package com.tweteroo.tweteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dto.TweetDTO;
import com.tweteroo.tweteroo.model.Tweets;
import com.tweteroo.tweteroo.repository.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    public Tweets create(TweetDTO dto){
        return repository.save(new Tweets(dto));
    }

    public List<Tweets> findAll(org.springframework.data.domain.Pageable page){
        return repository.findAll(page).getContent();
    }

    public List<Tweets> getTweets(String username){
        return repository.findAllByUsername(username);
    }
}