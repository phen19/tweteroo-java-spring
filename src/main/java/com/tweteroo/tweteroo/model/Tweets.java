package com.tweteroo.tweteroo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tweteroo.tweteroo.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweets {
     
    public Tweets(TweetDTO data){
        this.username = data.username();
        this.avatar = data.avatar();
        this.tweet = data.tweet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length =100, nullable = false)
    private String avatar;
    
    @Column(length= 280, nullable = false)
    private String tweet;

}
