package com.avenue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avenue.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	
	@Query("From image where type = ?1")
	public Image searchImageByType(String type);
	
	@Query("From image where type like %?1%")
	public List<Image> searchImageByTypeList(String type);
	
	@Query("From image where id = ?1")
	public List<Image> searchImageByIdList(Long id);
	
	@Query("From image where type like %?1% and id = ?2")
	public List<Image> searchImageByTypeAndId(String type, Long id);
		
}
