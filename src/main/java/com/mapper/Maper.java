package com.mapper;

import org.mapstruct.Mapper;

import com.dto.ProductoDTO;
import com.entidad.Producto;

@Mapper(componentModel = "spring")
public interface Maper {
	ProductoDTO mapeoADTO(Producto entidad);
}
