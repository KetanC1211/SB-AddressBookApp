package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Integer> {

    List<AddressBookEntity> findAllByOrderByFullName();
    List<AddressBookEntity> findByCity(String city);
    List<AddressBookEntity> findByState(String city);
    List<AddressBookEntity> findAllByOrderByCity();
    List<AddressBookEntity> findByPhoneNumber(String phoneNumber);


}
