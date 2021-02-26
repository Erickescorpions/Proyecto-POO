package clases.controlador;

import clases.usuarios.Usuario;
import clases.usuarios.sistema_ri.Sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

public class Controlador {
    
	//Campos de la clase
    public Usuario u = new Usuario();
    public Sistema s;
    public Usuario amigo = new Usuario();
    public Collection<Usuario> usuarios_registrados;


    public Controlador() {
        this.s = new Sistema();
    }
    
    /**
     * Invoca el metodo 'Registrar' de la clase Sistema y si el registo fue
     * exitoso, guarda a el usuario para su uso posterior
     * @param nombre Variable que contiene el nombre del usuario
     * @param edad Variable que contiene la edad del usuario
     * @param email Variable que contiene el email del usuario
     * @param password Variable que contiene el password del usuario
     * @param repPassword Variable que contiene la confirmacion del password del usuario
     * @return Una referencia a un objeto
     */
    public Object Registro( String nombre, int edad, String email, String password, String repPassword ) {

        Object ob = this.s.Registrar( nombre, edad, email, password, repPassword );

        if( ob instanceof Usuario ) {

            this.u = (Usuario) ob;
        }

        return ob;
    }
    
    /**
     * Invoca el metodo 'Ingresar' de la clase Sistema y si el registo fue
     * exitoso, guarda a el usuario para su uso posterior
     * @param email Variable que contiene el email
     * @param password Variable que contiene el password
     * @return Una referencia a un objeto
     */
    public Object Ingreso( String email, String password ) {

        Object ob = this.s.Ingresar( email, password );

        if( ob instanceof Usuario ) {

            this.u = (Usuario) ob;
        }

        return ob;
    }
    
    /**
     * Cambia la foto de un usuario
     * @param f Un archivo
     * @return La ruta de la foto
     */
    public String CambiarFoto( File f ) {

        String ruta = CopiarImagen( f );

        u.setImagen( ruta );

        return ruta;
    }
    
    /**
     * Copia la imagen que el usuario quiere ingresar en un archivo local
     * @param f Un archivo
     * @return La ruta de la foto
     */
    private String CopiarImagen( File f ) {

        String ruta = f.getAbsolutePath();
        String[] name = ruta.split("/");
        String nameCopy = "src/Imagenes/" + name[ name.length - 1 ];

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

            System.out.println("Error con el archivo");
        }   

        return nameCopy;
    }
    
    /**
     * Obtiene una lista de los usuarios registrados en el sistema
     */
    public void getUsuariosRegistrados() {
        
        this.usuarios_registrados = this.s.getUsuarios().values();
    }
    
    /**
     * Obtiene una array de los nombres de los usuarios registrados en el sistema
     * @return Un array de la lista de usuarios
     */
    public String[] getNombresUsuariosRegistrados() {

        String[] nombres_usuarios = new String[ this.usuarios_registrados.size() - 1 ];

        int i = 0;
        for( Usuario user : this.usuarios_registrados ) {

            if( this.u.getEmail().equals( user.getEmail() ) ) continue;
            nombres_usuarios[ i ] = user.getNombre();
            i++;
        }
        
        return nombres_usuarios;
    }
    
    /**
     * Cambia un dato de la informacion del usuario (nombre o password)
     * @param arg_1 Uno de los parametros a cambiar
     * @param arg_2	UNo de los parametros a cambiar
     * @return Un String del resultado
     */
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
    
    /**
     * Obtiene a un usuario auxiliar 
     * @param key Es el nombre del usuario que vamos a buscar
     */
    public void getUsuario( String key ) {

        for( Usuario user : this.usuarios_registrados ) {

            if( user.getNombre().equals( key ) ) {

                this.amigo = user;
                break;
            }
        }
    }
    
} // cierre de la clase
