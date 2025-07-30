package com.MyAzienda.SpringToMany.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "photo_metadatas")
public class PhotoMetadata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer width;
	
	private Integer height;
	
	private Date created;
	
	public PhotoMetadata(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	// 4° step -> Relazione @OneToOne con Photo
	@OneToOne
	@JoinColumn(name = "photo_id", referencedColumnName = "id")	
	private Photo photo;
	
	public Long getPhoto() {
		return photo.getId();
	}
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "PhotoMetadata [id=" + id + ", width=" + width + ", height=" + height + ", created=" + created
				+ ", photo=" + photo + "]";
	}
	
	

}
