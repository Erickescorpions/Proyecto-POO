package clases.ventana_grafica.registro_ingreso;

import clases.controlador.Controlador;
import clases.usuarios.Usuario;
//Interfacex graficas
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import  java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistro extends JPanel implements ActionListener {

    boolean task_terminado = false;

    JButton BotonRegistro;
    JButton BotonRegreso;

    JTextField CajaNombre;
    JTextField CajaEdad;
    JTextField CajaEmail; 
    JTextField CajaPassword;
    JTextField CajaRepPassword;

    JLabel etiquetaMensaje;

    OperacionListener op;

    Controlador c;

    public PanelRegistro( Controlador c ) {

        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setVisible( true );
        this.setLayout( new GridBagLayout() );
        this.addComponentes();

        this.c = c;
    }

    private void addComponentes() {

        JLabel etiquetaNombre = new JLabel("Nombre(s)");
        CajaNombre = new JTextField(50);

        JLabel etiquetaEdad = new JLabel("Edad");
        CajaEdad = new JTextField(50);

        JLabel etiquetaEmail = new JLabel("Email");
        CajaEmail = new JTextField(50);

        JLabel etiquetaPassword = new JLabel("Contraseña");
        CajaPassword = new JTextField(50);

        JLabel etiquetaRepPassword = new JLabel( "Confirma tu contraseña" );
        CajaRepPassword = new JTextField(50);

        etiquetaMensaje = new JLabel();

        BotonRegistro = new JButton("Registrarse");
        BotonRegistro.setPreferredSize(new Dimension(200, 30));
        BotonRegistro.addActionListener( this );

        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;

        c.gridx = 0;
        c.gridy = 0;        
        this.add( etiquetaNombre, c );

        c.gridx = 1;
        c.gridy = 0;
        this.add( CajaNombre, c );

        c.gridx = 0;
        c.gridy = 1;
        this.add( etiquetaEdad, c );

        c.gridx = 1;
        c.gridy = 1;
        this.add( CajaEdad, c );

        c.gridx = 0;
        c.gridy = 2;
        this.add( etiquetaEmail, c);
        
        c.gridx = 1;
        c.gridy = 2;
        this.add( CajaEmail, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add( etiquetaPassword, c);

        c.gridx = 1;
        c.gridy = 3;
        this.add( CajaPassword, c);

        c.gridx = 0;
        c.gridy = 4;
        this.add( etiquetaRepPassword, c);

        c.gridx = 1;
        c.gridy = 4;
        this.add( CajaRepPassword, c);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 5;
        this.add( etiquetaMensaje, c );

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 6;
        this.add( BotonRegistro, c );
    }

    public void addOperacionListener( OperacionListener l ) {

        this.op = l; 
    }

    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonRegistro ) {
            
            Object ob = c.Registro( CajaNombre.getText(), Integer.parseInt( CajaEdad.getText() ), 
            CajaEmail.getText(), CajaPassword.getText(), CajaRepPassword.getText() );

            if( ob instanceof Usuario ) {

                CajaNombre.setText( null );
                CajaEdad.setText( null );
                CajaEmail.setText( null );
                CajaPassword.setText( null );
                CajaRepPassword.setText( null );

                this.setVisible( false ); 
                this.task_terminado = true;
                this.op.operacionExitosa( task_terminado );
            } else if( ob instanceof String ) {

                String text = (String) ob;
                etiquetaMensaje.setText( text );
            }
        }
    }
}
