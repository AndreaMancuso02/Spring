package com.MyAzienda.SpringDataJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// JPA -> Jakarta Persistence è un framework per il linguaggio Java. Le classi decorate con 
//  @Entity verranno messe a disposizione di Hibernate
@Entity  
@Table(name="Studenti")
public class StudenteOLD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;
	
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="enrollmentid")
	private String enroll;
	
	private String email;
	
	public StudenteOLD() {} // costruttore di default necessario per JPA ....
	
	public StudenteOLD(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEnroll() {
		return enroll;
	}

	public void setEnroll(String enroll) {
		this.enroll = enroll;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", enroll=" + enroll + ", email="
				+ email + "]";
	}
	
	
}
