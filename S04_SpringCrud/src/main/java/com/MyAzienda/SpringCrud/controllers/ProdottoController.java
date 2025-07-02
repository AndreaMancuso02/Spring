package com.MyAzienda.SpringCrud.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringCrud.models.Prodotto;

@RestController
@RequestMapping("api/prodotti")
public class ProdottoController {

	private List<Prodotto> prodotti = new ArrayList<>() {{
		add(new Prodotto(1, "bullone dia. 22", "BL212", 2.50f));
		add(new Prodotto(2, "vite filetto a gas", "VT3212", 4.50f));
		add(new Prodotto(3, "lavatrice a cestello", "LAV100", 270.90f));
	}};
	
	@GetMapping
	public List<Prodotto> elencoProdotti(){
		return prodotti;
	}
	@GetMapping
	public List<Prodotto> elencoProdotti2(){
		return prodotti;
	}
	
	@GetMapping("{varId}")
	public Prodotto dettaglioProdotto(@PathVariable int varId) {
		for(int i = 0; i < prodotti.size(); i++){
			if(prodotti.get(i).getId() == varId) {
				return prodotti.get(i);
			}
		}
		return null;
	}
	
	@PostMapping("inserisci")
	public Prodotto  inserisciProdotto(@RequestBody Prodotto p) {
		System.out.println(p.getId());
		System.out.println(p.toString());
		p.setId(prodotti.size() + 1);
		prodotti.add(p);
		return p;
	}
}


