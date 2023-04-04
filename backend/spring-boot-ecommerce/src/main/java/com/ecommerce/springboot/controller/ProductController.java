package com.ecommerce.springboot.controller;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.springboot.entity.Product;

import com.ecommerce.springboot.service.ProductService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/admin")
public class ProductController {
	 
	@Autowired
    ProductService productService;

	
	

   
    @PostMapping("/")
    public void add(@RequestBody Product user) {
    	System.out.println("In Controller ADD Product");
    	
        productService.saveUser(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product user, @PathVariable Long id) {
        try {
            @SuppressWarnings("unused")
			Product existUser = productService.getUser(id);
            user.setId(id);            
            productService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        System.out.println("In Delete Mapping");
        productService.deleteProduct(id);
    }
    
}
