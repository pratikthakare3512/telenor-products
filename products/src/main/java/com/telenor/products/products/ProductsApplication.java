package com.telenor.products.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.telenor.products.repository.ProductRepository;

@SpringBootApplication
@ComponentScan({"com.telenor.products"})
@EntityScan("com.telenor.products")
@EnableJpaRepositories("com.telenor.products.repository")
public class ProductsApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productRepo.save(new Product("phone",277,"Blake grnden, Karlskrona","color","green"));
		productRepo.save(new Product("subscription",415,"Odell gatan, Stockholm","gb_limit","50"));
		productRepo.save(new Product("subscription",202,"Fausto vgen, Karlskrona","gb_limit","10"));
		productRepo.save(new Product("phone",130,"Gustafsson grdet, Stockholm","color","purple"));
		productRepo.save(new Product("subscription",277,"Blake grnden, Karlskrona","gb_limit","20"));
		productRepo.save(new Product("subscription",211,"Blake grnden, Karlskrona","gb_limit","40"));
		productRepo.save(new Product("phone",277,"Blake grnden, Stockholm","color","green"));
		
		
		
	}

}
