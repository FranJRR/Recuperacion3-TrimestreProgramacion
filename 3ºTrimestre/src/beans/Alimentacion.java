package beans;

public class Alimentacion {

	private int id;
	private String alimentacion;
	
	public Alimentacion() {}
	public Alimentacion(int id, String alimentacion) {
		this.id = id;
		this.alimentacion = alimentacion;
	}
	
	public String getAlimentacion() {
		return alimentacion;
	}
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	public int getId() {
		return id;
	}

}

