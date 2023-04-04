package com.ecommerce.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.springboot.dao.ProductCategoryRepository;
import com.ecommerce.springboot.entity.ProductCategory;

@Service
@Transactional
public class ProductCategoryService {
	
	@Autowired
    private ProductCategoryRepository productRepository;
	
    public List<ProductCategory> listAllUser() {
        return productRepository.findAll();
    }

    public void saveUser(ProductCategory user) {
    	System.out.println("In Service ADD Product");
    	System.out.println(user);
        productRepository.save(user);
    }

    public ProductCategory getUser(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id) {
    	System.out.println("In Service");
        productRepository.deleteById(id);
    }

}
