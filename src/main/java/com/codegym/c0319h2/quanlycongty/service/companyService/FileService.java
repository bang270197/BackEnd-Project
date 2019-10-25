package com.codegym.c0319h2.quanlycongty.service.companyService;

import org.springframework.web.multipart.MultipartFile;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface FileService {
    void saveFileLogo(MultipartFile multipartFile);
    File callFileLogo(Company company) throws FileNotFoundException;
    void deleteLogo(Company company) throws IOException;

    void saveFileLImage(MultipartFile multipartFile);
    File callFileImage(Optional<Company> company) throws FileNotFoundException;
    void deleteImage(Company company) throws IOException;
}
