package com.MyAzienda.HelloSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	@GetMapping("saluta")
	public String salutaTutti() {
		System.out.println("Ciao sul syso");
		return "Ciao da Spring";
	}

	@GetMapping("DammiPigreco")
	public float treE14() {
		return 3.14f;
	}
	
	@GetMapping("saluta/{varNome}/{varCognome}")
	public String salutaNomeCognome(@PathVariable String varNome, @PathVariable String varCognome) {
		return "Ciao, " + varNome + " " + varCognome;
	}
	
	// http://localhost:8080/hello/param?nome=mario&cognome=Rossi&eta=22
	@GetMapping("param")
	public String salutaParam(
			@RequestParam(name="nome") String varNome,
			@RequestParam(name="cognome") String varCognome,
			@RequestParam(name="eta") int varEta
			) {
		return "Ciao, " + varNome + " " + varCognome + " anni = " + varEta;
	}
	
	
	
}
