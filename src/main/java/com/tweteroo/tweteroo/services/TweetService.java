package com.tweteroo.tweteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
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

    public List<Tweets> listAll(){
        return repository.findAll();
    }

/*     public Page<Tweets> list(@PageableDefault(page = 0, size = 2) Pageable page) {
    return repository.findAll(page);
  } */
}
