package com.avenue.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avenue.model.Image;
import com.avenue.model.Product;
import com.avenue.service.AvenueService;

@Controller
public class AvenueController {

	private static final String PRODUCT = "product";
	private static final String PRODUCTS = "products";
	private static final String PARENTS = "parents";
	private static final String IMAGES = "images";
	private static final String IMAGE = "image";
	@Autowired
	private AvenueService service;

	
	@GetMapping("/")
	public ModelAndView home() {

		return new ModelAndView("/home");
	}
	
	@GetMapping("/products")
	public ModelAndView findAllProducts() {

		ModelAndView mv = new ModelAndView("/products");
		List<Product> products = findProductsAndPutParentImage();
		mv.addObject(PRODUCTS, products);
		mv.addObject(PARENTS, products);
		mv.addObject(IMAGES, service.findAllImages());
		mv.addObject(PRODUCT, new Product());

		return mv;
	}

	@GetMapping("/images")
	public ModelAndView findAllImages() {

		ModelAndView mv = new ModelAndView("/images");
		List<Image> images = service.findAllImages();

		for (Image image : images) {

			if (!service.searchProductByImage(image.getId()).isEmpty()) {
				image.setAssociated(true);
			}
		}
		mv.addObject(IMAGES, images);
		mv.addObject(IMAGE, new Image());

		return mv;
	}

	@GetMapping("/addProduct")
	public ModelAndView addProduct(Product product) {

		ModelAndView mv = new ModelAndView("/manageProduct");
		mv.addObject(PRODUCT, product);
		mv.addObject(IMAGES, service.findAllImages());
		mv.addObject(PRODUCTS, findProductsAndPutParentImage());

		return mv;
	}

	@GetMapping("/addImage")
	public ModelAndView addImage(Image image) {

		ModelAndView mv = new ModelAndView("/manageImage");
		mv.addObject(IMAGE, image);

		return mv;
	}

	@GetMapping("/editProduct/{id}")
	public ModelAndView editProduct(@PathVariable("id") Long id) {

		Product product = service.findOneProduct(id);

		if (product.getParentProduct() != null) {
			product.setParentName(service.findOneProduct(product.getParentProduct()).getName());
		}
		if (product.getImage() != null) {
			product.setImageName(service.findOneImage(product.getImage()).getType());
		}
		return addProduct(service.findOneProduct(id));
	}

	@GetMapping("/editImage/{id}")
	public ModelAndView editImage(@PathVariable("id") Long id) {

		return addImage(service.findOneImage(id));
	}

	@GetMapping("/deleteProduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") Long id) {

		service.deleteProduct(id);

		return findAllProducts();
	}

	@GetMapping("/deleteImage/{id}")
	public ModelAndView deleteImage(@PathVariable("id") Long id) {

		service.deleteImage(id);

		return findAllImages();
	}

	@PostMapping("/saveProduct")
	public ModelAndView saveProduct(@Valid Product product, BindingResult result) {

		validateProduct(result, product);

		if (result.hasErrors()) {
			return addProduct(product);
		}

		if (product.getParentId() != null) {
			product.setParentProduct(product.getParentId());
		}

		if (product.getImageId() != null) {
			product.setImage(product.getImageId());
		}

		service.saveProduct(product);

		return findAllProducts();
	}

	@PostMapping("/searchProduct")
	public ModelAndView searchProduct(Product product, BindingResult result) {

		ModelAndView mv = new ModelAndView("/products");
		mv.addObject(PRODUCTS, service.searchProductsByParams(product));
		mv.addObject(PRODUCT, new Product());
		mv.addObject(PARENTS, findProductsAndPutParentImage());
		mv.addObject(IMAGES, service.findAllImages());

		return mv;
	}

	@PostMapping("/searchImage")
	public ModelAndView searchImage(Image image, BindingResult result) {

		ModelAndView mv = new ModelAndView("/images");
		mv.addObject(IMAGES, service.searchImagesByParams(image));
		mv.addObject(IMAGE, new Image());

		return mv;
	}

	@PostMapping("/saveImage")
	public ModelAndView saveImage(@Valid Image image, BindingResult result) {

		if (result.hasErrors()) {
			return addImage(image);
		}

		service.saveImage(image);

		return findAllImages();
	}

	public void validateProduct(BindingResult result, Product product) {

		Product baseProduct = service.searchProductByName(product.getName());

		if (product.getParentId() != null && baseProduct != null && baseProduct.getId() == product.getParentId()) {
			result.addError(new ObjectError("sameAsParent", "A Product can´t be itself parent."));
		}

	}

	public List<Product> findProductsAndPutParentImage() {

		List<Product> products = service.findAllProducts();

		for (Product product : products) {

			if (product.getParentProduct() != null) {
				product.setParentName(service.findOneProduct(product.getParentProduct()).getName());
			}

			if (product.getImage() != null) {
				product.setImageName(service.findOneImage(product.getImage()).getType());
			}
		}

		return products;
	}

}
