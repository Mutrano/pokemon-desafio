package com.mutra.desafiopokemon.domain;

import java.util.ArrayList;
import java.util.List;

public class City {
	private Double temperature;
	private List<String> conditions;
	
	public City(){
		
	}

	public City(Double temperature,List<String> conditions) {
		this.temperature = temperature;
		this.conditions = conditions;
	}

	public Double getTemperature() {
		return temperature;
	}

	public List<String> getConditions() {
		return conditions;
	}
	
}