package com.prueba.carro.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.carro.model.Venta;
import com.prueba.carro.service.IVentaService;
import com.prueba.carro.util.EnumRespuesta;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/carro")
public class VentaController {

	private static final Class<VentaController> NOMBRECLASE = VentaController.class;
	private static final Logger LOGGER = LoggerFactory.getLogger(NOMBRECLASE);
		
	private IVentaService ventaService;
	
	public VentaController(IVentaService ventaService) {
		this.ventaService = ventaService;
	}

	
	@GetMapping
	@RequestMapping("/getAll")
	public List<Venta> listAll(){
		try {				
			return ventaService.getAllVentas();
		}catch(Exception e) {
			LOGGER.error("Error en listAll: " + NOMBRECLASE + e);
			return null;
		}
	}
	
	@PostMapping
	@RequestMapping("/addCarro")
	public ResponseEntity<String> insert() {
		try {				
			ventaService.createVenta();
			return ResponseEntity.ok(EnumRespuesta.RESPUESTAOK.getRespuestaPeticiones());			
		}catch(Exception e) {
			LOGGER.error("Error en insert: " + NOMBRECLASE + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.valueOf(e));
		}
	}
	
	
	@PutMapping
	@RequestMapping("/checkout")
	public ResponseEntity<String> checkout(@Valid @RequestBody Venta venta, BindingResult result) {
		
		if(result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EnumRespuesta.RESPUESTAFAIL.getRespuestaPeticiones());
		}		
		String rta = null;		
		try{
			rta=  ventaService.checkoutVenta(venta);
		}catch (Exception e) {
			LOGGER.error("Error metodo checkout "+ NOMBRECLASE);
		}
		return ResponseEntity.ok(rta);
	}
	
}
