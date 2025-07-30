package com.MyAzienda.SpringToMany.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.MyAzienda.SpringToMany.entities.PhotoMetadata;

public interface IPhotoMetadataRepository extends CrudRepository<PhotoMetadata, Long>{
	
	/*
	 * findAll()
	 * findById(id)
	 * save(entity)
	 * deleteById(id)
	 * existById(id)
	 */
	

}
