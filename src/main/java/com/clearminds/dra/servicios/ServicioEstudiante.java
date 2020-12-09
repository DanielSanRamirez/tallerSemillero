package com.clearminds.dra.servicios;

import com.clearminds.dra.dtos.Estudiante;
import com.clearminds.dra.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase{
	
	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante.toString());
		cerrarConexion();
	}

}
