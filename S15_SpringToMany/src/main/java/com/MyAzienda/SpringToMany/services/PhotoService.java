package com.MyAzienda.SpringToMany.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyAzienda.SpringToMany.entities.Photo;
import com.MyAzienda.SpringToMany.repositories.IPhotoRepository;

@Service
public class PhotoService {
	
	@Autowired
	private IPhotoRepository repo;
	
	public PhotoService() {}
	
	public Iterable<Photo> getAll() {
		return repo.findAll();
	}
	
	public Optional<Photo> getById(Long id) {
		return repo.findById(id);
	}
	
	public void addOne(Photo photo) {
		repo.save(photo);
	}
	
	public void update(Photo photo) {
		repo.save(photo);
	}
	
	public void delete(Long id) {
		Optional<Photo> foundPhoto = repo.findById(id);
		Long idUser = foundPhoto.get().getUser().getId();
		System.out.println("iduser = " + idUser + " della foto con id = " + id );
		repo.delete(foundPhoto.get());
	}
	
    public boolean alreadyExist(Photo photo) {
        for (Photo p : getAll()) {
            if (p.getUrl().equals(photo.getUrl())) {
                return true;
            }
        }
        return false;
    }

}