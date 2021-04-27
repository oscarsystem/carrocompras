package com.prueba.carro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "venta")
public class Venta {

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	String id;
	int estado;
	double total_venta;
			
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}
	
	/*
	public Set<VentaProductoDTO> getVentaProductos() {
		return ventaProductos;
	}
	public void setVentaProductos(Set<VentaProductoDTO> ventaProductos) {
		this.ventaProductos = ventaProductos;
	}	
	*/
	
	
}
