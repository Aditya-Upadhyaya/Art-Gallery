package com.ecommerce.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.springboot.dao.ProductRequestRepository;
import com.ecommerce.springboot.entity.ProductRequest;


@Service
@Transactional
public class ProductRequestService {
	
	@Autowired
    private ProductRequestRepository productRepository;
	
	
    public List<ProductRequest> listAllUser() {
        return productRepository.findAll();
    }

    public void saveUser(ProductRequest user) {
    	System.out.println("In  Request Service ADD Product");
    	System.out.println(user);
        productRepository.save(user);
    }

    public ProductRequest getUser(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id) {
    	System.out.println("In Request Service");
        productRepository.deleteById(id);
    }

    
    
}
