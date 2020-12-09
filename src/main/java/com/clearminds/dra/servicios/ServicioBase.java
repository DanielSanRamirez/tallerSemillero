package com.clearminds.dra.servicios;

import java.sql.*;

import com.clearminds.dra.bdd.ConexionBDD;
import com.clearminds.dra.excepciones.BDDException;

public class ServicioBase {
	
	private Connection conexion;
	
	public void abrirConexion() throws BDDException{
			conexion = ConexionBDD.obtenerConexion();
	}
	
	public void cerrarConexion() {
		try {
			if (conexion != null) {
				conexion.close();	
				System.out.println("Conexión cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cerrar la conexión");
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
