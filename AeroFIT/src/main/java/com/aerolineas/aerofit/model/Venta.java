package com.aerolineas.aerofit.model;

public class Venta {
	private String nombreYApellido;
	private Integer ventaId;
	private Integer cantidadDePasajes;
	
	public Venta(String nombreYApellido,Integer ventaId,Integer cantidadDePasajes) {
		this.nombreYApellido=nombreYApellido;
		this.cantidadDePasajes=cantidadDePasajes;
		this.ventaId=ventaId;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public Integer getventaId() {
		return ventaId;
	}

	public void setventaId(Integer ventaId) {
		this.ventaId = ventaId;
	}

	public Integer getCantidadDePasajes() {
		return cantidadDePasajes;
	}

	public void setCantidadDePasajes(Integer cantidadDePasajes) {
		this.cantidadDePasajes = cantidadDePasajes;
	}
	
}
