package com.codegym.c0319h2.quanlycongty.model.company;

import com.codegym.c0319h2.quanlycongty.model.Language.Language;
import com.codegym.c0319h2.quanlycongty.model.Market.Market;
import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.model.Specialize.Specialize;
import com.codegym.c0319h2.quanlycongty.model.Tag.Tags;
import com.codegym.c0319h2.quanlycongty.model.technology.Technology;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "shortname")
    private String shortname;

    @Column(name = "address")
    private String address;

    @Column(name = "website")
    private String website;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "email")
    private String email;

    @Column(name = "introductoryinformation")
    private String introductoryinformation;

    @Column(name = "companylogo")
    private String companylogo;

    @Column(name = "companyavatar")
    private ArrayList<String> companyavatar;

//    ArrayList<String> avatar = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name = "Relationship_id")
    private Relationship relationship;

    @ManyToMany(targetEntity = Specialize.class)
    private List<Specialize> specialize;

    @ManyToMany(targetEntity = Language.class)
    private List<Language> language;


    @ManyToMany(targetEntity = Technology.class)
    private List<Technology> technology;



//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JsonManagedReference("playlist-song")
//    @JoinTable(
//            name = "playlist_song",
//            joinColumns = @JoinColumn(
//                    name = "playlist_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "song_id", referencedColumnName = "id"))
//    @Fetch(value = FetchMode.SUBSELECT)
//    private Collection<Song> songs;



    @ManyToMany(targetEntity = Market.class)
    private List<Market> market;

    @Column(name = "note")
    private String note;


    @Column(name = "active")
    private boolean active;

    @ManyToMany(targetEntity = Tags.class)
    private List<Tags> tags;
    public Company() {
    }

//    public Company(String companyName, String shortname, String address, String website, String phonenumber, String email, String introductoryinformation, String relationship, String specialize, String language, List<Technology> technology, String market, String note) {
//        this.companyName = companyName;
//        this.shortname = shortname;
//        this.address = address;
//        this.website = website;
//        this.phonenumber = phonenumber;
//        this.email = email;
//        this.introductoryinformation = introductoryinformation;
//        this.relationship = relationship;
//        this.specialize = specialize;
//        this.language = language;
//        this.technology = technology;
//        this.market = market;
//        this.note = note;
//    }

//test Technology




    public Company(String companyName, String shortname, String address, String website, String phonenumber, String email, String introductoryinformation, Relationship relationship, List<Specialize> specialize, List<Language> language, List<Technology> technology, List<Market> market, String note, boolean active,List<Tags> tags) {
        this.companyName = companyName;
        this.shortname = shortname;
        this.address = address;
        this.website = website;
        this.phonenumber = phonenumber;
        this.email = email;
        this.introductoryinformation = introductoryinformation;
        this.relationship = relationship;
        this.specialize = specialize;
        this.language = language;
        this.technology = technology;
        this.market = market;
        this.note = note;
        this.active = active;
        this.tags = tags;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroductoryinformation() {
        return introductoryinformation;
    }

    public void setIntroductoryinformation(String introductoryinformation) {
        this.introductoryinformation = introductoryinformation;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public ArrayList<String> getCompanyavatar() {
        return companyavatar;
    }

    public void setCompanyavatar(ArrayList<String> companyavatar) {
        this.companyavatar = companyavatar;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public List<Specialize> getSpecialize() {
        return specialize;
    }

    public void setSpecialize(List<Specialize> specialize) {
        this.specialize = specialize;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public List<Technology> getTechnology() {
        return technology;
    }

    public void setTechnology(List<Technology> technology) {
        this.technology = technology;
    }

    public List<Market> getMarket() {
        return market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
