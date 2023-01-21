package com.tweteroo.tweteroo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dto.TweetDTO;
import com.tweteroo.tweteroo.model.Tweets;
import com.tweteroo.tweteroo.services.TweetService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @PostMapping
    public void createTweet(@RequestBody @Valid TweetDTO req){
        tweetService.create(req);
    }

    @GetMapping
    public List<Tweets> listAll(){
        return tweetService.listAll();
    }
}