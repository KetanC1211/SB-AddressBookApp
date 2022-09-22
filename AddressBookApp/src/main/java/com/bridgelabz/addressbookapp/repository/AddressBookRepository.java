package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Integer> {

}
