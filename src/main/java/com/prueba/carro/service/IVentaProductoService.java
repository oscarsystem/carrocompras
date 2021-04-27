package com.prueba.carro.service;

import java.util.List;

import com.prueba.carro.model.Producto;
import com.prueba.carro.model.VentaProducto;

public interface IVentaProductoService {

	public void addProductoVenta(VentaProducto ventaProducto);
	public List<Producto> listProductosVenta(String idVenta);
	public void updateProductoVenta(VentaProducto ventaProducto);
	public void deleteProductoVenta(String idVentaProducto);
	public List<VentaProducto> getAllVentaProductos();
	
}
