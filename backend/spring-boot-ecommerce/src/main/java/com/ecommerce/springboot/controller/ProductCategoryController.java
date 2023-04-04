package com.ecommerce.springboot.controller;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.springboot.entity.ProductCategory;
import com.ecommerce.springboot.service.ProductCategoryService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/admin-category")
public class ProductCategoryController {
	 
	@Autowired
    ProductCategoryService productService;
	
	@GetMapping("/")
    public List<ProductCategory> list() {
		System.out.println("In Request Controller GET Products");
        return productService.listAllUser();
    }

    @PostMapping("/")
    public void add(@RequestBody ProductCategory user) {
    	System.out.println("In Controller ADD Product");
    	
        productService.saveUser(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductCategory user, @PathVariable Long id) {
        try {
            @SuppressWarnings("unused")
			ProductCategory existUser = productService.getUser(id);
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
