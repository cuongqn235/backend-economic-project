package net.codejava.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Model.Product;
import net.codejava.repository.ProductRepository;
import net.codejava.response.StatusResp;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired private ProductRepository repo;
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody @Valid Product product) {
		Product savedProduct = repo.save(product);
		URI productURI = URI.create("/products/" + savedProduct.getId());
		return ResponseEntity.created(productURI).body(savedProduct);
	}
	
	@GetMapping
	public  StatusResp list() {
		StatusResp resp = new StatusResp();
		List<Product> products = repo.findAll();
		resp.setData(products);
		return resp;
	}
}
