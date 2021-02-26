package clases.serializar;

import java.io.FileOutputStream;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.net.Socket;
import java.io.File;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import clases.usuarios.Usuario;
import clases.controlador.Controlador;

public class Serializacion {
	
	//Campos de la clase
    Controlador c;
    final String FILE_NAME = "map.ser";

    /**
     * Constructor 
     * @param c Referencia a un objeto tipo 'Controlador'
     */
    public Serializacion( Controlador c ) {

        this.c = c;
    }
    
    /**
     * Serializa los usuarios registrados en el programa
     */
    public void serializarUsuarios() {

        try {
            
            FileOutputStream f = new FileOutputStream( FILE_NAME );
            ObjectOutputStream output = new ObjectOutputStream( f );
            output.writeObject( this.c.s.usuarios );
            output.close();
            f.close();
            
        } catch( IOException e ) {

            System.out.println("Error");
        }
    }

    /**
     * Recupera los datos de los usuarios registrados
     */
    public void RecuperarUsuarios() {

        try {

            if( new File( FILE_NAME ).exists() ) {
                FileInputStream f = new FileInputStream( FILE_NAME );
                ObjectInputStream input = new ObjectInputStream( f );
                this.c.s.usuarios = (HashMap< String, Usuario>) input.readObject();

                input.close();
                f.close();
            }
        } catch( IOException e ) {

            System.out.println("Error");
            System.exit(0);
        } catch( ClassNotFoundException e ) {

            System.out.println("Error");
            System.exit(0);
        } catch( Exception e ) {

            System.out.println("Error");
            System.exit(0);
        }
    }

} // cierre de la clase