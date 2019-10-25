package com.codegym.c0319h2.quanlycongty.service.companyService.impl;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.codegym.c0319h2.quanlycongty.service.companyService.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import static org.springframework.util.ResourceUtils.getFile;
@Service
@PropertySource("classpath:application.properties")
public class FileServiceImpl implements FileService {
    @Value(value = "${file.upload-logo-company}")
    private String imglogo;
    @Value(value = "${file.upload-img-company}")
    private String img;
   //luu file len sever
    @Override
    public void saveFileLogo(MultipartFile multipartFile) {
        File uploadedFile = new File(imglogo, multipartFile.getOriginalFilename());
        try {
            uploadedFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   //goi file de xoa
    @Override
    public File callFileLogo(Company company) throws FileNotFoundException {
        String pathFile = imglogo + company.getCompanylogo();
        File fileName = getFile(pathFile);
        return fileName;
    }
    //xoa file bang doi tuong truyen vao
    @Override
    public void deleteLogo(Company company) throws IOException {
        String pathFile = imglogo + '/' + company.getCompanylogo();
        try {
            File avatar = FileUtils.getFile(pathFile);
            FileUtils.forceDelete(avatar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






  //lu file len server
    @Override
    public void saveFileLImage(MultipartFile multipartFile) {
        File uploadedFile = new File(img, multipartFile.getOriginalFilename());
        try {
            uploadedFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //ham goi file de xoa
    @Override
    public File callFileImage(Optional<Company> company) throws FileNotFoundException {
        String pathFile = img + company.get().getCompanyavatar();
        File fileName = getFile(pathFile);
        return fileName;
    }

    @Override
    public void deleteImage(Company company) throws IOException {
        String pathFile = img + company.getCompanyavatar();
        try {
            File avatar = FileUtils.getFile(pathFile);
            FileUtils.forceDelete(avatar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
