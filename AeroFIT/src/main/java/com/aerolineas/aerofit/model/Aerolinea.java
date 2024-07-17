package com.aerolineas.aerofit.model;

import java.util.ArrayList;

public class Aerolinea {
	private String nombre;
	private ArrayList<Vuelo> vuelos;
	
	public Aerolinea(String nombre) {
		this.nombre=nombre;
		this.vuelos=new ArrayList<Vuelo>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
	
}
