package com.prueba.carro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "venta_producto")
@Table(name = "venta_producto")
public class VentaProducto {

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;	
	@ManyToOne
	private Venta id_venta;	
	@ManyToOne
	private Producto id_producto;	
	@NotNull
	private int cantidad;
	private double total_precio;
	
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Venta getId_venta() {
		return id_venta;
	}
	public void setId_venta(Venta id_venta) {
		this.id_venta = id_venta;
	}
	public Producto getId_producto() {
		return id_producto;
	}
	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal_precio() {
		return total_precio;
	}
	public void setTotal_precio(double total_precio) {
		this.total_precio = total_precio;
	}
	
}
