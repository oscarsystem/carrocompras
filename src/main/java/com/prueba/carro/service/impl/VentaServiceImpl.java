package com.prueba.carro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prueba.carro.model.Venta;
import com.prueba.carro.repository.IVentaRepository;
import com.prueba.carro.service.IVentaService;
import com.prueba.carro.util.EnumEstados;

@Service
public class VentaServiceImpl implements IVentaService {

	private static final Class<VentaServiceImpl> NOMBRECLASE = VentaServiceImpl.class;
	private static final Logger LOGGER = LoggerFactory.getLogger(NOMBRECLASE);
		
	private IVentaRepository ventaRepo;	
	
	public VentaServiceImpl(IVentaRepository ventaRepo) {
		this.ventaRepo = ventaRepo;
	}

	@Override
	public void createVenta() {

		try {			
			Venta venta=new Venta();
			venta.setEstado(EnumEstados.ESTADOCARROPENDIENTE.getEstadoCarro());
			venta.setTotal_venta(0);
			
			LOGGER.info("Creando venta: ");
			ventaRepo.save(venta);
		}catch(Exception e){
			LOGGER.error(NOMBRECLASE + "Error metodo createVenta: " + e);
		}
		
	}

	@Override
	public List<Venta> getAllVentas() {
		List<Venta> listVentas = new ArrayList<>();
		try {			
			LOGGER.info("Listando ventas: ");
			listVentas = ventaRepo.findAll();
		}catch(Exception e){
			LOGGER.error(NOMBRECLASE + "Error metodo getAllVentas: " + e);
		}
		return listVentas;
	}
	
	@Override
	public String checkoutVenta(Venta venta) {
		
		String rta = null;
		
		try {			
			LOGGER.info("checkoutVenta venta: " + venta.getId());
			venta.setEstado(EnumEstados.ESTADOCARROCOMPLETADO.getEstadoCarro());
			double calculoTotalVenta = ventaRepo.sumTotalVenta(venta.getId());
			venta.setTotal_venta(calculoTotalVenta);
			ventaRepo.save(venta);
			rta = String.valueOf(venta.getTotal_venta());
		}catch(Exception e){
			LOGGER.error(NOMBRECLASE + "Error metodo checkoutVenta: " + e);
		}
		return rta;
	}

		
	
}
