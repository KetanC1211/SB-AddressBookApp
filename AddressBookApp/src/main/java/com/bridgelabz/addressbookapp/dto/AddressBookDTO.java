package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private String fullName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String country;
}
