package com.telenor.products.controller;

import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telenor.products.products.Product;
import com.telenor.products.repository.ProductRepository;

@RestController
@RequestMapping("/api")
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
			@RequestParam(value = "min_price", required = false) Integer minPrice,
			@RequestParam(value = "max_price", required = false) Integer maxPrice,
			@RequestParam(value = "gb_limit_min", required = false) Integer gb_limit_min,
			@RequestParam(value = "gb_limit_max", required = false) Integer gb_limit_max)
			throws JsonProcessingException {
		String jsonString = "";
		ObjectMapper objectmapper = new ObjectMapper();
		System.out.println("***** Inside The Controller *********");
		if (type != null || attribute != null || value != null || city != null || minPrice != null || maxPrice != null
				|| gb_limit_min != null || gb_limit_max != null) {
			jsonString = objectmapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(productRepo.findAll(new Specification<Product>() {
						@Override
						public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
							// TODO Auto-generated method stub

							Predicate p = cb.conjunction();
							if (Objects.nonNull(type)) {
								p = cb.and(p, cb.like(root.get("productType"), "%" + type + "%"));
							}
							if (Objects.nonNull(city)) {
								p = cb.and(p, cb.like(root.get("city"), "%" + city + "%"));
							}
							if (Objects.nonNull(minPrice)) {
								p = cb.and(p, cb.greaterThanOrEqualTo(root.get("price"), minPrice));
							}
							if (Objects.nonNull(maxPrice)) {
								p = cb.and(p, cb.lessThanOrEqualTo(root.get("price"), maxPrice));
							}

							return p;
						}
					}));
			if (!jsonString.equals("[ ]"))
				return "Search Result : " + jsonString;
			else {
				return "No matching values for current serach criteria !";
			}
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
