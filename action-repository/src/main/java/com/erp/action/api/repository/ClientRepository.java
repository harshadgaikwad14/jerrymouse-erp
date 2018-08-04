package com.erp.action.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erp.action.api.model.Client;



@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	public Client findByClientNameAndActive(String clientName, boolean active);

}
