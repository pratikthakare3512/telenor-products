package com.telenor.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telenor.products.repository.ProductRepository;

@RestController
public class controller {
	
	@Autowired
	private ProductRepository productRepo;
	
	@RequestMapping("/product")
	public String showProducts(Model model) {
		System.out.println("***** Inside The Controller *********");
		model.addAttribute(productRepo.findAll());
		System.out.println(model.toString());
		String jsonString = "";
		
		ObjectMapper objectmapper = new ObjectMapper();
		
		try {
			 jsonString = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(model);
			System.out.println("json :"+jsonString);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return jsonString;
		
		
	}

}
