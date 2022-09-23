package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String country;

    public AddressBookEntity(int id, String fullName, String phoneNumber, String address, String city, String state, String zip, String email, String country) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.country = country;
    }

//    public AddressBookEntity(AddressBookDTO dtoContactObj) {
//        this.id=dtoContactObj.getId();
//        this.fullName=dtoContactObj.getFullName();
//        this.phoneNumber=dtoContactObj.getPhoneNumber();
//        this.address=dtoContactObj.getAddress();
//        this.city=dtoContactObj.getCity();
//        this.state=dtoContactObj.getState();
//        this.zip=dtoContactObj.getZip();
//        this.email=dtoContactObj.getEmail();
//    }

    public AddressBookEntity(AddressBookDTO dtoContactObj) {
        this.fullName=dtoContactObj.getFullName();
        this.phoneNumber=dtoContactObj.getPhoneNumber();
        this.address=dtoContactObj.getAddress();
        this.city=dtoContactObj.getCity();
        this.state=dtoContactObj.getState();
        this.zip=dtoContactObj.getZip();
        this.email=dtoContactObj.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressBookEntity() {
    }
}
