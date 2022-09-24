package com.bridgelabz.addressbookapp.dto;

import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    public String message;
    public Object content;
}
