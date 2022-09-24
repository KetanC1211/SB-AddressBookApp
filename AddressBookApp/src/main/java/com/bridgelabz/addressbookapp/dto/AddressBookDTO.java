package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class AddressBookDTO {
    @NotEmpty(message = "Name Field can't be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}$",message = "Enter Proper Format of name")
    private String fullName;
    @NotEmpty(message = "Name Field can't be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Enter valid format for phone number")
    private String phoneNumber;
    @NotEmpty(message = "Name Field can't be empty")
    private String address;
    @NotEmpty(message = "Name Field can't be empty")
    private String city;
    @NotEmpty(message = "Name Field can't be empty")
    private String state;
    @NotEmpty(message = "Name Field can't be empty")
    @Pattern(regexp ="^[0-9]{6}$",message = "Enter proper pin")
    private String zip;
    @Email
    private String email;
    @NotEmpty(message = "Name Field can't be empty")
    private String country;
}
