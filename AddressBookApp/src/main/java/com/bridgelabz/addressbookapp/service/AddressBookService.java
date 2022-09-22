package com.bridgelabz.addressbookapp.service;
import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {

    @Autowired
    AddressBookRepository repository;

    public List<AddressBookEntity> getAllContacts() {
        return repository.findAll();
    }

    public AddressBookEntity saveContact(AddressBookEntity entity) {
        repository.save(entity);
        return entity;
    }

    public AddressBookEntity getContactByID(Integer id) {
        return repository.findById(id).get();
    }

    public String deleteContactByID(Integer id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return "deleted";
        }else {
            return "Record not found";
        }
    }

    public String updateContactById(Integer id, AddressBookEntity contactObj) {
        if(repository.findById(id).isPresent()) {
            contactObj.setId(id);
            AddressBookEntity newContact = new AddressBookEntity(contactObj);
            repository.save(contactObj);
            return "Updated Successfully";
        }else {
            return "Record not found";
        }
    }
}
