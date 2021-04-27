package com.prueba.carro.util;

public enum EnumRespuesta {

	RESPUESTAOK("La operacion se realizo correctamente"), RESPUESTAFAIL("Error en la estrcutrua de la peticion");	
	
	private EnumRespuesta(String respuestaPeticiones) {
		this.respuestaPeticiones = respuestaPeticiones;
	}

	private String respuestaPeticiones;

	public String getRespuestaPeticiones() {
		return respuestaPeticiones;
	}

	public void setRespuestaPeticiones(String respuestaPeticiones) {
		this.respuestaPeticiones = respuestaPeticiones;
	}
	
	
	
}
