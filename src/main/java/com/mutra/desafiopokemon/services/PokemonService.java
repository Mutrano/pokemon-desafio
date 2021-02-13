package com.mutra.desafiopokemon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutra.desafiopokemon.domain.City;
import com.mutra.desafiopokemon.domain.Pokemon;

@Service
public class PokemonService {
	@Autowired
	PokeAPIService pokeAPIService;
	
	@Autowired
	MapService mapService;
	
	public Pokemon getPokemonByGeoCoordinates(City city) {
		List<String> wetConditions = new ArrayList<>();
		wetConditions = city.wetConditions();
		String type;
		//if its raining|Drizzle|Thunderstorm ( wetConditions.size()>0) the pokemon type must be electric
		if(wetConditions.size()==0) {
			type =pokeAPIService.getPokemonTypeByTemperature(city.getTemperature());

		}
		else {
			type = "electric";
		}
		
		Pokemon pokemon = getPokemon(type);
		while(pokemon.getImageUrl().equals("null")) {
			pokemon = getPokemon(type);
		}
		return pokemon;
		
	}
	private Pokemon getPokemon(String type) {
		String pokemonUrl = pokeAPIService.getRandomPokemonByType(type);
		Pokemon pokemon = pokeAPIService.findByUrl(pokemonUrl);
		return pokemon;
	}
}
