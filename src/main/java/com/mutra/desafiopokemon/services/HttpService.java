package com.mutra.desafiopokemon.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HttpService {
	private  final HttpClient httpClient = HttpClient.newBuilder()
			.version(Version.HTTP_2)
			.connectTimeout(Duration.ofSeconds(10))
			.build();
	protected JsonNode sendRequest(String uri) {
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(uri))
				.setHeader("User-Agent", "Java 11 HttpClient")
				.build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper mapper = new ObjectMapper();		
			return mapper.readTree(response.body());

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	
}
