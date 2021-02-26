package clases.ventana_grafica.registro_ingreso;

import clases.controlador.Controlador;
import clases.ventana_grafica.PanelListener;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.Box;
import java.awt.FlowLayout;

import  java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;

import java.lang.Thread; 

public class PanelPrincipalRI extends JPanel implements ActionListener, OperacionListener {
    
    boolean task_terminado = false;

    PanelRegistro panelRegistro;
    PanelIngreso panelIngreso;
    
    JButton BotonRegistro;
    JButton BotonIngreso;

    JScrollPane contenedorCentral;
    
    PanelListener pl;

    Controlador c;

    public PanelPrincipalRI( Controlador c ) {
        
        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setLayout( new BorderLayout( 10, 10 ) );
    
        this.contenedorCentral = new JScrollPane();

        this.c = c;

        this.panelRegistro = new PanelRegistro( c );
        this.panelIngreso = new PanelIngreso( c );

        this.panelRegistro.addOperacionListener( this );
        this.panelIngreso.addOperacionListener( this );

        contenedorCentral.setViewportView( panelIngreso );

        BotonesSup();
        PanelInf();

        this.add( contenedorCentral, BorderLayout.CENTER );
    }

    private void PanelInf() {

        JPanel panelInf = new JPanel();
        panelInf.setBackground( Color.DARK_GRAY );

        panelInf.setLayout( new FlowLayout() );

        JLabel etiqueta = new JLabel("@Copyright. Todos los derechos reservados. \"Proyecto POO\"");
        etiqueta.setForeground( Color.WHITE );

        panelInf.add( etiqueta );
        this.add( panelInf, BorderLayout.SOUTH );
    }

    private void BotonesSup() {

        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setBackground( Color.GREEN );

        BotonRegistro = new JButton("Registrarse");
        BotonIngreso = new JButton("Ingresar");

        contenedorBotones.add( BotonRegistro );

        contenedorBotones.add( new Box.Filler( new Dimension( 5, 50 ), new Dimension( 5, 50 ), 
                                new Dimension( 5, 50 ) ) );

        contenedorBotones.add( BotonIngreso );

        BotonRegistro.addActionListener( this );
        BotonIngreso.addActionListener( this );

        this.add( contenedorBotones,  BorderLayout.NORTH );
    }

    private void defPanel( PanelRegistro panel ) {

        contenedorCentral.setViewportView( panel );
    }

    private void defPanel( PanelIngreso panel ) {

        contenedorCentral.setViewportView( panel );
    }

    public void addPanelListener( PanelListener l ) {

        this.pl = l;
    }
    
    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonRegistro ) {
            
            //panelRegistro.setVisible( true );
            defPanel( panelRegistro );
            
        } if( ae.getSource() == BotonIngreso ) {

            //panelIngreso.setVisible( true );
            defPanel( panelIngreso );
        }
    }

    @Override
    public void operacionExitosa( boolean arg ) {

        if( arg ) {

            this.setVisible( false );
            System.out.println("Operacion exitosa");
            pl.cambioPanel( this );
        }
    }
}