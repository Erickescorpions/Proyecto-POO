package meetto.ventana_grafica.muro; 

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;

import java.io.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.Image;
import  java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.BorderFactory;

import java.util.List;

import meetto.controlador.Controlador;
import meetto.ventana_grafica.PanelListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;
import javax.swing.JFileChooser;

public class Panel_Wall extends JPanel implements ActionListener, ListSelectionListener {

    Controlador c;
    public PanelListener pl;
    JFileChooser fc = new JFileChooser();

    public Panel_Wall( Controlador c ) {

        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setLayout( new BorderLayout( 10, 10 ) );
        this.setVisible( true );

        this.c = c;

        this.inicializarComponentes();
    }

    public void inicializarComponentes() {

        this.addComponentesSup();
        this.addComponentesCentrales();
        this.addComponentesInf();
        this.addComponentesLatWEST();
        this.addComponentesLatEAST();
    }

    private void addComponentesSup() {

        JPanel contenedor = new JPanel();
        contenedor.setBackground(Color.GREEN);
        JLabel titulo = new JLabel("Wall");
        contenedor.add( titulo );
        
        this.add( contenedor, BorderLayout.NORTH );
    }

    private void addComponentesInf() {

        JPanel panelInf = new JPanel();
        panelInf.setBackground( Color.DARK_GRAY );

        panelInf.setLayout( new FlowLayout() );

        JLabel etiqueta = new JLabel("@Copyright. Todos los derechos reservados. \"Proyecto POO\"");
        etiqueta.setForeground( Color.WHITE );

        panelInf.add( etiqueta );
        this.add( panelInf, BorderLayout.SOUTH );
    }

    JLabel imagenEtiqueta;

    private void ColocarFoto( String ruta ) {
        
        ImageIcon image = new ImageIcon( ruta );
        imagenEtiqueta.setIcon( new ImageIcon( image.getImage().getScaledInstance( 250, 250, Image.SCALE_SMOOTH ) ) ); 
        imagenEtiqueta.repaint();
    }

    JScrollPane contenedor_panel_publicaciones;
    JTextField caja_p;
    JButton publicar;
    JButton publicar_imagen;
    JPanel contenedor_publicaciones;

    private void addComponentesCentrales() {

        JPanel contenedor = new JPanel();
        contenedor.setBackground(Color.WHITE);
        contenedor.setLayout( new GridBagLayout() );

        contenedor_panel_publicaciones = new JScrollPane();
        contenedor_panel_publicaciones.setPreferredSize(new Dimension(300, 400));

        caja_p = new JTextField("Que estas pensando?");

        publicar_imagen = new JButton("Publicar Imagen");
        publicar = new JButton("Publicar");

        caja_p.setPreferredSize(new Dimension(300, 30));

        publicar_imagen.addActionListener( this );
        publicar.addActionListener( this );

        GridBagConstraints k = new GridBagConstraints();

        k.gridwidth = 2;
        k.weightx = 0;
        k.weighty = 0;

        k.gridx = 0;
        k.gridy = 0;
        contenedor.add( contenedor_panel_publicaciones, k );

        k.gridx = 0;
        k.gridy = 1;
        contenedor.add( caja_p, k );

        k.gridwidth = 1;
        k.gridx = 0;
        k.gridy = 2;
        contenedor.add( publicar_imagen, k );

        k.gridx = 1;
        k.gridy = 2;
        contenedor.add( publicar, k );

        this.add( contenedor, BorderLayout.CENTER );
    }

    public void addPublicaciones() {

        contenedor_publicaciones = new JPanel();
        contenedor_publicaciones.setLayout( new GridBagLayout() );
        contenedor_publicaciones.setBackground( Color.GREEN );
        contenedor_panel_publicaciones.setViewportView( contenedor_publicaciones );

        GridBagConstraints k = new GridBagConstraints();

        k.gridwidth = 2;
        k.weightx = 1;
        k.weighty = 0;
        k.gridx= 0;

        int i = 0;

        for( Publicaciones pub : this.c.u.publicaciones ) {
            
            k.gridy = i;

            contenedor_publicaciones.add( new JLabel( pub.d ), k );
            i++;

            if( !pub.amigo.equals("") ) {
                String publicador = pub.amigo + " -> " + pub.u; 
                contenedor_publicaciones.add( new JLabel( publicador ), k );
                i++;
                k.gridy = i;
            }

            k.gridy = i;
            if( new File( pub.p ).exists() ) {

                JLabel imagenEtiqueta = new JLabel();
                ImageIcon image = new ImageIcon( pub.p );
                imagenEtiqueta.setIcon( new ImageIcon( image.getImage().getScaledInstance( 250, 250, Image.SCALE_SMOOTH ) ) ); 
                imagenEtiqueta.repaint();
                contenedor_publicaciones.add( imagenEtiqueta, k );
            } else {

                contenedor_publicaciones.add( new JLabel( pub.p ), k );
            }

            i++;

            k.gridy = i;
            String sep = "--------------------------------------------";
            contenedor_publicaciones.add( new JLabel( sep ), k );
            i++;
        }
    }

