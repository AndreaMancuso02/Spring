package com.MyAzienda.SpringToMany.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.MyAzienda.SpringToMany.entities.Photo;
import com.MyAzienda.SpringToMany.entities.User;
import com.MyAzienda.SpringToMany.services.UserService;

@RestController
@RequestMapping("s15/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public Iterable<User> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public User getById(@PathVariable Long id) {
		Optional<User> user = service.getById(id);
		
		if (user.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User id = " + id + " not found");
		}
		return user.get();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return service.create(user);
	}
	
    @PostMapping("/update")
    public void update(@RequestBody User user) {
	    if(service.getById(user.getId()) == null) {
	    	throw new ResponseStatusException(HttpStatus.FOUND, "user NOT found");
	    }
	    service.update(user);
	}
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
    	if(service.getById(id) == null) {
	    	throw new ResponseStatusException(HttpStatus.FOUND, "user NOT found");
	    }
    	service.delete(id);
    }
	

}
