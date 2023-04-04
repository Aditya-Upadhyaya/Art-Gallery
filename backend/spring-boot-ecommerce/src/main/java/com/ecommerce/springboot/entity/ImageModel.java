package com.ecommerce.springboot.entity;

import javax.persistence.*;

import lombok.Data;
@Entity
@Data
@Table(name = "image_table")
public class ImageModel {

	
	
	
	public ImageModel() {
		super();
	}
	public ImageModel(String name, String type, byte[] picByte) {
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "picByte", length = 1000)
	private byte[] picByte;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	@JoinColumn(name = "product_id",  referencedColumnName = "id")
	private ProductRequest productId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	@JoinColumn(name = "main_product_id",  referencedColumnName = "id")
	private ProductRequest main_product_id;
	
	
	public Long getResourceId() {
		return id;
	}
	
	
	}
