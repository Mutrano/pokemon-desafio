package com.mutra.desafiopokemon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	private String lat;
	private String lon;
	private Double temperature;
	private List<String> conditions;

	public City() {

	}

	public City(Double temperature, List<String> conditions) {
		this.temperature = temperature;
		this.conditions = conditions;
	}

	public List<String> wetConditions() {
		List<String> wetConditions = new ArrayList<>();

		wetConditions = conditions.stream()
				.filter(x -> (x.equals("Rain") || x.equals("Drizzle") || x.equals("Thunderstorm")))
				.collect(Collectors.toList());
		return wetConditions;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public List<String> getConditions() {
		return conditions;
	}

	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}



}