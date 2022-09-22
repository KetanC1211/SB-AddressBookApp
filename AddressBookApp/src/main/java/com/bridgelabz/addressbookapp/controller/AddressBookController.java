package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    @PostMapping("/save")
    public ResponseEntity<AddressBookEntity> save(@RequestBody AddressBookEntity obj){
        AddressBookEntity contactObj = addressBookService.saveContact(obj);
        return new ResponseEntity(contactObj , HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<AddressBookEntity> getContacts(){
        List<AddressBookEntity> contactObj = addressBookService.getAllContacts();
        return new ResponseEntity(contactObj , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookEntity> getContactByID(@PathVariable Integer id){
        AddressBookEntity contactObj = addressBookService.getContactByID(id);
        return new ResponseEntity(contactObj , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContactByID(@PathVariable Integer id){
        String message = addressBookService.deleteContactByID(id);
        return message;
    }

    @PutMapping("/update/{id}")
    public String getContactByID(@RequestBody AddressBookEntity contactObj,@PathVariable Integer id){
        String message = addressBookService.updateContactById(id,contactObj);
        return message;
    }
}
