package com.mutra.desafiopokemon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mutra.desafiopokemon.services.MapService;
import com.mutra.desafiopokemon.services.PokeAPIService;
	
@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	PokeAPIService pokeApiService;
	
	@Autowired
	MapService mapService;
	
	@Override
	public void run(String... args) throws Exception {
	}
}
