package com.prueba.carro.controller;

import java.util.ArrayList;
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
import com.prueba.carro.model.VentaProducto;
import com.prueba.carro.service.IVentaProductoService;
import com.prueba.carro.util.EnumRespuesta;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ventaproducto")
public class VentaProductoController {

	private static final Class<VentaProductoController> NOMBRECLASE = VentaProductoController.class;
	private static final Logger LOGGER = LoggerFactory.getLogger(NOMBRECLASE);
	
	private IVentaProductoService ventaProductoService;
		
	public VentaProductoController(IVentaProductoService ventaProductoService) {
		this.ventaProductoService = ventaProductoService;
	}


	@GetMapping
	@RequestMapping("/getAllVentasProductos")
	public List<VentaProducto> getAllVentaProductos(){
		
		List<VentaProducto> listVentasProductos = new ArrayList<>();
		
		try {				
			listVentasProductos =  ventaProductoService.getAllVentaProductos();
		}catch(Exception e) {
			LOGGER.error("Error en getAllVentaProductos: " + NOMBRECLASE + e);
		}		
		
		return listVentasProductos;
		
	}
	
	
	@GetMapping
	@RequestMapping("/getByVentaProducto/{idVenta}")
	public List<Producto> getVentaProductos(@PathVariable String idVenta){
		
		List<Producto> listProductos = new ArrayList<>();
		
		try {				
			listProductos = ventaProductoService.listProductosVenta(idVenta);
		}catch(Exception e) {
			LOGGER.error("Error en getVentaProductos: " + NOMBRECLASE + e);
		}		
		
		return listProductos;
		
	}
	
	@PostMapping
	@RequestMapping("/addProducto")
	public ResponseEntity<String> insert(@Valid @RequestBody VentaProducto ventaProducto, BindingResult result) {
		
		if(result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EnumRespuesta.RESPUESTAFAIL.getRespuestaPeticiones());
		}	
		
		try {			
			LOGGER.info("Ingresando POST insert VentaProducto ");
			ventaProductoService.addProductoVenta(ventaProducto);
		}catch(Exception e) {
			LOGGER.error("Error en insert: " + NOMBRECLASE + e);
		}
		return ResponseEntity.ok(EnumRespuesta.RESPUESTAOK.getRespuestaPeticiones());
	}
	
	@PutMapping
	@RequestMapping("/updateProducto")
	public ResponseEntity<String> update(@Valid @RequestBody VentaProducto ventaProducto, BindingResult result) {
		try{
			if(result.hasErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EnumRespuesta.RESPUESTAFAIL.getRespuestaPeticiones());
			}	
			ventaProductoService.updateProductoVenta(ventaProducto);
		}catch (Exception e) {
			LOGGER.error("Error metodo update "+ NOMBRECLASE);
		}
		return ResponseEntity.ok(EnumRespuesta.RESPUESTAOK.getRespuestaPeticiones());
	}
	
	@DeleteMapping
	@RequestMapping("/deleteProducto/{idVentaProducto}")
	public ResponseEntity<String> delete(@PathVariable String idVentaProducto) {
		try {
			ventaProductoService.deleteProductoVenta(idVentaProducto);
		}catch (Exception e) {
			LOGGER.error("Error metodo delete "+ NOMBRECLASE);
		}
		return ResponseEntity.ok(EnumRespuesta.RESPUESTAOK.getRespuestaPeticiones());
	}
	
	
	
	
}
