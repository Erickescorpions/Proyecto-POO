package clases;

import clases.ventana_grafica.VentanaPrincipal;
import clases.serializar.Serializacion;
import clases.controlador.Controlador;

import java.awt.*; 
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Main {

    Serializacion s; 

    public static void main( String[] args ) {
        
        Main ob = new Main();
        Controlador c = new Controlador();
        ob.s = new Serializacion( c );

        ob.s.RecuperarUsuarios();
        VentanaPrincipal v = new VentanaPrincipal( c );
        v.setVisible( true );

        v.addWindowListener( new WindowAdapter(){

            @Override
            public void windowClosing( WindowEvent e ) {

                ob.s.serializarUsuarios();

                System.exit(0);
            }
        });

    }
}
