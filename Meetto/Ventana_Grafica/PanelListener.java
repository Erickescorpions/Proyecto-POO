package meetto.ventana_grafica;

import java.util.EventListener;
import javax.swing.JPanel;

public interface PanelListener extends EventListener {
    
    public void cambioPanel( Object ob );
    public void cambioPanel( Object ob, String val );
}

