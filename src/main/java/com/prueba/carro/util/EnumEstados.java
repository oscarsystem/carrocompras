package com.prueba.carro.util;

public enum EnumEstados {

	ESTADOCARROPENDIENTE(1), ESTADOCARROCOMPLETADO(2);
	
	private EnumEstados(int i) {
		this.estadoCarro = i;
	}

	private int estadoCarro;

	public int getEstadoCarro() {
		return estadoCarro;
	}

	public void setEstadoCarro(int estadoCarro) {
		this.estadoCarro = estadoCarro;
	}

}