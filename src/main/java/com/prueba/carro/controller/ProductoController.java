package com.prueba.carro.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.carro.model.Producto;
import com.prueba.carro.service.IProductoService;
import com.prueba.carro.util.EnumRespuesta;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/producto")
public class ProductoController {
	
	private static final Class<ProductoController> nombreClase = ProductoController.class;
	private static final Logger logger = LoggerFactory.getLogger(nombreClase);
		
	IProductoService productoService;	
	
	public ProductoController(IProductoService productoService) {
		this.productoService = productoService;
	}
	

	@GetMapping
	public List<Producto> getAllProductos(){
		
		return productoService.getAllProductos();
		
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@Valid @RequestBody Producto producto, BindingResult result)  {
		try {				
			if(result.hasErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EnumRespuesta.RESPUESTAFAIL.getRespuestaPeticiones());
			}				
			productoService.createProducto(producto);					
			
		}catch (Exception e) {
			logger.error("Error en insert: " + nombreClase + e);
		}
		return ResponseEntity.ok(EnumRespuesta.RESPUESTAOK.getRespuestaPeticiones());
	}
	
	
	@PutMapping
	public ResponseEntity<String> update(@Valid @RequestBody Producto producto, BindingResult result) {
		try{
			if(result.hasErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EnumRespuesta.RESPUESTAFAIL.getRespuestaPeticiones());
			}
			productoService.updateProducto(producto);
		}catch (Exception e) {
			logger.error("Error metodo update "+ nombreClase);
		}
		return ResponseEntity.ok(EnumRespuesta.RESPUESTAOK.getRespuestaPeticiones());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		try {
			productoService.deleteProducto(id);
		}catch (Exception e) {
			logger.error("Error metodo delete "+ nombreClase);
		}
		return ResponseEntity.ok(EnumRespuesta.RESPUESTAOK.getRespuestaPeticiones());
	}

}
