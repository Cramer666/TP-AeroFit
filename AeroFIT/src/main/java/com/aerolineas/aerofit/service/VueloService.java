package com.aerolineas.aerofit.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.aerolineas.aerofit.model.Venta;
import com.aerolineas.aerofit.model.Vuelo;
import com.aerolineas.aerofit.DTO.VentaDTO;
import com.aerolineas.aerofit.DbStore.DbStore;

@Service
public class VueloService {
	public Integer ventaId=0;
	private DbStore dbStore;
	private static VueloService instance;
	
	public VueloService() {
		this.dbStore=DbStore.getInstance();
	}
	public Vuelo getVuelo(Integer numeroDeVuelo) {
       return dbStore.findByIdVuelo(numeroDeVuelo);
	}
	public static VueloService getInstance() {
		if(instance==null) {
			instance=new VueloService();
		}
		return instance;
	}
	
    @SuppressWarnings("static-access")
	public ArrayList<Vuelo> getAllVuelos() {
        return dbStore.getVuelos();
    }

    public Vuelo getVueloByNumero(Integer numeroDeVuelo) {
        return dbStore.findByIdVuelo(numeroDeVuelo);
    }

    public void addVenta(Integer numeroDeVuelo, VentaDTO ventaDTO) {
    	String txt="No se pudo realizar la compra.";
    	if(this.sePuedeVender(numeroDeVuelo,ventaDTO)) {
    		Venta venta = realizarVenta(ventaDTO);
    		this.getVueloByNumero(numeroDeVuelo).setVentas(venta);
    		System.out.println("Se realizo la compra con exito.");
    	}
    	System.out.println(txt);
    }
    
    public Boolean sePuedeVender(Integer numeroDeVuelo,VentaDTO ventaDTO) {
    	Boolean hayVuelo=!(this.getVueloByNumero(numeroDeVuelo)==null);
    	return hayVuelo&&(this.getVueloByNumero(numeroDeVuelo).getCapacidadDeVuelo()-ventaDTO.getCantidadDePasajes())>0;
    	
    }
    public synchronized String realizarVenta(Integer numeroDeVuelo, String nombreApellido, int pasajes) {
        Vuelo vuelo = this.getVuelo(numeroDeVuelo);
        
        if (vuelo == null) {
        	System.out.println("Vuelo no encontrado.");
        	return "Vuelo no encontrado.";
        }
        int capacidadDisponible = vuelo.getCapacidadDeVuelo() - vuelo.getVentas().stream().mapToInt(venta->venta.getCantidadDePasajes()).sum();
        if (pasajes > capacidadDisponible) {
        	System.out.println("No hay suficientes cupos disponibles.");
            return "No hay suficientes cupos disponibles.";
        }else {
        	System.out.println("Venta completada.");
        	return "Venta completada.";
        }
        
    }
    private Venta realizarVenta(VentaDTO ventaDTO) {
    	Venta v = new Venta(null,null,null);
        v.setNombreYApellido(ventaDTO.getNombreYApellido());
        v.setCantidadDePasajes(ventaDTO.getCantidadDePasajes());
        v.setventaId(this.darId());
        return v;
    }
  
    public Integer darId() {
    	ventaId+=1;
		return this.ventaId;
	}
    
}
