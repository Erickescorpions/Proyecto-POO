package clases.ventana_grafica.registro_ingreso;

import java.util.EventListener;

public interface OperacionListener extends EventListener {
	
	/**
	 * Evento que se lanza cuando se manda un booleano
	 * @param arg Variable boolena
	 */
    public void operacionExitosa( boolean arg );
}
