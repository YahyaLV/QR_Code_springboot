package com.arjuncodes.smartlocator.service;

import com.arjuncodes.smartlocator.model.User;
import com.arjuncodes.smartlocator.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
    @Override
    public User findById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }
}
