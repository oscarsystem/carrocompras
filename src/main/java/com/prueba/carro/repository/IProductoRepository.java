package com.prueba.carro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.carro.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String>{

	@Query(value = "select p.* from producto p, venta_producto vp where p.id = vp.id_producto_id "
			+ "and vp.id_venta_id = ?1", 
			nativeQuery = true)
	List<Producto> findByProductosOfVenta(String idVenta);
	
}
