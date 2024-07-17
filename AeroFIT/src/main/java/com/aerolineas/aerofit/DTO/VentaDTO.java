package com.aerolineas.aerofit.DTO;

public class VentaDTO {
	private String nombreYApellido;
	private Integer cantidadDePasajes;
	
	public VentaDTO(String nombreYApellido,Integer cantidadDePasajes) {
		this.nombreYApellido=nombreYApellido;
		this.cantidadDePasajes=cantidadDePasajes;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombre(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public Integer getCantidadDePasajes() {
		return this.cantidadDePasajes;
	}

	public void setCantidadDePasajes(Integer cantidadDePasajes) {
		this.cantidadDePasajes = cantidadDePasajes;
	}
	
}
