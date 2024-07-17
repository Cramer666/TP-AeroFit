package com.aerolineas.aerofit.DbStore;

import java.util.ArrayList;
import com.aerolineas.aerofit.model.Vuelo;

public class DbStore {
	private static ArrayList<Vuelo>vuelos;
	private static DbStore instance;
	
	public DbStore() {
		DbStore.vuelos=new ArrayList<Vuelo>();
		this.initVuelos();
	}
	
	public static synchronized DbStore getInstance() {
		if(instance==null) {
			instance=new DbStore();
		}
		return instance;
	}
	
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
	
	public void setVuelos(ArrayList<Vuelo> vuelos) {
		DbStore.vuelos = vuelos;
	}
	

	public Vuelo findByIdVuelo(Integer vueloID) {
		return DbStore.vuelos.stream()
					  .filter(v->v.getNumeroDeVuelo().equals(vueloID))
					  .findFirst() 
					  .orElse(null);
	}
	@SuppressWarnings("unused")
	private void initVuelos() {
        // vuelos de ejemplo
        Vuelo vuelo1 = new Vuelo(null,null);
        vuelo1.setNumeroDeVuelo(1024);
        vuelo1.setCapacidadDeVuelo(68);
        Vuelo vuelo2 = new Vuelo(null,null);
        vuelo2.setNumeroDeVuelo(1956);
        vuelo2.setCapacidadDeVuelo(86);
       

        vuelos.add(vuelo1);
        vuelos.add(vuelo2);
    }
	
}
