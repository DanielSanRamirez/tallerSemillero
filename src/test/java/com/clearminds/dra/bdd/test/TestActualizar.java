package com.clearminds.dra.bdd.test;

import com.clearminds.dra.dtos.Estudiante;
import com.clearminds.dra.excepciones.BDDException;
import com.clearminds.dra.servicios.ServicioEstudiante;

public class TestActualizar {

	public static void main(String[] args) {
		
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		
		try {
			srvEstudiante.actualizarEstudiante(new Estudiante("Perdro", "Navaja", 2));
		} catch (BDDException e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

}
