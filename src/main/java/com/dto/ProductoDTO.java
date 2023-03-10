package com.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Producto", description = "Detalles de los productos")
public class ProductoDTO implements Serializable {

	private static final long serialVersionUID = 2L;
	private String id;
	private String nombre;
	private double precio;
	private boolean disponibilidad;

}
