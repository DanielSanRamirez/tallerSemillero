package com.clearminds.dra.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	public static final String FORMATO_COMPLETO = "yyy/MM/dd HH:mm:ss";
	
	public static String obtenerFecha(Date date) { 
		SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_COMPLETO);

		String cadena = formateador.format(date);

		return cadena;
	}

}
