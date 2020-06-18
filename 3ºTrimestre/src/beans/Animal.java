package beans;



public class Animal {

	private String nombre;
	private String alimentacion;
	private int idAnimales;
	
	public Animal() {}
	public Animal(int idAnimales ,String nombre, String alimentacion) {
		this.idAnimales = idAnimales;
		this.nombre = nombre;
		this.alimentacion = alimentacion;
	}
	
	public Animal(String nombre, String alimentacion) {
		this.nombre = nombre;
		this.alimentacion = alimentacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlimentacion() {
		return alimentacion;
	}
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	public int getIdAnimales() {
		return idAnimales;
	}
	public void setIdAnimales(int idAnimales) {
		this.idAnimales = idAnimales;
	}

}
