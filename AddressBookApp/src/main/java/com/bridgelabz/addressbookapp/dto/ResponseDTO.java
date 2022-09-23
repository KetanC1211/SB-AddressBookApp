package com.bridgelabz.addressbookapp.dto;

import com.bridgelabz.addressbookapp.model.AddressBookEntity;

public class ResponseDTO {
    public String message;
    public Object content;



    public ResponseDTO(String message, Object content) {
        this.message = message;
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
