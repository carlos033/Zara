package com.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.dto.ProductoDTO;
import com.entidad.Producto;
import com.excepciones.ExcepcionServicio;
import com.mapper.Maper;
import com.servicio.Servicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
public class Controlador {
	@Autowired
	private Servicio servicio;
	@Autowired
	private Maper mapper;

	@Operation(description = "Obtener todos los proveedores por id de cliente")
	@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Producto.class)))
	@ApiResponse(responseCode = "404", description = "No encontrado")
	@GetMapping("/product/{productId}'")
	@ResponseBody
	public ResponseEntity<ProductoDTO> buscarXId(
			@PathVariable("productId") @Parameter(description = "  Id del arituclo") String productId) {
		try {
			return new ResponseEntity<ProductoDTO>(mapper.mapeoADTO(servicio.buscarXId(productId)), HttpStatus.OK);

		} catch (ExcepcionServicio e) {
			if (e.getMessage().contains("Ha ocurrido una")) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
			}
		}
	}

	@Operation(description = "Obtener todos los proveedores por id de cliente")
	@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = Producto.class)))
	@ApiResponse(responseCode = "404", description = "No encontrado")
	@GetMapping("/product/{productId}/similar")
	@ResponseBody
	public ResponseEntity<List<ProductoDTO>> buscarXIdSimilares(
			@PathVariable("productId") @Parameter(description = "  Id del arituclo") String productId) {
		try {
			return new ResponseEntity<List<ProductoDTO>>(servicio.buscarProductosSimilares(productId).stream()
					.map(mapper::mapeoADTO).collect(Collectors.toList()), HttpStatus.OK);
		} catch (ExcepcionServicio e) {
			if (e.getMessage().contains("Ha ocurrido una")) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
			}
		}
	}
}
