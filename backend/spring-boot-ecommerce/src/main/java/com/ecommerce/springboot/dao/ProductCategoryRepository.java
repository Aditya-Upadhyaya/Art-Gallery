package com.ecommerce.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.springboot.entity.ProductCategory;


@CrossOrigin("http://localhost:4200")      //Accept call from web browser script from this origin protocol+hostName+post
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

	
}
