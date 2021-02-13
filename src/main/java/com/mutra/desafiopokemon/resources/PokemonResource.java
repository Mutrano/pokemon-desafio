package com.mutra.desafiopokemon.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutra.desafiopokemon.services.MapService;
import com.mutra.desafiopokemon.services.PokeAPIService;

@RestController
@RequestMapping(value = "/")
public class PokemonResource {

	@Autowired
	PokeAPIService pokeAPIService;
	
	@Autowired
	MapService mapService;
	
	
}
