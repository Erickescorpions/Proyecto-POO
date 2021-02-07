package meetto.ventana_grafica.muro;

import java.time.LocalTime;
import java.time.LocalDate;

public class Datos{
	
	public String hora() {

		LocalTime hora = LocalTime.now();
		String res = hora.toString();
		String res2 = "";
		for( int i = 0; i < 8; ++i){
			res2 += res.charAt(i);
		}
		return res2;
	}
	
	public String fecha() {

		LocalDate fechaActual = LocalDate.now(); 
		return fechaActual.toString();
	}

	public String datos_fecha() {

		return fecha() + "   " + hora();
	}

	public Datos(){}
}