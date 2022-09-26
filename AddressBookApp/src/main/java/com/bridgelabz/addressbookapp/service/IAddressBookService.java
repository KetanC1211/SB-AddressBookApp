package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import java.util.List;


public interface IAddressBookService {
    List<AddressBookEntity> listAllContact();

    Object saveContact(AddressBookDTO dtoContactObj);

    AddressBookEntity getContactByID(Integer id);

    String deleteContactById(Integer id);

    String updateByID(Integer id, AddressBookDTO contactObj);

    List<AddressBookEntity> sortByName();

    List<AddressBookEntity> searchByCity(String city);
    List<AddressBookEntity> searchByState(String city);
    List<AddressBookEntity> findAllByOrderByCity();

    List<AddressBookEntity> searchPersonByPhone(String phoneNumber);
}
