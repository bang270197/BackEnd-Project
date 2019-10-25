package com.codegym.c0319h2.quanlycongty.service.UserService.impl;

import com.codegym.c0319h2.quanlycongty.model.User;
import com.codegym.c0319h2.quanlycongty.repository.UserRepository;
import com.codegym.c0319h2.quanlycongty.service.UserService.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.getFile;

@Service
@PropertySource("classpath:application.properties")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Value(value = "${file.upload-dir}")
    private String imgUser;
    @Override
    public Optional<User> findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveFileUser(MultipartFile multipartFile) {
        File uploadedFile = new File(imgUser, multipartFile.getOriginalFilename());
        try {
            uploadedFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File callFileUser(User user) throws FileNotFoundException {
        String pathFile = imgUser + user.getAvatar();
        File fileName = ResourceUtils.getFile(pathFile);
        return fileName;
    }

    @Override
    public void deleteFileUser(User user) throws IOException {
        String pathFile = imgUser + '/' + user.getAvatar();
        try {
            File avatar = FileUtils.getFile(pathFile);
            FileUtils.forceDelete(avatar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
