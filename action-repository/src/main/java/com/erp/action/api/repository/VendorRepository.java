package com.erp.action.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erp.action.api.model.Vendor;



@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

}
