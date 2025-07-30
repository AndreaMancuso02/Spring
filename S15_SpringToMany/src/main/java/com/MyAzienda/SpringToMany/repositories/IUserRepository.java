package com.MyAzienda.SpringToMany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.MyAzienda.SpringToMany.entities.User;

public interface IUserRepository extends CrudRepository<User, Long>{

}
