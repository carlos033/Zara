package com.servicio;

import java.util.List;

import com.entidad.Producto;
import com.excepciones.ExcepcionServicio;

public interface Servicio {
	public Producto buscarXId(String id) throws ExcepcionServicio;

	public List<Producto> buscarProductosSimilares(String id) throws ExcepcionServicio;

	public void crearArticulo(Producto entidad) throws ExcepcionServicio;
}
