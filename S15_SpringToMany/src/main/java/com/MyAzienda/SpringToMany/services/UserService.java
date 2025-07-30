package com.MyAzienda.SpringToMany.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyAzienda.SpringToMany.entities.User;
import com.MyAzienda.SpringToMany.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository repo;
	
	public UserService() {}
	
	public Iterable<User> getAll() {
		return repo.findAll();
	}
	
	public Optional<User> getById(Long id) {
		return repo.findById(id);
	}
	
	public User create(User user) {
		return repo.save(user);
	}
	
	public void update(User user) {
		repo.save(user);
	}
	
	public boolean delete(Long id) {
		Optional<User> foundUser = repo.findById(id);
		if (foundUser.isEmpty()) {
			return false;
		}
		repo.delete(foundUser.get());
		return true;
	}

}