    JLabel nombre;
    JButton perfil; 

    private void addComponentesLatWEST() {

        JPanel contenedor = new JPanel();
        contenedor.setLayout( new GridBagLayout() );
        contenedor.setBackground( Color.WHITE );
        contenedor.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 5 ) );

        nombre = new JLabel( c.u.getNombre() );
        imagenEtiqueta = new JLabel();
        imagenEtiqueta.setBorder( BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
        
        perfil = new JButton("Perfil");

        perfil.addActionListener( this );
        perfil.setPreferredSize(new Dimension(200, 30));   

        GridBagConstraints k = new GridBagConstraints();

        k.gridwidth = 1;
        k.weightx = 0;
        k.weighty = 0;

        k.gridx = 0;
        k.gridy = 0;
        contenedor.add( nombre, k );

        k.gridx = 0;
        k.gridy = 1;        
        contenedor.add( imagenEtiqueta, k );        

        k.gridx = 0;
        k.gridy = 2;        
        contenedor.add( perfil, k );

        this.add( contenedor, BorderLayout.WEST );
    }

    JScrollPane amigos;
    JButton botonAmigo;
    String val;

    private void addComponentesLatEAST() {

        JPanel contenedor = new JPanel();
        contenedor.setLayout( new GridBagLayout() );
        contenedor.setBackground(Color.WHITE);
        contenedor.setBorder( BorderFactory.createEmptyBorder( 10, 5, 10, 10 ) );

        JLabel etiquetaT = new JLabel( "Amigos" );
        
        amigos = new JScrollPane();

        amigos.setPreferredSize(new Dimension(200, 200));  

        botonAmigo = new JButton("Ir al perfil de ... ");
        botonAmigo.addActionListener( this );

        GridBagConstraints k = new GridBagConstraints();

        k.gridwidth = 1;
        k.weightx = 0;
        k.weighty = 0;

        k.gridx = 0;
        k.gridy = 0;
        contenedor.add( etiquetaT, k );

        k.gridx = 0;
        k.gridy = 1;        
        contenedor.add( amigos, k );

        k.gridx = 0;
        k.gridy = 2;
        contenedor.add( botonAmigo, k );

        this.add( contenedor, BorderLayout.EAST );
    }

    JList<String> list;

    public void addAmigos() {

        String[] nombres_usuarios = this.c.getNombresUsuariosRegistrados();

        list = new JList<String>( nombres_usuarios );

        list.addListSelectionListener( this );

        amigos.setViewportView( list );
    }

    public void reloadComponentes() {

        nombre.setText( c.u.getNombre() );
        ColocarFoto( c.u.getImagen() );
        addAmigos();
        botonAmigo.setText("Ir al perfil de ... ");
        addPublicaciones();
    }   

    public void addPanelListener( PanelListener l ) {

        this.pl = l;
    }

    @Override
    public void actionPerformed( ActionEvent ae ) {

        if( ae.getSource() == perfil ) {

            this.pl.cambioPanel( this );
        } else if( ae.getSource() == botonAmigo ) {

            String aux = botonAmigo.getText();
            if( !aux.equals("Ir al perfil de ... ") ) {
                this.pl.cambioPanel( this, val );
            }
        } else if( ae.getSource() == publicar ) {

            String aux = caja_p.getText();
            if( !aux.equals("Que estas pensando?") ) {

                this.c.u.publicaciones.add( new Publicaciones( this.c.u.getNombre(), aux ) );
                addPublicaciones();
            }

        } else if( ae.getSource() == publicar_imagen ) {
            
            int seleccion = fc.showOpenDialog( this );
            if( seleccion == JFileChooser.APPROVE_OPTION ) {

                File f = fc.getSelectedFile();
                String ruta = f.getAbsolutePath();
                this.c.u.publicaciones.add( new Publicaciones( this.c.u.getNombre(), ruta ) );
                addPublicaciones();
            }
        }
    }

    @Override
    public void valueChanged( ListSelectionEvent e ) {

        this.val = list.getSelectedValue();
        botonAmigo.setText("Ir a perfil de " + val );
    }
}
