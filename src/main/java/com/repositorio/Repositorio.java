package com.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entidad.Producto;

public interface Repositorio extends JpaRepository<Producto, Integer> {
	Optional<Producto> findById(String id);

	@Query(value = "SELECT * FROM producto p WHERE p.nombre like "
			+ "(SELECT CONCAT(LEFT(nombre,5), '%') FROM producto WHERE id =:id)", nativeQuery = true)
	List<Producto> buscarProductosSimilares(@Param("id") String id);
}
