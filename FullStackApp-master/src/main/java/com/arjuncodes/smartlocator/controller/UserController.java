package com.arjuncodes.smartlocator.controller;

import com.arjuncodes.smartlocator.model.User;
import com.arjuncodes.smartlocator.service.UserService;
import com.arjuncodes.smartlocator.utils.QRCodeGenerator;
import com.google.zxing.WriterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user){
    	userService.saveUser(user);
        return "New user is added";
    }

 
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }
    
                                            //getall(qr)
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers() throws IOException, WriterException {
        List<User> users = userService.getUsers();
        if (users.size() != 0){
            for (User user : users){
                QRCodeGenerator.generateQRCode(user);
            }
        }
        return ResponseEntity.ok(userService.getUsers());
    }
}
