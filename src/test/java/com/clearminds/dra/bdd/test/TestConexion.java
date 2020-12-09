package com.clearminds.dra.bdd.test;

import java.sql.*;

import com.clearminds.dra.bdd.ConexionBDD;
import com.clearminds.dra.excepciones.BDDException;

public class TestConexion {

	public static void main(String[] args) {
		
		try {
			Connection conexion = ConexionBDD.obtenerConexion();
			if(conexion != null) {
				System.out.println("Conexión exitosa");
			}
		} catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
