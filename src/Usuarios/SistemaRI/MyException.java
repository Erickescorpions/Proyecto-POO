package clases.usuarios.sistema_ri;

import java.lang.Exception;

public class MyException {
    
    MyException() {}
    
    /**
     * Valida el nombre del usuario
     * @param nombre Variable que almacena el nomrbe
     * @throws NombreInvalido Se arroja cuando el nombre no cumple los requisitos requiridos
     */
    void ValidarNombre( String nombre ) throws NombreInvalido {

        if( !nombre.matches("^([A-Z]{1}[a-z]+[ ]*){1,4}") && !nombre.matches("^([a-z]+[ ]*){1,4}") ) throw new NombreInvalido();
    }
    
    /**
     * Valida la edad del usuario
     * @param edad Variable que almacena la edad
     * @throws EdadInvalida Se arroja cuando la edad es mayor a 18
     */
    void ValidarEdad( int edad ) throws EdadInvalida {

        if( edad < 18 ) throw new EdadInvalida();
    }
    
    /**
     * Valida el email
     * @param email Variable que almacena la edad
     * @throws EmailInvalido Se arroja cuando la edad es mayor a 18
     */
    void ValidarEmail( String email ) throws EmailInvalido {

        if( !email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") ) throw new EmailInvalido();
    }
    
    /**
     * Valida que el password sea seguro
     * @param password Variable que almacena el password
     * @param repPassword Variable que almacena la confirmacion del password
     * @throws PasswordError Se arroja cuando hay un error con el password
     */
    void validarPassword( String password, String repPassword ) throws PasswordError {
    	
    	if( password.length() < 8 ) throw new PasswordError("El password es muy corto, minimo 8 caracteres");
        if( !password.equals( repPassword ) ) throw new PasswordError("Los passwords no coinciden");
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