package clases.ventana_grafica;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.text.ComponentView;
import javax.swing.text.AttributeSet.ColorAttribute;

import clases.ventana_grafica.datos_personales.PanelPrincipalD;
import clases.ventana_grafica.registro_ingreso.PanelPrincipalRI;
import clases.ventana_grafica.muro.*;
import clases.controlador.Controlador;

public class VentanaPrincipal extends JFrame implements PanelListener {
    
    PanelPrincipalRI panelRI;
    PanelPrincipalD panelD;
    Panel_Wall panelW;
    Panel_Amigo panelA;

    JScrollPane contenedor;

    Controlador c;

    public VentanaPrincipal( Controlador c ) {

        this.setTitle("Meetto"); //Establecemos el titulo de la ventana 
        this.setSize( 900, 900 ); //Establecemos tamano de la ventana 
        //this.setResizable( false );
        this.setLocationRelativeTo( null ); //Establecemos la ventana en el centro de cualquier pantalla
        this.setDefaultCloseOperation( DO_NOTHING_ON_CLOSE ); //Se termina la ejecuacion del programa al presionar al tache

        contenedor = new JScrollPane();

        this.c = c;
        
        this.panelRI = new PanelPrincipalRI( c );
        this.panelRI.addPanelListener( this );
        
        this.panelD = new PanelPrincipalD( c );
        this.panelD.addPanelListener( this );

        this.panelW = new Panel_Wall( c );
        this.panelW.addPanelListener( this );

        this.panelA = new Panel_Amigo( c );
        this.panelA.addPanelListener( this );
        
        this.contenedor = new JScrollPane();
        contenedor.setViewportView( panelRI );
        this.add( contenedor );
    }

    @Override
    public void cambioPanel( Object ob ) {

        if( ob instanceof PanelPrincipalRI ) {

            c.getUsuariosRegistrados();
            this.panelD.reloadComponentes();
            contenedor.setViewportView( panelD );
            System.out.println("Cambio de panel");
        } else if( ob instanceof PanelPrincipalD ) {
            
            this.panelW.reloadComponentes();
            contenedor.setViewportView( panelW );
            System.out.println("Cambio de panel");
        } else if( ob instanceof Panel_Wall ) {

            this.panelD.reloadComponentes();
            contenedor.setViewportView( panelD );
            System.out.println("Cambio de panel");
        } else if( ob instanceof Panel_Amigo ) {

            this.panelW.reloadComponentes();
            contenedor.setViewportView( panelW );
            System.out.println("Cambio de panel");
        }
    }

    @Override
    public void cambioPanel( Object ob, String val ) {

        if( ob instanceof Panel_Wall ) {

            c.getUsuario( val );
            this.panelA.reloadComponentes();
            contenedor.setViewportView( panelA );
            System.out.println("Cambio de panel");
        } else if( ob instanceof Panel_Amigo ) {

            c.getUsuario( val );
            this.panelA.reloadComponentes();
            contenedor.setViewportView( panelA );
            System.out.println("Cambio de panel");
        }
    }
}