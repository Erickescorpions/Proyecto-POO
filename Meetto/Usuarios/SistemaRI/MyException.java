package meetto.usuarios.sistema_ri;

import java.lang.Exception;

public class MyException {
    
    MyException() {}

    void ValidarNombre( String nombre ) throws NombreInvalido {

        if( !nombre.matches("^([A-Z]{1}[a-z]+[ ]*){1,4}") && !nombre.matches("^([a-z]+[ ]*){1,4}") ) throw new NombreInvalido();
    }

    void ValidarEdad( int edad ) throws EdadInvalida {

        if( edad < 18 ) throw new EdadInvalida();
    }

    void ValidarEmail( String email ) throws EmailInvalido {

        if( !email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") ) throw new EmailInvalido();
    }

    void validarPassword( String password, String repPassword ) throws PasswordError {

        if( !password.equals( repPassword ) ) throw new PasswordError("Las contraseñas no coinciden");
        if( !password.matches("^([A-Za-z0-9|$|@|!]+[ ]*){8,30}") ) throw new PasswordError("El password es inseguro o demasiado largo");
    }
}

class NombreInvalido extends Exception {

    NombreInvalido() {
        super("El nombre es invalido.");
    }
}

class EdadInvalida extends Exception {

    EdadInvalida() {
        super("La edad es insuficiente para una cuenta en Meetto.");
    }
}

class EmailInvalido extends Exception {

    EmailInvalido() {
        super("El correo es invalido.");
    }
}

class PasswordError extends Exception {

    PasswordError( String msj ) {
        super( msj );
    }
}