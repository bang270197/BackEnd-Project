package com.codegym.c0319h2.quanlycongty.model.company;


import com.codegym.c0319h2.quanlycongty.model.Language.Language;
import com.codegym.c0319h2.quanlycongty.model.Market.Market;
import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.model.Specialize.Specialize;
import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;

public class FormCompany {


    private Long id;


    private String companyName;


    private String shortname;


    private String address;


    private String website;


    private String phonenumber;


    private String email;


    private String introductoryinformation;


    private String companylogo;


    private String companyavatar;


    private Relationship relationship;


    private List<Specialize> specialize;


    private List<Language> language;



    private List<Technology> technology;



    private List<Market> market;


    private String note;


}
