package com.prueba.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.carro.model.Venta;

public interface IVentaRepository extends JpaRepository<Venta, String>{

	@Query(value = "select sum(vp.total_precio) from venta_producto vp \r\n"
			+ "where vp.id_venta_id = ?1", 
			nativeQuery = true)
	double sumTotalVenta(String idVenta);
	
}
