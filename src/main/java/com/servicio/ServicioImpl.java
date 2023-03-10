package com.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entidad.Producto;
import com.excepciones.ExcepcionServicio;
import com.repositorio.Repositorio;

@Service
public class ServicioImpl implements Servicio {
	@Autowired
	private Repositorio repositorio;

	@Override
	public void crearArticulo(Producto entidad) throws ExcepcionServicio {
		repositorio.save(entidad);

	}

	@Override
	public Producto buscarXId(String id) throws ExcepcionServicio {
		Producto proveedor = repositorio.findById(id).orElse(null);
		if (proveedor == null) {
			throw new ExcepcionServicio("No existen articulos con ese Id");
		}
		return proveedor;
	}

	@Override
	public List<Producto> buscarProductosSimilares(String id) throws ExcepcionServicio {
		List<Producto> listaProductos = repositorio.buscarProductosSimilares(id);
		if (listaProductos.size() == 0) {
			throw new ExcepcionServicio("No existen articulos con ese Id");
		}
		return listaProductos;
	}

}
