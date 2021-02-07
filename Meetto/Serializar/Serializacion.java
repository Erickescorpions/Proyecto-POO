package meetto.serializar;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.File;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import meetto.usuarios.Usuario;
import meetto.controlador.Controlador;

public class Serializacion {

    Controlador c;
    final String file_name = "map.ser";

    public Serializacion( Controlador c ) {

        this.c = c;
    }

    public void serializarUsuarios() {

        try {
            
            FileOutputStream f = new FileOutputStream( file_name );
            ObjectOutputStream output = new ObjectOutputStream( f );
            output.writeObject( this.c.s.usuarios );
            output.close();
            f.close();
            
        } catch( IOException e ) {

            System.out.println("Error");
        }
    }

    public void RecuperarUsuarios() {

        try {

            if( new File( file_name ).exists() ) {
                FileInputStream f = new FileInputStream( file_name );
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
}
