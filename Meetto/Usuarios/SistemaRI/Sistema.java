package clases.usuarios.sistema_ri;

import clases.usuarios.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.Serializable;

public class Sistema implements Serializable {

    public HashMap<String, Usuario> usuarios;
    
    public Sistema() {

        this.usuarios = new HashMap<String, Usuario>( 100 );
    }

    public Object Registrar( String nombre, int edad, String email, String password, String repPassword ) {
        
        String str = "";

        try {

            MyException ex = new MyException();

            ex.ValidarNombre( nombre );
            ex.ValidarEdad( edad );
            ex.ValidarEmail( email );
            ex.validarPassword( password, repPassword );
            
            if( usuarios.containsKey( email ) ) {
           
                System.out.println( "El correo que trata de utilizar para registrarse, ya ha sido usado para crear otra cuenta" );
                str = "El correo que trata de utilizar para registrarse, ya ha sido usado para crear otra cuenta";
            } else {

                Usuario u = new Usuario( nombre, email, edad, password ); 
                usuarios.put( email, u );
                System.out.println( "Registro exitoso." + usuarios.get(email) );
                
                return u;
            }

        } catch( NombreInvalido ni ) {

            str = ni.getMessage();
            System.out.println( ni.getMessage() );
        } catch( InputMismatchException ime ) {

            str = "Ingrese solo numeros";
            System.out.println( "Ingrese solo numeros." );
        } catch( EdadInvalida ei ) {

            str = ei.getMessage();
            System.out.println( ei.getMessage() );
        } catch( EmailInvalido ci ) {

            str = ci.getMessage();
            System.out.println( ci.getMessage() );
        } catch( PasswordError pe ) {

            str = pe.getMessage();
            System.out.println( pe.getMessage() );
        }

        return str;
    }

    public Object Ingresar( String email, String password ) {

        Usuario u = null;

        try {

            MyException ex = new MyException();

            ex.ValidarEmail( email );

            if( usuarios.containsKey( email ) ) {

                u = usuarios.get( email );
                if( u.getPassword().equals( password ) ) return u;
                else return "Contraseña incorrecta.";
            } else {

                System.out.println("El email que trata de usar no se encuentra registrado registrado");
                return "El email que trata de usar no se encuentra registrado registrado.";
            }

        } catch( EmailInvalido ci ) {

            System.out.println( ci.getMessage() );
            return ci.getMessage();
        } 
    }

    public HashMap<String, Usuario> getUsuarios() {
        
        return this.usuarios;
    }

    public String setNombre( Usuario u, String nombre ) {

        String str = "";

        try {

            MyException ex = new MyException();

            ex.ValidarNombre( nombre );
            
            u.setNombre(nombre);
            str = "Cambio exitoso";
            System.out.println( str + nombre );

        } catch( NombreInvalido ni ) {

            str = ni.getMessage();
            System.out.println( ni.getMessage() );
        } 

        return str;
    }

    public String setPassword( Usuario u, String password, String repPassword ) {

        String str = "";

        try {

            MyException ex = new MyException();

            ex.validarPassword( password, repPassword );
            
            u.setPassword( password );
            str = "Cambio exitoso";
            System.out.println( str + password );

        } catch( PasswordError pe ) {

            str = pe.getMessage();
            System.out.println( pe.getMessage() );
        }

        return str;
    }
}
