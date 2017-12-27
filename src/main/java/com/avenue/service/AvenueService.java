package com.avenue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.avenue.model.Image;
import com.avenue.model.Product;
import com.avenue.repository.ImageRepository;
import com.avenue.repository.ProductRepository;

@Service
public class AvenueService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ImageRepository imageRepository;

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public List<Image> findAllImages() {
		return imageRepository.findAll();
	}

	public Product findOneProduct(Long id) {
		return productRepository.findOne(id);
	}

	public Image findOneImage(Long id) {
		return imageRepository.findOne(id);
	}

	public Product saveProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

	public Image saveImage(Image image) {
		return imageRepository.saveAndFlush(image);
	}

	public Product searchProductByName(String name) {
		return productRepository.searchProductByName(name);
	}
	
	public List<Product> searchProductByParent(Long parentId) {
		return productRepository.searchProductByParent(parentId);
	}
	
	public List<Product> searchProductByImage(Long image) {
		return productRepository.searchProductByImage(image);
	}

	public List<Product> searchProductsByParams(Product product) {

		if (product.getId() != null && !"".equals(product.getName()) && product.getParentId() != null && product.getImage() == null) {
			return productRepository.searchProductByNameIdParent(product.getName(), product.getId(),
					product.getParentId());
		} else if (product.getId() != null && !"".equals(product.getName()) && product.getParentId() == null && product.getImage() == null) {
			return productRepository.searchProductByNameId(product.getName(), product.getId());
		} else if (product.getId() == null && !"".equals(product.getName()) && product.getParentId() == null && product.getImage() == null) {
			return productRepository.searchProductByNameList(product.getName());
		} else if (product.getId() != null && "".equals(product.getName()) && product.getParentId() == null && product.getImage() == null) {
			return productRepository.searchProductById(product.getId());
		} else if (product.getId() != null && "".equals(product.getName()) && product.getParentId() != null && product.getImage() == null) {
			return productRepository.searchProductByIdParent(product.getId(), product.getParentId());
		} else if (product.getId() == null && !"".equals(product.getName()) && product.getParentId() != null && product.getImage() == null) {
			return productRepository.searchProductByNameParent(product.getName(), product.getParentId());
		} else if (product.getId() == null && "".equals(product.getName()) && product.getParentId() != null && product.getImage() == null) {
			return productRepository.searchProductByParent(product.getParentId());
		} else if(product.getImage() != null && product.getParentProduct() != null) {
			return productRepository.searchProductByImageAndParent(product.getImage(), product.getParentProduct());
		} else if(product.getImage() != null && product.getParentName() != null) {
			return productRepository.searchProductByImageName(product.getImage(), product.getName());
		} else if(product.getImage() != null && product.getId() != null) {
			return productRepository.searchProductByImageAndId(product.getImage(), product.getId());
		} else if(product.getImage() != null && product.getParentProduct() == null && product.getId() == null && "".equals(product.getName())) {
			return productRepository.searchProductByImageAndId(product.getImage(), product.getId());
		} else {
			return productRepository.findAll();
		}
	}
	
	public List<Image> searchImagesByParams(Image image) {
		
		if(image.getId() != null && "".equals(image.getType())) {
			return imageRepository.searchImageByIdList(image.getId());
		} else if(image.getId() != null && !"".equals(image.getType())) {
			return imageRepository.searchImageByTypeAndId(image.getType(), image.getId());
		} else if(image.getId() == null && !"".equals(image.getType())) {
			return imageRepository.searchImageByTypeList(image.getType());
		} else {
			return imageRepository.findAll();
		}
	}

	public void deleteProduct(Long id) {
		productRepository.delete(id);
	}

	public void deleteImage(Long id) {
		imageRepository.delete(id);
	}

}
