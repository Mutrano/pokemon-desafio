package com.mutra.desafiopokemon.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mutra.desafiopokemon.domain.Pokemon;

@Service
public class PokeAPIService {
	@Autowired
	HttpService http;
	
	final String uri = "https://pokeapi.co/api/v2/";
	
	public Pokemon getPokemonById(String id) {
		JsonNode json = http.sendRequest(uri+"pokemon/"+id);
		JsonNode types = json.get("types");
		String name = json.get("species").get("name").asText();
		String imageUrl = json.get("sprites").get("other").get("official-artwork").get("front_default").asText();
		if(imageUrl==null) {
			imageUrl=json.get("sprites").get("front_default").asText();
		}
		Pokemon pokemon = new Pokemon(Integer.parseInt(id),name, imageUrl);
		for(int i =0 ;i<types.size();i++) {
			pokemon.getTypes().add(types.get(i).get("type").get("name").asText());
		}
//		System.out.println(json);
		return pokemon;
	}
	public String getRandomPokemonIdByType(String type) {
		//System.out.println(uri.concat("type/"+type));
		JsonNode json =  http.sendRequest(uri+"type/"+type);
		
		JsonNode pokemons = json.get("pokemon");
		List<String> pokemonIds= filterPokemons(pokemons);
		//System.out.println(pokemons);
		final int size =pokemonIds.size()-1;
		final int random = (int) (Math.random() * size) ;
		//System.out.println(random);
	//	final JsonNode randomPokemon=pokemons.get(random).get("pokemon");
		//System.out.println(randomPokemon);
	//	return randomPokemon.get("url").asText();
		return pokemonIds.get(random);
	}
	public String getPokemonTypeByTemperature(double temperature) {
		List<String> remainingTypes = Arrays.asList("normal","fighting","flying","poison","psychic","dragon","ghost","dark","steel","fairy");
		System.out.println(remainingTypes);
		
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
			int random = (int) (Math.random() * remainingTypes.size());
			System.out.println(random);
			return remainingTypes.get(random);
		}
	}
	public List<String> filterPokemons(JsonNode pokemons) {
		List<Integer> list = new ArrayList<>();
		List<String> output= new ArrayList<>();
		for(int i =0 ; i<pokemons.size();i++) {
			String entry = pokemons.get(i).get("pokemon").get("url").asText();
			String[] entries = entry.split("/");
			entry = entries[6];
			list.add(Integer.parseInt(entry));
		}
	//	System.out.println(list);
	//	System.out.println(((list.size()/3) *2) );
		int i = ((list.size()/3) *2);
		while(i<list.size() && list.get(i)<10000) {
			i++;
		}
		
		list = list.subList(0, i);
		list.forEach( x-> output.add(x.toString()));
	//	System.out.println(output);
		return output;
	}
	
}
