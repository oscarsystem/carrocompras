package com.prueba.carro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prueba.carro.model.Producto;
import com.prueba.carro.repository.IProductoRepository;
import com.prueba.carro.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	private static final Class<ProductoServiceImpl> NOMBRECLASE = ProductoServiceImpl.class;
	private static final Logger LOGGER = LoggerFactory.getLogger(NOMBRECLASE);
	
	private IProductoRepository productoRepo;
	
	public ProductoServiceImpl(IProductoRepository productoRepo) {
		this.productoRepo = productoRepo;
	}

	@Override
	public void createProducto(Producto producto) {
				
		try {			
			LOGGER.info("Creando producto: " + producto.getNombre());
			productoRepo.save(producto);
		}catch(Exception e){
			LOGGER.error(NOMBRECLASE + "Error metodo createProducto: " + e);
		}
		
	}

	@Override
	public List<Producto> getAllProductos() {

		List<Producto> listProductos = new ArrayList<>();
		
		try {
			LOGGER.info("Listando productos: ");
			listProductos = productoRepo.findAll();
		}catch (Exception e) {
			LOGGER.error(NOMBRECLASE + "Error metodo getAllProductos: " + e);
		}	
		
		return listProductos;
		
	}

	@Override
	public void updateProducto(Producto producto) {

		try {
			LOGGER.info("Actualizando producto: " + producto.getNombre());
			productoRepo.save(producto);
		}catch (Exception e) {
			LOGGER.error(NOMBRECLASE + "Error metodo updateProducto: " + e);
		}
		
	}

	@Override
	public void deleteProducto(String idProducto) {

		try {
			LOGGER.info("Eliminando producto: " + idProducto);
			productoRepo.deleteById(idProducto);
		}catch (Exception e) {
			LOGGER.error(NOMBRECLASE + "Error metodo deleteProducto: " + e);
		}
		
	}

}
