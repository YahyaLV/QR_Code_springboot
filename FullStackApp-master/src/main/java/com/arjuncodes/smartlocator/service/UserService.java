package com.arjuncodes.smartlocator.service;

import java.util.List;
import com.arjuncodes.smartlocator.model.User;


public interface UserService {
    public User saveUser(User user);
    public List<User> getUsers();
    public User findById(int id);
}
