package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;


    @PostMapping("/save")
    public ResponseEntity<AddressBookEntity> save(@RequestBody AddressBookDTO obj){
        AddressBookEntity contactObj = iAddressBookService.saveContact(obj);
        ResponseDTO responseDTO =new ResponseDTO("Employee added successfully", contactObj);
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getContacts(){
        ResponseDTO responseDTO=new ResponseDTO("Display of All Contact", iAddressBookService.listAllContact());
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }

    @GetMapping("/getContact/{id}")
    public ResponseEntity<AddressBookEntity> getContactByID(@PathVariable Integer id){
        AddressBookEntity contactObj = iAddressBookService.getContactByID(id);
        ResponseDTO responseDTO=new ResponseDTO("Call for Id successful", contactObj);
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContactByID(@PathVariable Integer id){
        String message = iAddressBookService.deleteContactById(id);
        return message;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById( @RequestBody AddressBookDTO contactDto, @PathVariable Integer id){
        String message = iAddressBookService.updateByID(id,contactDto);
        ResponseDTO responseDTO=new ResponseDTO("Updated "+id+" ...", message );
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
