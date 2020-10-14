package pojo;

public class ResponseStatus {
	private Integer error;
	private String descripcion;
	
	public ResponseStatus() {
		
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
