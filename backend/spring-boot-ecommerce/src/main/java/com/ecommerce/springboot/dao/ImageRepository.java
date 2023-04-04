package com.ecommerce.springboot.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.springboot.entity.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
	@Modifying      // to mark delete or update query
    @Query(value = "DELETE FROM ImageModel e WHERE e.name = :name")       // it will delete all the record with specific name
    void deleteByName(@Param("name") String name);
}
