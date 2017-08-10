package com.braj.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braj.entity.Person;
import com.braj.repository.PersonRepository;

@SuppressWarnings("deprecation")
@Service
public class SolrService {

	@Autowired
	PersonRepository accountRepository;

	public List<Person> getEmpDetailByName(String name) {
		@SuppressWarnings("resource")
		HttpSolrServer solrServer = new HttpSolrServer(
				"http://localhost:8983/solr/MyApp");

		SolrQuery query = new SolrQuery().setRows(Integer.MAX_VALUE);
		query.setQuery("lastName:" + name);
		query.addField("*");
		List<Person> items = null;

		try {
			QueryResponse queryResponse = solrServer.query(query);
			System.out.println("queryResponse :" + queryResponse);
			SolrDocumentList docList = queryResponse.getResults();
			System.out.println("docList:" + docList);
			DocumentObjectBinder binder = new DocumentObjectBinder();
			List<Person> dataList = binder.getBeans(Person.class, docList);
			System.out.println("dataList:" + dataList);
			items = queryResponse.getBeans(Person.class);
			solrServer.commit();
		} catch (SolrServerException | IOException e) {
			
			e.printStackTrace();
		}
		return items;

	}

}
