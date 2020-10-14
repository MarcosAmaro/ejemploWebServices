package com.soap.pojo;

public class Curso extends ResponseStatus{
	
	private Integer id;
	private String lenguaje;
	private float precio;
	private int duracion;

	public Curso() {
		super();
	}
	

	public Curso(Integer id, String lenguaje, float precio, int duracion) {
		super();
		this.id = id;
		this.lenguaje = lenguaje;
		this.precio = precio;
		this.duracion = duracion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return String.format("Id: %d\nLenguaje: %s\nPrecio: %.2f\nDuracion: %d", this.id, this.lenguaje, this.precio,
				this.duracion);
	}
}
