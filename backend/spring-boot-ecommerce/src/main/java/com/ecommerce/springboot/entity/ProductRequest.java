package com.ecommerce.springboot.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "productrequest")
@Data
public class ProductRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //Auto generated id
	@Column(name = "id")
	private Long id;

	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private ProductCategory category;

	 @JsonIgnore
	 @OneToOne(mappedBy = "productId" )
	 private ImageModel productId;
	 
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "seller_name")
	private String sellerName;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "active")
	private boolean active;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	@Column(name = "date_created")
	@CreationTimestamp            //Hibernate will automatically manage the timestamps
	private Date dateCreated;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private Date lastUpdated;
	
	public Long getResourceId() {
		return id;
	}
	public String getCategoryName() {
		return category.getCategoryName();
	}

}
