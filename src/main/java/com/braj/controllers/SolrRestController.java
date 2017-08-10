package com.braj.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.braj.entity.Person;
import com.braj.entity.PersonDetails;
import com.braj.repository.PersonRepository;

import com.braj.service.SolrService;

@RestController
public class SolrRestController {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	SolrService solrService;

	@RequestMapping(value = "/getServiceTest", method = RequestMethod.GET)
	public @ResponseBody String test1() {
		System.out.println("getServiceTest");
		return "testing";

	}

	@RequestMapping(value = "/getPersonDetailByNameId", method = RequestMethod.GET)
	public @ResponseBody PersonDetails personId(HttpServletResponse response,
			@RequestParam("personId") Long personId) {
		System.out.println("getPersonDetailByNameId");
		PersonDetails account = personRepository.findById(personId);
		System.out.println(account.getName());
		return account;

	}

	@RequestMapping(value = "/getPersonDetailByName", method = RequestMethod.GET)
	public @ResponseBody PersonDetails personName(HttpServletResponse response,
			@RequestParam("name") String name) {
		System.out.println("getPersonDetailByName");
		PersonDetails account = personRepository.findByName(name);
		System.out.println(account.getName());
		return account;

	}

	@RequestMapping(value = "/getPersonsDetailListByName", method = RequestMethod.GET)
	public @ResponseBody List<Person> emplNameList(
			HttpServletResponse response, @RequestParam("name") String name) {
		System.out.println("getPersonsDetailListByName");
		List<Person> account = solrService.getEmpDetailByName(name);
		System.out.println(account);
		return account;

	}

}
