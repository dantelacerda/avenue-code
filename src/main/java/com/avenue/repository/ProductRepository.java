package com.avenue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avenue.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	@Query("From product where name = ?1")
	public Product searchProductByName(String name);
	
	@Query("From product where name like %?1%")
	public List<Product> searchProductByNameList(String name);
	
	@Query("From product where name like %?1% and id = ?2")
	public List<Product> searchProductByNameId(String name, Long id);
	
	@Query("From product where name like %?1% and id = ?2 and parentProduct = ?3 ")
	public List<Product> searchProductByNameIdParent(String name, Long id, Long parentId);
	
	@Query("From product where id = ?1 and parentProduct = ?2 ")
	public List<Product> searchProductByIdParent(Long id, Long parentId);
	
	@Query("From product where name like %?1% and parentProduct = ?2 ")
	public List<Product> searchProductByNameParent(String name, Long parentId);
	
	@Query("From product where parentProduct = ?1 ")
	public List<Product> searchProductByParent(Long parentId);
	
	@Query("From product where image = ?1 ")
	public List<Product> searchProductByImage(Long image);
	
	@Query("From product where image = ?1 and  name like %?2%")
	public List<Product> searchProductByImageName(Long image, String name);
	
	@Query("From product where image = ?1 and  id = ?2")
	public List<Product> searchProductByImageAndId(Long image, Long id);
	
	@Query("From product where image = ?1 and  parentProduct = ?2")
	public List<Product> searchProductByImageAndParent(Long image, Long parent);
	
	@Query("From product where id = ?1")
	public List<Product> searchProductById(Long id);
		
}
