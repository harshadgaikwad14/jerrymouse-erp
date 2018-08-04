package com.erp.action.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erp.action.api.model.Address;



@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
