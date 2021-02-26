package clases.ventana_grafica.muro;

import java.time.LocalTime;
import java.time.LocalDate;

public class Datos{
	
	private String hora() {

		LocalTime hora = LocalTime.now();
		String res = hora.toString();
		String res2 = "";
		for( int i = 0; i < 8; ++i){
			res2 += res.charAt(i);
		}
		return res2;
	}
	
	private String fecha() {

		LocalDate fechaActual = LocalDate.now(); 
		return fechaActual.toString();
	}
	
	/**
	 * Obtiene los datos de la fecha y hora del dia
	 * @return Un string con los datos
	 */
	public String datos_fecha() {

		return fecha() + "   " + hora();
	}

	public Datos(){}
}