package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;


    @PostMapping("/save")
    public ResponseEntity<AddressBookEntity> save(@Valid @RequestBody AddressBookDTO obj){
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
    public ResponseEntity<ResponseDTO> updateById(@Valid @RequestBody AddressBookDTO contactDto, @PathVariable Integer id){
        String message = iAddressBookService.updateByID(id,contactDto);
        ResponseDTO responseDTO=new ResponseDTO("Updated "+id+" ...", message );
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/sortByName")
    public ResponseEntity<ResponseDTO> sortByName(){
        ResponseDTO responseDTO=new ResponseDTO("Sorted By Name", iAddressBookService.sortByName());
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }

    @GetMapping("/searchByCity/{city}")
    public ResponseEntity<ResponseDTO> searchPersonByCity(@PathVariable String city){
        ResponseDTO responseDTO=new ResponseDTO("Sorted By Name", iAddressBookService.searchByCity(city));
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }
    @GetMapping("/searchByState/{state}")
    public ResponseEntity<ResponseDTO> searchPersonByState(@PathVariable String state){
        ResponseDTO responseDTO=new ResponseDTO("Sorted By Name", iAddressBookService.searchByState(state));
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> findAllByOrderByCity(){
        ResponseDTO responseDTO=new ResponseDTO("Sorted By City ", iAddressBookService.findAllByOrderByCity());
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }

    @GetMapping("/searchByPhoneNumber/{phoneNumber}")
    public ResponseEntity<ResponseDTO> searchPersonByPhone(@PathVariable String phoneNumber){
        ResponseDTO responseDTO=new ResponseDTO("Search By Phone Number", iAddressBookService.searchPersonByPhone(phoneNumber));
        return new ResponseEntity(responseDTO , HttpStatus.OK);
    }
}
