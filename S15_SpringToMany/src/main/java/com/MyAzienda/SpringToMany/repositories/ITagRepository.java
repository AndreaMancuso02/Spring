package com.MyAzienda.SpringToMany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.MyAzienda.SpringToMany.entities.Tag;

public interface ITagRepository extends CrudRepository<Tag, Long>{

}
