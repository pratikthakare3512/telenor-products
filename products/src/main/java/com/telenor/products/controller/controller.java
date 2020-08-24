package com.telenor.products.controller;

import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telenor.products.products.Product;
import com.telenor.products.repository.ProductRepository;

@RestController
public class controller {

	@Autowired
	private ProductRepository productRepo;

	@RequestMapping("/")
	public String defaultMessage() {
		return "Please user Correct endpoint : http://localhost:8080/product ";
	}

	@RequestMapping("/product")
	public String showProducts(@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "property", required = false) String attribute,
			@RequestParam(value = "value", required = false) String value,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "min_price", required = false) String minPrice,
			@RequestParam(value = "max_price", required = false) String maxPrice,
			@RequestParam(value = "max_price", required = false) String gb_limit_min,
			@RequestParam(value = "max_price", required = false) String gb_limit_max) throws JsonProcessingException {
		String jsonString = "";
		ObjectMapper objectmapper = new ObjectMapper();
		System.out.println("***** Inside The Controller *********");
		if (type != null || attribute != null || value != null || city != null || minPrice != null || maxPrice != null
				|| gb_limit_min != null || gb_limit_max != null) {
			System.out.println("***** Inside The Controller -Search Criteria *********");
			jsonString = objectmapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(productRepo.findAll(new Specification<Product>() {
						@Override
						public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
							// TODO Auto-generated method stub
							Predicate p = cb.conjunction();
							if (Objects.nonNull(type)) {
								p = cb.and(p, cb.like(root.get("productType"), "%" + type + "%"));
							}
							return p;
						}
					}));
			return "wow got the value " + jsonString;
		} else {
			try {
				jsonString = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(productRepo.findAll());
				System.out.println("json :" + jsonString);
			} catch (Exception e) {
				jsonString = "No data in Table";
				System.out.println("No data in Table !!!");
			}
			return jsonString;

		}
	}

}
