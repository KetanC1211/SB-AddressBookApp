package com.bridgelabz.addressbookapp.service;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AddressBookService implements IAddressBookService {
    @Autowired
    AddressBookRepository repository;
    @Override
    public List<AddressBookEntity> listAllContact() {
        return repository.findAll();
    }

    @Override
    public AddressBookEntity saveContact(AddressBookDTO dtoContactObj) {
        AddressBookEntity entiyContactObj = new AddressBookEntity(dtoContactObj);
        repository.save(entiyContactObj);
        return entiyContactObj;
    }

    @Override
    public AddressBookEntity getContactByID(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public String deleteContactById(Integer id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return "deleted";
        }else {
            return "Record not found";
        }
    }


    @Override
    public String updateByID(Integer id, AddressBookDTO contactObj) {
        if(repository.findById(id).isPresent()) {
            AddressBookEntity newContact = new AddressBookEntity(contactObj);
            newContact.setId(id);
            repository.save(newContact);
            return "Updated Successfully";
        }else {
            return "Record not found";
        }
    }

    @Override
    public List<AddressBookEntity> sortByName() {
        return repository.findAllByOrderByFullName();
    }

}
