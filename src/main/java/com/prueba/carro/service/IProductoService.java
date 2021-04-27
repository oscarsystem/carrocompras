package com.prueba.carro.service;

import java.util.List;

import com.prueba.carro.model.Producto;

public interface IProductoService {

	public void createProducto(Producto producto);
	public List<Producto> getAllProductos();
	public void updateProducto(Producto producto);
	public void deleteProducto(String idProducto);
	
}
