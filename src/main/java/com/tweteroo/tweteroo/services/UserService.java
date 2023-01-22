package com.tweteroo.tweteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dto.UserDTO;
import com.tweteroo.tweteroo.model.Users;
import com.tweteroo.tweteroo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Users create(UserDTO dto){
        return repository.save(new Users(dto));
    }

    public List<Users> listAll(){
        return repository.findAll();
    }

    public Users findByUsername(String username){
        return repository.findByUsername(username);
    }
}
