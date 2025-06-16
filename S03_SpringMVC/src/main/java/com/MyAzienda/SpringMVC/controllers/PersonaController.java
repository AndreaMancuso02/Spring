package com.MyAzienda.SpringMVC.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringMVC.models.Persona;

@RestController
@RequestMapping("/api/persone")
public class PersonaController {

	// Crud -> Read = GET
	@GetMapping("anagrafica")
	public Persona retPersona() {
		Persona p = new Persona("Mario", "Rossi", 34);
		return p;
	}
	
	@GetMapping("elenco")
	public List<Persona> elencoPersone(){
		List<Persona> elenco = new ArrayList<Persona>();
		elenco.add(new Persona("Mario", "Rossi", 23));
		elenco.add(new Persona("Pino", "Bianchi", 34));
		elenco.add(new Persona("Francesco", "Verdi", 19));
		return elenco;
	}
	
	// http://localhost:8080/api/persone/nuova?nome=Mario&cognome=Rossi&eta=23
	@GetMapping("nuova")
	public Persona nuovaPersona(
			@RequestParam(name="nome") String varNome,
			@RequestParam(name="cognome") String varCognome,
			@RequestParam(name="eta") int varEta) {
		return new Persona(varNome, varCognome, varEta);
	}
	
	// Crud -> Create = POST
	@PostMapping("inserisci")
	public Persona inserisciPersona(@RequestBody Persona p) {
		return p;
	}
	
}
