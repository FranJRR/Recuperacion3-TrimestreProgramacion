package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.conexion;
import beans.Animal;

public class Animales {
	
	public void insertarAnimal(Animal animal, int idAlimento) {
		String nombre = animal.getNombre();
		conexion.EjecutarUpdate("INSERT INTO `animales` (`idAnimales`, `nombres`, `idAlimentacion`) VALUES (NULL, ' "+ nombre + "', '" + idAlimento + "')");
	}
	
	
	public Animal recogerAnimal(String nombreAnimal) {
		ResultSet resultado = conexion.EjecutarSentencia("SELECT * FROM animales WHERE nombre='"+ nombreAnimal +"';");
		try {
			if(resultado.next()) {
				String nombre = resultado.getString("nombre");
				String alimentacion = resultado.getString("Alimento");
				Animal animalRecogido = new Animal(0,nombre, alimentacion);
				return animalRecogido;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/* Transformacion */
		return null;
	}
	
	public ArrayList<Animal> recogerTodosAnimales(){
		ArrayList<Animal> animales = new ArrayList<Animal>();
		ResultSet resultado = conexion.EjecutarSentencia("SELECT idAnimales, nombres, tipo FROM animales a , alimentacion t where a.idAlimentacion = t.idAlimentacion ORDER BY idAnimales;");
		try {
			while(resultado.next()) {
				String nombre = resultado.getString("nombres");
				String alimentacion = resultado.getString("tipo");
				int idAnimal = resultado.getInt("idAnimales");
				animales.add(new Animal(idAnimal, nombre, alimentacion));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animales;
	}

	public void modificarAnimal(int idAnimal, String nombreAnimal, int idAlimento) {
		conexion.EjecutarUpdate("UPDATE animales SET nombres='" + nombreAnimal + "', idAlimentacion=" + idAlimento + " WHERE idAnimales = " + idAnimal +";");
	}
		
	

}
