package com.mutra.desafiopokemon.domain;

import java.io.Serializable;

public class Pokemon implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	private String type;
	private String imageUrl;
	
	
	public  Pokemon() {
		
	}

	public Pokemon(String name, String imageUrl) {
		this.name = name;
		this.imageUrl = imageUrl;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + ", imageUrl=" + imageUrl + "]";
	}

	
	

}