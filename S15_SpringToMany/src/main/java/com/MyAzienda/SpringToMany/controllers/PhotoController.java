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
import com.MyAzienda.SpringToMany.services.PhotoService;

@RestController
@RequestMapping("s15/photos")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private String currentDateTimeFormatted;
	
	
//	public PhotoController(PhotoService photoService) {
//		this.photoService = photoService;
//	}
	
	@GetMapping
	public Iterable<Photo> getAll() {
		System.out.println("La data-ora corrente è: " + currentDateTimeFormatted);
		return photoService.getAll();
	}
	
	@GetMapping("/{id}")
	public Photo getById(@PathVariable Long id) {
		Optional<Photo> photo = photoService.getById(id);
		
		if (photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo id = " + id + " not found");
		}
		return photo.get();
	}
	
    @PostMapping("/add")
    public void addOne(@RequestBody Photo photo) {
	    if(photoService.alreadyExist(photo)) {
	    	throw new ResponseStatusException(HttpStatus.FOUND, "photo found");
	    }
        photoService.addOne(photo);
	}
    
    @PostMapping("/update")
    public void update(@RequestBody Photo photo) {
	    if(photoService.getById(photo.getId()) == null) {
	    	throw new ResponseStatusException(HttpStatus.FOUND, "photo NOT found");
	    }
        photoService.update(photo);
	}
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
    	if(photoService.getById(id) == null) {
	    	throw new ResponseStatusException(HttpStatus.FOUND, "photo NOT found");
	    }
        photoService.delete(id);
    }


}
