package com.aerolineas.aerofit.RestController;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolineas.aerofit.DTO.VentaDTO;
import com.aerolineas.aerofit.model.Vuelo;
import com.aerolineas.aerofit.service.VueloService;


@RestController
@RequestMapping ("/venta_pasaje")
public class VueloController {

    private VueloService vueloService;
    
    public VueloController() {
        this.vueloService = VueloService.getInstance();
    }
    /*
	    Método http: PUT (actualiza datos), cuerpo en formato JSON con los siguientes
	    datos: número de vuelo, nombre y apellido de la persona que realizo la compra y
	    la cantidad de pasajes adquiridos. La respuesta a este endpoint debe ser un texto
	    con el resultado de la operación, existosa o sin cupos
    */
    

    @PutMapping("/realizarVenta /{numeroDeVuelo}/ventaDTO")
    public String realizarVenta(@PathVariable Integer numeroDeVuelo, @RequestBody VentaDTO ventaDTO) {
    	return this.vueloService.realizarVenta(numeroDeVuelo, ventaDTO.getNombreYApellido(),ventaDTO.getCantidadDePasajes());
    }
    /*
      Realizar un endpoint que retorne toda la información para un número de vuelo
	  dado. Método GET (consulta datos)
     */
   @GetMapping("/informacionDeVuelo/{numeroDeVuelo}")
   public Vuelo informacionDeVuelo(@PathVariable Integer numeroDeVuelo) {
	   return this.vueloService.getVueloByNumero(numeroDeVuelo);
	  
   }
}
