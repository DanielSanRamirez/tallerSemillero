package com.clearminds.dra.bdd.test;

import com.clearminds.dra.dtos.Estudiante;
import com.clearminds.dra.excepciones.BDDException;
import com.clearminds.dra.servicios.ServicioEstudiante;

public class TestServicio {

	public static void main(String[] args) {
		
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		try {
			srvEstudiante.insertarEstudiante(new Estudiante("Juan", "Pérez"));
		} catch (BDDException e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

}
