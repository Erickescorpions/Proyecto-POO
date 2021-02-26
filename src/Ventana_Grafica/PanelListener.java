package clases.ventana_grafica;

import java.util.EventListener;
import javax.swing.JPanel;

public interface PanelListener extends EventListener {
    
	/**
	 * Evento que se lanza cuando se requiere un cambio de panel entre clases
	 * que se encuentran en distinta jerarquia (distintas carpetas)
	 * @param ob Variable objeto
	 */
    public void cambioPanel( Object ob );
    
    /**
     * Evento que se lanza cuando se requiere un cambio de panel entre clases
     * que se encuentran en distinta jerarquia (distintas carpetas)
     * @param ob Variable objeto
     * @param val Llave para buscar algun valor 
     */
    public void cambioPanel( Object ob, String val );
}

