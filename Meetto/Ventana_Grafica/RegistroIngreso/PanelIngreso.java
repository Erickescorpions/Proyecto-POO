package meetto.ventana_grafica.registro_ingreso;

import meetto.controlador.Controlador;
import meetto.usuarios.Usuario;

//Interfacex graficas
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIngreso extends JPanel implements ActionListener {
    
    boolean task_terminado = false;

    JButton BotonIngreso;
    JButton BotonRegreso;

    JTextField CajaEmail; 
    JTextField CajaPassword;
    JLabel etiquetaMensaje;

    OperacionListener op;

    Controlador c;

    public PanelIngreso( Controlador c ) {

        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setVisible( true );
        this.setLayout( new GridBagLayout() );

        this.addComponentes();

        this.c = c;
    }

    private void addComponentes() {

        JLabel etiquetaEmail = new JLabel("Correo");
        CajaEmail = new JTextField( 50 );

        JLabel etiquetaPassword = new JLabel("Contraseña");
        CajaPassword = new JTextField( 50 );

        etiquetaMensaje = new JLabel();

        BotonIngreso = new JButton("Ingresar");
        BotonIngreso.setPreferredSize(new Dimension(200, 30));
        
        BotonIngreso.addActionListener( this );

        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;

        c.gridx = 0;
        c.gridy = 0;        
        this.add( etiquetaEmail, c );

        c.gridx = 1;
        c.gridy = 0;
        this.add( CajaEmail, c );

        c.gridx = 0;
        c.gridy = 1;
        this.add( etiquetaPassword, c );

        c.gridx = 1;
        c.gridy = 1;
        this.add( CajaPassword, c );

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        this.add( etiquetaMensaje, c);

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        this.add( BotonIngreso, c);
    }

    public void addOperacionListener( OperacionListener l ) {

        this.op = l; 
    }

    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonIngreso ) {
            
            Object ob = c.Ingreso( CajaEmail.getText(), CajaPassword.getText());

            if( ob instanceof Usuario ) {

                CajaEmail.setText( null );
                CajaPassword.setText( null );
                etiquetaMensaje.setText( null );

                this.setVisible( false );
                this.task_terminado = true;
                this.op.operacionExitosa( task_terminado );
            } else if( ob instanceof String ) {

                String text = ( String ) ob;
                etiquetaMensaje.setText( text );
            }

        } 
    }
}
