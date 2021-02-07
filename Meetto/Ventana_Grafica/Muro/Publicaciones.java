package meetto.ventana_grafica.muro;

import java.io.Serializable;


public class Publicaciones implements Serializable {

    public String u = "";
    public String p = "";
    public String amigo = "";
    public String d = "";

    public Publicaciones( String u, String p ) {

        this.u = u;
        this.p = p;
        this.d = new Datos().datos_fecha();
    }

    public Publicaciones( String u, String amigo, String p) {

        this.u = u;
        this.amigo = amigo;
        this.p = p;

        this.d = new Datos().datos_fecha();
    }
}
