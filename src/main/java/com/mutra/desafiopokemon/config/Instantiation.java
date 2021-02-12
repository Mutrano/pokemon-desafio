package com.mutra.desafiopokemon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mutra.desafiopokemon.domain.Pokemon;
import com.mutra.desafiopokemon.services.PokeAPIService;
	
@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	PokeAPIService pokeApiService;
	
	@Override
	public void run(String... args) throws Exception {
		String randomPokemonUrl = pokeApiService.getRandomPokemonByType("electric");
		System.out.println(randomPokemonUrl);
		Pokemon pokemon = pokeApiService.findByUrl(randomPokemonUrl);
		pokemon.setType("electric");
		System.out.println(pokemon);
		
	}

}
