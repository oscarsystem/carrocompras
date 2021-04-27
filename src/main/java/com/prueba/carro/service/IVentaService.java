package com.prueba.carro.service;

import java.util.List;

import com.prueba.carro.model.Venta;

public interface IVentaService {

	public void createVenta();
	public List<Venta> getAllVentas();
	public String checkoutVenta(Venta venta);
	
}
