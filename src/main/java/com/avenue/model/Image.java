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

@Entity(name = "image")
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_image", sequenceName = "seq_image")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_image")
	private Long id;

	@Column(name = "type", nullable = false, length = 150)
	@NotBlank(message = "Please insert the Type.")
	private String type;

	@Transient
	private boolean associated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAssociated() {
		return associated;
	}

	public void setAssociated(boolean associated) {
		this.associated = associated;
	}

}
