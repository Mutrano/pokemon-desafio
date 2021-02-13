package com.mutra.desafiopokemon.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutra.desafiopokemon.domain.City;
import com.mutra.desafiopokemon.domain.Pokemon;
import com.mutra.desafiopokemon.dto.CoordDTO;
import com.mutra.desafiopokemon.dto.PayloadDTO;
import com.mutra.desafiopokemon.services.MapService;
import com.mutra.desafiopokemon.services.PokeAPIService;
import com.mutra.desafiopokemon.services.PokemonService;

@RestController
@RequestMapping(value = "/")
public class PokemonResource {

	@Autowired
	PokeAPIService pokeAPIService;
	
	@Autowired
	MapService mapService;
	
	@Autowired
	PokemonService pokemonService;
	
	@GetMapping
	public ResponseEntity<PayloadDTO> getPokemonByGeoCoordinates(@RequestBody CoordDTO coord){
		City city = mapService.getCityByGeoCoord(coord.getLat(),coord.getLon());
		Pokemon pokemon = pokemonService.getPokemonByGeoCoordinates(city);
		PayloadDTO payload = new PayloadDTO(pokemon,city);
		
		return ResponseEntity.ok().body(payload);
	}
	
}
