package com.avenue.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_product", sequenceName = "seq_product")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
	private Long id;

	@Column(name = "name", nullable = false, length = 150)
	@NotBlank(message = "Please insert the Name.")
	private String name;

	@Column(name = "parent", nullable = true)
	private Long parentProduct;

	@Column(name = "image", nullable = true)
	private Long image;

	@Transient
	private Long parentId;

	@Transient
	private Long imageId;

	@Transient
	private String parentName;

	@Transient
	private String imageName;

	@Transient
	private String error;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public Long getParentProduct() {
		return parentProduct;
	}

	public void setParentProduct(Long parentProduct) {
		this.parentProduct = parentProduct;
	}

	public Long getImage() {
		return image;
	}

	public void setImage(Long image) {
		this.image = image;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
