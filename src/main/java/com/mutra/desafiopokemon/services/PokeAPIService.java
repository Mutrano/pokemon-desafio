package com.mutra.desafiopokemon.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mutra.desafiopokemon.domain.Pokemon;

@Service
public class PokeAPIService {
	@Autowired
	HttpService http;
	
	final String uri = "https://pokeapi.co/api/v2/";
	
	public Pokemon findByUrl(String url) {
		JsonNode json = http.sendRequest(url);
		JsonNode types = json.get("types");
		Pokemon pokemon = new Pokemon(json.get("name").asText(),json.get("sprites").get("front_default").asText());
		for(int i =0 ;i<types.size();i++) {
			pokemon.getTypes().add(types.get(i).get("type").get("name").asText());
		}
//		System.out.println(json);
		return pokemon;
	}
	public String getRandomPokemonByType(String type) {
		//System.out.println(uri.concat("type/"+type));
		JsonNode json =  http.sendRequest(uri.concat("type/"+type));

		JsonNode pokemons = json.get("pokemon");
		//System.out.println(pokemons);
		final int size =pokemons.size()-1;
		final int random = (int) (Math.random() * size) ;
		//System.out.println(random);
		final JsonNode randomPokemon=pokemons.get(random).get("pokemon");
		//System.out.println(randomPokemon);
		return randomPokemon.get("url").asText();
	}
	public String getPokemonTypeByTemperature(double temperature) {
		if(temperature<5) {
			return "ice";
		}
		else if(temperature>=5 && temperature<10) {
			return "water";
		}
		else if(temperature>=12 && temperature<15) {
			return "grass";
		}
		else if(temperature>=15 && temperature<21) {
			return "ground";
		}
		else if(temperature>=23 && temperature<27) {
			return "bug";
		}
		else if(temperature>=27 && temperature<33) {
			return "rock";
		}
		else if(temperature>33) {
			return "fire";
		}
		else {
			return "normal";
		}
	}
}
