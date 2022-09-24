package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


    public AddressBookEntity(AddressBookDTO dtoContactObj) {
        this.fullName=dtoContactObj.getFullName();
        this.phoneNumber=dtoContactObj.getPhoneNumber();
        this.address=dtoContactObj.getAddress();
        this.city=dtoContactObj.getCity();
        this.state=dtoContactObj.getState();
        this.zip=dtoContactObj.getZip();
        this.email=dtoContactObj.getEmail();
        this.country=dtoContactObj.getCountry();
    }

}
