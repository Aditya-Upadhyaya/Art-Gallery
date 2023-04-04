package com.ecommerce.springboot.service;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.springboot.dao.ProductRepository;
import com.ecommerce.springboot.entity.Product;

@Service
@Transactional
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;
    public List<Product> listAllUser() {
        return productRepository.findAll();
    }

    public void saveUser(Product user) {
    	System.out.println("In Service ADD Product");
    	System.out.println(user);
        productRepository.save(user);
    }

    public Product getUser(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id) {
    	System.out.println("In Service");
        productRepository.deleteById(id);
    }
    
  
    

}
