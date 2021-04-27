package com.prueba.carro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prueba.carro.model.Producto;
import com.prueba.carro.model.VentaProducto;
import com.prueba.carro.repository.IProductoRepository;
import com.prueba.carro.repository.IVentaProductoRepository;
import com.prueba.carro.service.IVentaProductoService;

@Service
public class VentaProductoServiceImpl implements IVentaProductoService {

	private static final String DESCUENTO = "descuento";
	private static final Class<VentaProductoServiceImpl> NOMBRECLASE = VentaProductoServiceImpl.class;
	private static final Logger LOGGER = LoggerFactory.getLogger(NOMBRECLASE);
	
	private IVentaProductoRepository ventaProductorepo;
	private IProductoRepository productoRepo;
	
	public VentaProductoServiceImpl(IVentaProductoRepository ventaProductorepo, IProductoRepository productoRepo) {
		this.ventaProductorepo = ventaProductorepo;
		this.productoRepo = productoRepo;
	}

	@Override
	public void addProductoVenta(VentaProducto ventaProducto) {
		
		try {			
			double total_precio = calcularPrecioTotalProductos(ventaProducto.getId_producto(), ventaProducto.getCantidad());
			
			ventaProducto.setTotal_precio(total_precio);			
			LOGGER.info("Agreando producto: " + ventaProducto.getId_producto().getNombre() + ", a la venta: " + ventaProducto.getId_venta().getId());
			ventaProductorepo.save(ventaProducto);
			
		} catch (Exception e) {
			LOGGER.error("Error en addProductoVenta: " + NOMBRECLASE + e);
		}
		
	}

	@Override
	public List<Producto> listProductosVenta(String idVenta) {

		List<Producto> listProductos = new ArrayList<>();
		
		try {
			LOGGER.info("Listando productos de venta: " + idVenta);
			listProductos = productoRepo.findByProductosOfVenta(idVenta);
		} catch (Exception e) {
			LOGGER.error("Error en listProductosVenta: " + NOMBRECLASE + e);
		}		
		return listProductos;
	}
	

	@Override
	public List<VentaProducto> getAllVentaProductos() {

		List<VentaProducto> listVentasProductos = new ArrayList<>();
		
		try {
			listVentasProductos = ventaProductorepo.findAll();
		} catch (Exception e) {
			LOGGER.error("Error en getAllVentaProductos: " + NOMBRECLASE + e);
		}
		
		return listVentasProductos;
	}

	@Override
	public void updateProductoVenta(VentaProducto ventaProducto) {
		
		try {			
			double total_precio = calcularPrecioTotalProductos(ventaProducto.getId_producto(), ventaProducto.getCantidad());
			
			ventaProducto.setTotal_precio(total_precio);			
			LOGGER.info("Actualizando producto: " + ventaProducto.getId_producto().getNombre() + ", a la venta: " + ventaProducto.getId_venta().getId());
			ventaProductorepo.save(ventaProducto);
			
		} catch (Exception e) {
			LOGGER.error("Error en updateProductoVenta: " + NOMBRECLASE + e);
		}
		
	}

	@Override
	public void deleteProductoVenta(String idVentaProducto) {
		
		try {			
			LOGGER.info("Eliminando productos de venta: " + idVentaProducto);
			ventaProductorepo.deleteById(idVentaProducto);	
		} catch (Exception e) {
			LOGGER.error("Error en deleteProductoVenta: " + NOMBRECLASE + e);
		}
		
	}
	
	public double calcularPrecioTotalProductos(Producto producto, int cantidadProductos) {
		
		double totalPrecio = 0;
		
		if(producto.getTipo().equals(DESCUENTO)) {
			totalPrecio = (producto.getPrecio() / 2) * cantidadProductos;
		}else {
			totalPrecio = producto.getPrecio() * cantidadProductos;
		}
		
		return totalPrecio;
		
	}

	

	
	
}
