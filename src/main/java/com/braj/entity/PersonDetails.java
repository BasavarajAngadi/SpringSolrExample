package com.braj.entity;

import javax.persistence.Id;

import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "MyApp")
public class PersonDetails  {
	
	@Id
    @Indexed(name = "id", type = "long")
    private long id;

    @Indexed(name = "name", type = "string")
    private String name;
    @Indexed(name = "lastName", type = "string")
    private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	

	



	
  

}