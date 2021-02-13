package com.mutra.desafiopokemon.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mutra.desafiopokemon.domain.City;
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
		City city =mapService.getCityByGeoCoord("29.1738672", "-82.2268486");
		List<String> wetConditions = city.getConditions().stream().
				filter( x-> (x.equals("Rain") || x.equals("Drizzle")|| x.equals("Thunderstorm"))).collect(Collectors.toList());
		System.out.println(wetConditions);
		
		System.out.println(city.getConditions());
		System.out.println(city.getTemperature());
	}
}
