package com.mutra.desafiopokemon.dto;

import java.io.Serializable;

public class CoordDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String lat;
	private String lon;
	
	public CoordDTO() {
		
	}
	

	public CoordDTO(String lat, String lon) {
		this.lat = lat;
		this.lon = lon;
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
}
