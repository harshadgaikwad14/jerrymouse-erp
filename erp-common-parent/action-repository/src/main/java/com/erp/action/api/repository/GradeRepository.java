package com.erp.action.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erp.action.api.model.Grade;



@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {

}
