package clases.ventana_grafica.muro;

import java.io.Serializable;

public class Publicaciones implements Serializable {
	
	//Campos
    public String u = "";
    public String p = "";
    public String amigo = "";
    public String d = "";
    
    /**
     * Constructor 
     * @param u Variable que almacena al usaurio que realizo la publicacion
     * @param p Variable que guarda el texto la publicacion 
     */
    public Publicaciones( String u, String p ) {

        this.u = u;
        this.p = p;
        this.d = new Datos().datos_fecha();
    }

    /**
     * 
     * @param u Variable que almacena al usuario que realizo la publicacion
     * @param amigo Variable que almacena al usuario a quien se le hace la publicacion 
     * @param p Variable que guarda el texto la publicacion 
     */
    public Publicaciones( String u, String amigo, String p) {

        this.u = u;
        this.amigo = amigo;
        this.p = p;

        this.d = new Datos().datos_fecha();
    }
}
