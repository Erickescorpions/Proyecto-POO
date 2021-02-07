package clases.usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import clases.ventana_grafica.muro.Publicaciones;

public class Usuario implements Serializable {

    String nombre = "";
    String email = "";
    int edad = 0;
    String password = "";
    String Imagen = "";
    public ArrayList<Publicaciones> publicaciones = new ArrayList<Publicaciones>();

    public Usuario() {}

    public Usuario( String nombre, String email, int edad, String password ) {

        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.password = password;
        this.Imagen = "Meetto/Imagenes/anonimo.png";
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setEdad( int edad ) {
        this.edad = edad;
    }

    public void setPassword( String password ) {

        this.password = password;
    }

    public void setImagen( String ruta ) {

        this.Imagen = ruta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getPassword() {

        return this.password;
    }

    public String getImagen() {

        return this.Imagen;
    }

    public String toString() {
        return "\n" + this.nombre + "\n" + this.email + "\n" + this.password;
    }
}
