package com.jerrymouse.action.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jerrymouse.action.api.model.VendorType;



@Repository
public interface VendorTypeRepository extends CrudRepository<VendorType, Long> {

}
