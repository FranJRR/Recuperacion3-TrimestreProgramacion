package controlador;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

import bbdd.conexion;
import beans.Animal;
import modelo.Animales;
import vista.Principal;
import modelo.Alimentos;

public class Central {

	public int saludar(String nombre, String tipo) {
		
		
		// Vamos a tener alimento como parametro de la funcion saludar
		// Vamos  a llamar a animales.obtenerAlimentoID
		// Vamos a crear esa funcion en la clase Alimentacion.java
		
		Animal animal = new Animal(0 ,nombre, tipo);
		Animales animales = new Animales();
		Alimentos alimentos = new Alimentos();
		int idAlimento = alimentos.obtenerIDAlimento(tipo);
		
		if(idAlimento < 0) {
			JOptionPane.showMessageDialog(null, "Eso no es ningun tipo de comida (carnivoro, herbivoro, omnivoro)");
			return -1;
			// Te muestro un modal diciendo que no es el tipo de alimento
		}
		
		else {
			animales.insertarAnimal(animal, idAlimento);
			JOptionPane.showMessageDialog(null, "Te saluda " + nombre);
			return 1;
		}	
	}
	
	public void verTodos() {
		/* Cargar los datos */
		ArrayList<Animal> animales = new modelo.Animales().recogerTodosAnimales();
		/* Abrir ventana ver todos */
		new vista.Tabla(animales);
	}
	
	public void eliminar(int id) {
		
		conexion.EjecutarUpdateEliminar("DELETE FROM animales WHERE idAnimales = "+id+";");
		
	}

	public void modificarAnimal(int idAnimal, String nombreAnimal, String nombreAlimento) {
		// Obtenemos el ID del alimento mediante su nombre
		
		Alimentos alimentos = new Alimentos();
		int idAlimento = alimentos.obtenerIDAlimento(nombreAlimento);
		
		// Con ese ID hacemos update del animal mediante su ID, su nombre nuevo y su alimento nuevo
		Animales animales = new Animales();
		animales.modificarAnimal(idAnimal, nombreAnimal, idAlimento);
		
	}
	
	
}
