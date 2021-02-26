package clases.ventana_grafica.datos_personales;

import clases.usuarios.Usuario;
import clases.usuarios.sistema_ri.Sistema;
import clases.ventana_grafica.PanelListener;
import clases.controlador.Controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.Image;
import  java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.BorderFactory;

import javax.swing.JFileChooser;
import java.io.File;

public class PanelPrincipalD extends JPanel implements ActionListener {
    
    JButton cambioImagen;
    JButton siguiente;
    JButton cambiarNombre;
    JButton cambiarContrasena;
    JButton cambiar;

    JLabel etiquetaMensaje;

    JLabel imagenEtiqueta;

    JFileChooser fc = new JFileChooser();

    JTextField Caja_1;
    JTextField Caja_2;

    Controlador c;
    PanelListener pl;

    public PanelPrincipalD( Controlador c ) {
        
        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setLayout( new BorderLayout( 10, 10 ) );
        //this.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

        this.c = c;

        addComponentesSup();

        addComponentesCentrales();

        addComponentesInf();
    }

    private void addComponentesSup() {

        JPanel panelsup = new JPanel();
        panelsup.setBackground( Color.GREEN );

        JLabel etiquetaTitulo = new JLabel("Datos de Usuario");
        
        panelsup.add( etiquetaTitulo );

        this.add( panelsup, BorderLayout.NORTH );
    }

    JPanel panelcentral;
    JLabel nombre;
    JLabel edad;
    JLabel email;
    JLabel contrasena;

    private void addComponentesCentrales() {

        panelcentral = new JPanel();
        panelcentral.setBackground( Color.WHITE );
        panelcentral.setLayout( new GridBagLayout() );

        imagenEtiqueta = new JLabel();
        ColocarFoto( "Meetto/Imagenes/anonimo.png" );

        cambioImagen = new JButton("Cambiar imagen");

        nombre = new JLabel("Nombre de Usuario: " + c.u.getNombre() );

        cambiarNombre = new JButton("Cambiar Nombre");

        edad = new JLabel("Edad: " + c.u.getEdad() );

        email = new JLabel("Email: " + c.u.getEmail() );

        String aux = "";
        for( int i = 0; i < c.u.getPassword().length(); i++ ) aux += "*";
        contrasena = new JLabel("Contraseña: " + aux );

        cambiarContrasena = new JButton("Cambiar Contraseña");

        Caja_1 = new JTextField( 50 );
        Caja_1.setEnabled( false );

        Caja_2 = new JTextField( 50 );
        Caja_2.setEnabled( false );

        etiquetaMensaje = new JLabel("---");
        cambiar = new JButton("Cambiar");

        cambioImagen.addActionListener( this );
        cambiar.addActionListener( this );
        cambiarNombre.addActionListener(this);
        cambiarContrasena.addActionListener(this);
        
        cambioImagen.setPreferredSize(new Dimension(200, 30));
        cambiar.setPreferredSize(new Dimension(200, 30));
        cambiarNombre.setPreferredSize(new Dimension(200, 30));
        cambiarContrasena.setPreferredSize(new Dimension(200, 30));

        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;

        c.gridx = 0;
        c.gridy = 0;        
        panelcentral.add( imagenEtiqueta, c );

        c.gridx = 0;
        c.gridy = 1;
        panelcentral.add( cambioImagen, c );

        c.gridx = 0;
        c.gridy = 2;
        panelcentral.add( nombre, c );

        c.gridx = 0;
        c.gridy = 3;
        panelcentral.add( edad, c );

        c.gridx = 0;
        c.gridy = 4;
        panelcentral.add( email, c );
        
        c.gridx = 0;
        c.gridy = 5;
        panelcentral.add( contrasena, c );

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 6;
        panelcentral.add( cambiarNombre, c );

        c.gridx = 1;
        c.gridy = 6;
        panelcentral.add( cambiarContrasena, c );

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 7;
        panelcentral.add( Caja_1, c );

        c.gridx = 0;
        c.gridy = 8;
        panelcentral.add( Caja_2, c );

        c.gridx = 0;
        c.gridy = 9;
        panelcentral.add( etiquetaMensaje, c );

        c.gridx = 0;
        c.gridy = 10;
        panelcentral.add( cambiar, c );

        this.add( panelcentral, BorderLayout.CENTER );
    }

    private void ColocarFoto( String ruta ) {
        
        ImageIcon image = new ImageIcon( ruta );
        imagenEtiqueta.setIcon( new ImageIcon( image.getImage().getScaledInstance( 250, 250, Image.SCALE_SMOOTH ) ) ); 
        imagenEtiqueta.repaint();
    }

    private void addComponentesInf() {

        JPanel contenedorInf = new JPanel();
        contenedorInf.setBackground( Color.DARK_GRAY );
        
        siguiente = new JButton("Siguiente");
        contenedorInf.add( siguiente );
        siguiente.addActionListener( this );

        this.add( contenedorInf, BorderLayout.SOUTH );
    }

    public void reloadComponentes() {

        nombre.setText("Nombre de Usuario: " + c.u.getNombre() );
        edad.setText("Edad: " + c.u.getEdad());
        email.setText("Email: " + c.u.getEmail());
        String aux = "";
        for( int i = 0; i < c.u.getPassword().length(); i++ ) aux += "*";
        contrasena.setText("Contrasena: " + aux );
        System.out.println(c.u.getImagen() );
        ColocarFoto( c.u.getImagen() );
    }   

    public void addPanelListener( PanelListener l ) {

        this.pl = l;
    }

    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == siguiente ) {

            this.pl.cambioPanel( this );
        } else if( ae.getSource() == cambioImagen ) {

            int seleccion = fc.showOpenDialog( this );
            if( seleccion == JFileChooser.APPROVE_OPTION ) {

                File f = fc.getSelectedFile();
                String ruta = c.CambiarFoto( f );
                this.ColocarFoto( ruta );
            }
        } else if( ae.getSource() == cambiarNombre ) {
            
            Caja_1.setEnabled( true );
            Caja_2.setEnabled( false );
            Caja_1.setText("  Ingresa tu nuevo nombre");
            Caja_2.setText("");
            cambiar.setVisible( true );
        } else if( ae.getSource() == cambiarContrasena ) {

            Caja_1.setEnabled( true );
            Caja_2.setEnabled( true );
            Caja_1.setText("  Ingresa tu nueva contraseña");
            Caja_2.setText("  Confirma tu contraseña");
            cambiar.setVisible( true );

        } else if( ae.getSource() == cambiar ) {

            etiquetaMensaje.setText( c.CambiarDato( Caja_1.getText(), Caja_2.getText() ) );
            Caja_1.setText(null);
            Caja_2.setText(null);
            this.reloadComponentes();
        }
    }
}
