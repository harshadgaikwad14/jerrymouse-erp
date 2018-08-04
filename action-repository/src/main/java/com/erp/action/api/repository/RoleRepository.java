package com.erp.action.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erp.action.api.model.Role;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
