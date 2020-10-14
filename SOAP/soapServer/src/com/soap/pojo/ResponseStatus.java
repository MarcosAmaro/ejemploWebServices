package com.soap.pojo;

public class ResponseStatus {
	private Integer error;
	private String descripcion;
	
	public ResponseStatus() {
		
	}
	
	public ResponseStatus(Integer error, String descripcion) {
		super();
		this.error = error;
		this.descripcion = descripcion;
	}

	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return String.format("Error: %d\nDescripcion: %s\n", this.error, this.descripcion);
	}
}
