package com.braj.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.braj.entity.PersonDetails;


public interface PersonRepository extends SolrCrudRepository<PersonDetails, Integer> {
	PersonDetails findById(long acctId);
	PersonDetails findByName(String name);
	
}
