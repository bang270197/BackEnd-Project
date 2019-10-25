package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.EditUserProfileForm;
import com.codegym.c0319h2.quanlycongty.model.User;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.codegym.c0319h2.quanlycongty.service.UserService.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.getFile;

@RestController
@CrossOrigin
@PropertySource("classpath:application.properties")
public class UserController {
    @Autowired
    private UserService userService;

    @Value(value = "${file.upload-dir}")
    private String imgUser;

    @GetMapping("/getUser/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name){
        Optional<User> user = userService.findByUserName(name);
        User user1 = user.get();
        if (user1 == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user1 , HttpStatus.OK);
    }


    //thêm ảnh vào user
    @PostMapping ("/editAvatar")
    public ResponseEntity<User> updateAvatar(@RequestPart("username") String username,@RequestPart("avatar") MultipartFile file) throws IOException {
        Optional<User> userOptional = userService.findByUserName(username);
        User user = userOptional.get();
        String fileName = file.getOriginalFilename();
        if (user !=null){
            if (user.getAvatar() !=null){
                userService.deleteFileUser(user);
                user.setAvatar(fileName);
                userService.saveFileUser(file);
                userService.save(user);
                return new ResponseEntity<User>(user,HttpStatus.OK);
            }
            else {
                user.setAvatar(fileName);
                userService.saveFileUser(file);
                userService.save(user);
                return new ResponseEntity<User>(user,HttpStatus.OK);
            }

        }else
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }









//    @PutMapping("/editUser/{username}")
//    public ResponseEntity<User> updateUser(@PathVariable String username,@RequestBody EditUserProfileForm editUserProfileForm){
//        Optional<User> user = userService.findByUserName(username);
//        User user1 = user.get();
//        if ()
//    }




//    user sua doi thong tin ngay,sdt,diachi
    @PutMapping("/editUser/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody EditUserProfileForm Edituser) {

        Optional<User> userOptional = userService.findByUserName(username);
       User user = userOptional.get();
        if (user !=null){
            user.setBirthdate(Edituser.getBirthdate());
            user.setPhonenumber(Edituser.getPhonenumber());
            user.setAddress(Edituser.getAddress());
            userService.save(user);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
       return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
  }

}
