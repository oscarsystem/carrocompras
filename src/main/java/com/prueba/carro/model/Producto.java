package com.prueba.carro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "producto")
public class Producto {

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	String id;
	@NotNull
	String nombre;
	@NotNull
	String sku;
	String descripcion;
	@NotNull
	double precio;
	@NotNull
	String tipo;
			
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/*
	public Set<VentaProductoDTO> getVentaProducto() {
		return ventaProducto;
	}
	public void setVentaProducto(Set<VentaProductoDTO> ventaProducto) {
		this.ventaProducto = ventaProducto;
	}	*/	
			
	
	
}
