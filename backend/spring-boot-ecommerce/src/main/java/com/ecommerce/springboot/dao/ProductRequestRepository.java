package com.ecommerce.springboot.dao;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import com.ecommerce.springboot.entity.ProductRequest;

@CrossOrigin("http://localhost:4200")
public interface ProductRequestRepository extends JpaRepository<ProductRequest, Long> {
             
	Page<ProductRequest> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
	Page<ProductRequest> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
	

}
