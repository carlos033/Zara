package com.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Schema(name = "id", description = "Id de la prenda", example = "1")
	@Size(min = 1)
	private String id;
	@NotBlank
	@Schema(name = "nombre", description = "Nombre del articulo", example = "Chaqueta de cuero negra")
	@Size(min = 1)
	private String nombre;
	@NotNull
	@Schema(name = "precio", description = "Precio del articulo", example = "150.99")
	private double precio;
	@NotNull
	@Schema(name = "disponibilidad", description = "disponibilidad de la prenda", example = "true")
	private boolean disponibilidad;
}
