package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import bbdd.conexion;
import beans.Animal;

public class Alimentos {

	public int obtenerIDAlimento(String tipo) {
		ResultSet resultado = conexion.EjecutarSentencia("SELECT idAlimentacion FROM alimentacion WHERE tipo='"+ tipo +"';");
		try {
			if(resultado.next()) {
				System.out.print(resultado.getInt("idAlimentacion"));
				return resultado.getInt("idAlimentacion");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}
