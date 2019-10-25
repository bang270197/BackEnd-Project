package com.codegym.c0319h2.quanlycongty.service.UserService;

import com.codegym.c0319h2.quanlycongty.model.User;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUserName(String name);

    void save(User user);

    void saveFileUser(MultipartFile multipartFile);

    File callFileUser(User user) throws FileNotFoundException;

    //xoa theo user
    void deleteFileUser(User user) throws IOException;

}
