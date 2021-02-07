package meetto.controlador;

import meetto.usuarios.Usuario;
import meetto.usuarios.sistema_ri.Sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

public class Controlador {
    
    public Usuario u = new Usuario();
    public Sistema s;
    public Usuario amigo = new Usuario();
    public Collection<Usuario> usuarios_registrados;

    public Controlador() {
        this.s = new Sistema();
    }

    public Object Registro( String nombre, int edad, String email, String password, String repPassword ) {

        Object ob = this.s.Registrar( nombre, edad, email, password, repPassword );

        if( ob instanceof Usuario ) {

            this.u = (Usuario) ob;
            System.out.println("hecho, usuario en el sistema " + this.u);
        }

        return ob;
    }

    public Object Ingreso( String email, String password ) {

        Object ob = this.s.Ingresar( email, password );

        if( ob instanceof Usuario ) {

            this.u = (Usuario) ob;
        }

        return ob;
    }

    public String getImagen() {

        return this.u.getImagen(); 
    }

    public String CambiarFoto( File f ) {

        String ruta = CopiarImagen( f );

        u.setImagen( ruta );

        return ruta;
    }

    private String CopiarImagen( File f ) {

        String ruta = f.getAbsolutePath();
        String[] name = ruta.split("/");
        String nameCopy = "Meetto/Imagenes/" + name[ name.length - 1 ];

        try {

            FileInputStream forigin = new FileInputStream( ruta );
            FileOutputStream fcopy = new FileOutputStream( nameCopy );

            byte[] buffer = new byte[ 1024 ];

            int nBytes = forigin.read( buffer );

            //Mientras el numero de Bytes leidos no sea cero, se sigue leyendo del archivo original y escribiendo en la copia
            while( nBytes > 0 ) {

                fcopy.write( buffer, 0, nBytes );
                nBytes = forigin.read( buffer );
            }

            forigin.close();
            fcopy.close();
    
        } catch ( IOException e ) {

            System.out.println( "Error con el archivo");
        }   


        return nameCopy;
    }

    public void getUsuariosRegistrados() {
        
        this.usuarios_registrados = this.s.getUsuarios().values();
    }

    public String[] getNombresUsuariosRegistrados() {

        String[] nombres_usuarios = new String[ this.usuarios_registrados.size() - 1 ];

        int i = 0;
        for( Usuario user : this.usuarios_registrados ) {

            if( this.u.getNombre().equals( user.getNombre() ) ) continue;
            nombres_usuarios[ i ] = user.getNombre();
            i++;
        }
        
        return nombres_usuarios;
    }

    public String CambiarDato( Object arg_1, Object arg_2 ) {

        String str = "";

        if( arg_1 instanceof String && arg_2 instanceof String ) {
            
            String aux_1 = (String) arg_1;
            String aux_2 = (String) arg_2;
            
            if( !aux_1.equals("") ) {
                if( aux_2.equals("") ) {

                    str = this.s.setNombre( this.u, aux_1 );
                    
                } else {

                    str = this.s.setPassword( this.u, aux_1, aux_2 );
                }
            }
        } 

        System.out.println(this.u.toString());

        return str;
    }

    public void getUsuario( String key ) {

        for( Usuario user : this.usuarios_registrados ) {

            if( user.getNombre().equals( key ) ) {

                this.amigo = user;
                break;
            }
        }
    }
}
