package com.precarga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entidad.Producto;
import com.excepciones.ExcepcionServicio;
import com.servicio.ServicioImpl;

@Component
public class PrecargaBD {
	@Autowired
	private ServicioImpl servicio;

	@Transactional
	public void precargarBaseDeDatos() throws ExcepcionServicio {
		try {
			servicio.buscarXId("1");
		} catch (ExcepcionServicio ex) {
			Producto articulo1 = new Producto("1", "Cazadora cuero negra", 150, true);
			Producto articulo2 = new Producto("2", "Pantalon Vaquero", 19.99, false);
			Producto articulo3 = new Producto("3", "Jersey de rombos", 25.7, true);
			Producto articulo4 = new Producto("4", "Pantalon Chino marron", 35, true);
			Producto articulo5 = new Producto("5", "Cazadora polipiel marron", 65, false);
			servicio.crearArticulo(articulo5);
			servicio.crearArticulo(articulo4);
			servicio.crearArticulo(articulo3);
			servicio.crearArticulo(articulo2);
			servicio.crearArticulo(articulo1);
		}
	}

}
