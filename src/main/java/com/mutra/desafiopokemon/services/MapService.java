package com.mutra.desafiopokemon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mutra.desafiopokemon.domain.City;

@Service
public class MapService {
	@Value("${OpenWeatherAPIKey}")
	private String API_KEY;

	@Autowired
	HttpService http;

	public City getCityByGeoCoord(String lat, String lon) {
		// api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
		String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&units=metric"
				+ "&appid=" + API_KEY;
		JsonNode json = http.sendRequest(url);
//		System.out.println(json.get("weather"));
		List<String> conditions = new ArrayList<>();
		int size = json.get("weather").size();
		for(int i =0;i<size;i++) {
			conditions.add(json.get("weather").get(i).get("main").asText());
		}
//		System.out.println(size);
		Double temperature = json.get("main").get("temp").asDouble();
		City city = new City(temperature, conditions);
		city.setLat(lat);
		city.setLon(lon);
		return city;
	}
}
