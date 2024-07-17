package com.aerolineas.aerofit.DTO;

import java.time.LocalDate;


public class VueloDTO {
	private Integer numeroDeVuelo;

	
	private LocalDate fecha;
	
	public VueloDTO(Integer numeroDeVuelo,LocalDate fecha) {

		this.numeroDeVuelo=numeroDeVuelo;
		this.fecha=fecha;

	}
	
	
	public Integer getNumeroDeVuelo() {
		return numeroDeVuelo;
	}
	public void setNumeroDeVuelo(Integer numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
