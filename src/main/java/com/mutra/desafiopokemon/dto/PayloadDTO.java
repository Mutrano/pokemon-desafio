package com.mutra.desafiopokemon.dto;

import java.io.Serializable;

import com.mutra.desafiopokemon.domain.City;
import com.mutra.desafiopokemon.domain.Pokemon;

public class PayloadDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Pokemon pokemon;
	private City city;
	
	public PayloadDTO() {
		
	}

	public PayloadDTO(Pokemon pokemon, City city) {
		this.pokemon = pokemon;
		this.city = city;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	
}
