package com.prueba.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.carro.model.VentaProducto;

public interface IVentaProductoRepository extends JpaRepository<VentaProducto, String> {
	

}
