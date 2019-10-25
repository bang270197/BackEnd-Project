package com.codegym.c0319h2.quanlycongty.model.Relationship;

import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "relationship")
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Company.class)
    @JsonIgnore
    private List<Company> company;

    public Relationship() {
    }

    public Relationship(String name, List<Company> company) {
        this.name = name;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }
}
