package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookCustomException;
import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    public Object saveContact(AddressBookDTO dtoContactObj) {
        List<AddressBookEntity> contactList = repository.findAll();
        for(AddressBookEntity p :contactList){
            if(p.getFullName().equals(dtoContactObj.getFullName())){
                return  "Name already exit enter new name";
            }
        }
        AddressBookEntity entiyContactObj = new AddressBookEntity(dtoContactObj);
        repository.save(entiyContactObj);
        return entiyContactObj;
    }

    @Override
    public AddressBookEntity getContactByID(Integer id) {
        return repository.findById(id).orElseThrow(()-> new AddressBookCustomException("Contact not found for "+id+" in reords"));
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
            List<AddressBookEntity> contactList = repository.findAll();
            for(AddressBookEntity p :contactList){
                if(p.getFullName().equals(contactObj.getFullName())){
                    return  "Name already exit enter new name";
                }
            }
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

    @Override
    public List<AddressBookEntity> searchByCity(String city) {
        return repository.findByCity(city);
    }
    @Override
    public List<AddressBookEntity> searchByState(String state) {
        return repository.findByState(state);
    }

    @Override
    public List<AddressBookEntity> findAllByOrderByCity() {
        return repository.findAllByOrderByCity();
    }
    @Override
    public List<AddressBookEntity> searchPersonByPhone(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
