package com.mutra.desafiopokemon.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokemon implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String imageUrl;
	private List<String> types = new ArrayList<String>();

	public  Pokemon() {
		
	}

	public Pokemon(Integer id,String name,String imageUrl) {
		this.id=id;
		this.name = name;
		this.imageUrl = imageUrl;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", types=" + types + "]";
	}
	
	

	
	

}