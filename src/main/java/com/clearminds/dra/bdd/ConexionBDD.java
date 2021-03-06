package com.clearminds.dra.bdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clearminds.dra.excepciones.BDDException;

public class ConexionBDD {
	
	public static String leerPropiedad(String nombrePropiedad) {
		File f = new File("conexion.properties");
		System.out.println("ruta: " + f.getAbsolutePath());
		
		File file = new File("D:\\CapacitacionCMC\\WorkspaceCMC\\tallerSemillero\\conexion.properties");
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			List<String> propiedades = new ArrayList<String>();
			
			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				String nombre = buscar(linea, nombrePropiedad);
				if (nombre != null) {
					return nombre;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String buscar(String linea, String nombrePropiedad) {
		String p = null;
		try {
			String[] partes = linea.split(": ");
			if (partes[0].equals(nombrePropiedad)) {
				return partes[1];
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Connection obtenerConexion() throws BDDException{
		Connection conn = null;
		
		String usuario = leerPropiedad("usuario");
		String password = leerPropiedad("password");
		String url = leerPropiedad("urlConexion") + ";user="+ usuario +";password=" + password;
		
		try {
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("No se pudo conectar a la base de datos");
		}
	}

}
