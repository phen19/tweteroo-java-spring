package com.tweteroo.tweteroo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dto.TweetDTO;
import com.tweteroo.tweteroo.model.Tweets;
import com.tweteroo.tweteroo.services.TweetService;
import com.tweteroo.tweteroo.services.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {
    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    @PostMapping
    public void createTweet(@RequestBody @Valid TweetDTO req){
        var userData = userService.findByUsername(req.username());
        TweetDTO tweetData = new TweetDTO(req.username(), userData.getAvatar(), req.tweet());
        tweetService.create(tweetData);
    }

    @GetMapping
    public List<Tweets> getTweets(@PageableDefault(page=0, size =5, sort = "id", direction = Sort.Direction.DESC)Pageable page){
        return tweetService.findAll(page);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweets>> getTweets(@PathVariable String username){
        var tweets = tweetService.getTweets(username);

        if(tweets != null){
            return ResponseEntity.ok().body(tweets);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
