package com.pet.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pet.clinic.common.json.JsonResponse;

@RestController
@RequestMapping("/hello")
public class test {

	@Autowired
	private JsonResponse jsonResponse;
	
	@RequestMapping(value = "/world" ,method = RequestMethod.GET )
	public String hello() {
		return jsonResponse.okWithData("helloworld");
	}
}
