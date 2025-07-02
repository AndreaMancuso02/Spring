package com.MyAzienda.SpringJDBC.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.MyAzienda.SpringJDBC.models.Studente;

@Repository
public class StudenteRepository implements IRepositoryRead<Studente>, IRepositoryWrite<Studente> {

	@Override
	public List<Studente> getAll() {
		List<Studente> elenco = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "select studenteId, nome, cognome, matricola, dataNascita from studente";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Studente s = new Studente();
				s.setId(rs.getInt("studenteId"));
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				s.setMatricola(rs.getString("matricola"));
				s.setDataNascita(rs.getDate("dataNascita"));
				
				elenco.add(s);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return elenco;
	}

	@Override
	public Studente getById(int id) {
		
		Studente studente = null;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "select studenteId, nome, cognome, matricola, dataNascita from studente where studenteId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				studente = new Studente();
				studente.setId(rs.getInt("studenteId"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setMatricola(rs.getString("matricola"));
				studente.setDataNascita(rs.getDate("dataNascita"));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return studente;
	}
	
	@Override
	public boolean create(Studente obj) {
		
		return false;
	}

	@Override
	public boolean update(Studente obj) {
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		
		return false;
	}

}
