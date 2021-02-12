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
		System.out.println(json);
		return new Pokemon(json.get("name").asText(),json.get("sprites").get("front_default").asText());
	}
	public String getRandomPokemonByType(String type) {
		System.out.println(uri.concat("type/"+type));
		JsonNode json =  http.sendRequest(uri.concat("type/"+type));

		JsonNode pokemons = json.get("pokemon");
		System.out.println(pokemons);
		final int size =pokemons.size()-1;
		final int random = (int) (Math.random() * size) ;
		System.out.println(random);
		final JsonNode randomPokemon=pokemons.get(random).get("pokemon");
		System.out.println(randomPokemon);
		return randomPokemon.get("url").asText();
	}
}
