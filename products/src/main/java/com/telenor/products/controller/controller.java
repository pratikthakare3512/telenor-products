package com.telenor.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.telenor.products.repository.ProductRepository;

public class controller {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/product")
	public Model showProducts(Model model) {
				
		model.addAttribute(productRepo);
		return model;
		
		
	}

}
