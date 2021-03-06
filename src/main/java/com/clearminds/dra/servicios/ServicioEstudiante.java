package com.clearminds.dra.servicios;

import java.sql.*;
import java.util.Date;

import com.clearminds.dra.dtos.Estudiante;
import com.clearminds.dra.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase {

	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		Statement stmt = null;
		try {
			stmt = getConexion().createStatement();
			
			estudiante.setFechaModificacion(DataUtil.convertirFecha(new Date()));

			String sql = "insert into estudiantes(nombre,apellido,edad,fecha_modificacion) values('"
					+ estudiante.getNombre() + "', '" + estudiante.getApellido() + "', '" + estudiante.getEdad()
					+ "', '" + estudiante.getFechaModificacion() + "')";

			System.out.println("Script: " + sql);

			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}

	}

	public void actualizarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Actualizando estudiante: " + estudiante);
		Statement stmt = null;

		try {
			stmt = getConexion().createStatement();
			
			estudiante.setFechaModificacion(DataUtil.convertirFecha(new Date()));
			System.out.println(estudiante.getFechaModificacion());
			
			String sql = "update estudiantes set nombre='" + estudiante.getNombre() + "', apellido='"
					+ estudiante.getApellido() + "', edad='" + estudiante.getEdad() + "', fecha_modificacion='" + estudiante.getFechaModificacion()
					+ "' where id=" + estudiante.getId() + "";

			System.out.println("Script: " + sql);

			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al actualizar estudiante");
		}
	}

}
