package Package;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class ventanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCorreo;
	private JPasswordField passwordContrasenya;
	private JTextField textContrasenya;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaRegistro frame = new ventanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean mostrar = true; 
	public static ButtonGroup Sexo = new ButtonGroup();
	
	public ventanaRegistro() {
		setTitle("Registrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 23, 59, 13);
		contentPane.add(lblNombre);
		
		JLabel lblContraseanya = new JLabel("Contrase\u00F1a:");
		lblContraseanya.setBounds(10, 63, 69, 13);
		contentPane.add(lblContraseanya);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 103, 46, 13);
		contentPane.add(lblCorreo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 143, 46, 13);
		contentPane.add(lblSexo);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 183, 46, 13);
		contentPane.add(lblEdad);
		
		
		JButton btnResgistrarse = new JButton("Resgistrarse");
		btnResgistrarse.setBounds(91, 232, 124, 21);
		contentPane.add(btnResgistrarse);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(225, 232, 125, 21);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		
		textNombre = new JTextField();
		textNombre.setBounds(89, 20, 311, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JCheckBox chckbxMostrar = new JCheckBox("Mostrar");
		chckbxMostrar.setBounds(341, 59, 95, 21);
		contentPane.add(chckbxMostrar);
		chckbxMostrar.setVisible(true);
		chckbxMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (mostrar) {
					textContrasenya.setVisible(true);
					passwordContrasenya.setVisible(false);
					textContrasenya.setText(passwordContrasenya.getText());
					mostrar = false; 
				} else {
					textContrasenya.setVisible(false);
					passwordContrasenya.setVisible(true);
					textContrasenya.setText(textContrasenya.getText());
					mostrar = true; 
				}	
			}
		});
		
		
		textCorreo = new JTextField();
		textCorreo.setBounds(89, 100, 311, 19);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		JComboBox comboBoxEdad = new JComboBox();
		comboBoxEdad.setModel(new DefaultComboBoxModel(new String[] {"3-12", "12-18", "18-32", ">32"}));
		comboBoxEdad.setBounds(89, 179, 59, 21);
		contentPane.add(comboBoxEdad);
		
		passwordContrasenya = new JPasswordField();
		passwordContrasenya.setBounds(89, 60, 235, 19);
		contentPane.add(passwordContrasenya);
		
		textContrasenya = new JTextField();
		textContrasenya.setBounds(89, 60, 235, 19);
		contentPane.add(textContrasenya);
		textContrasenya.setColumns(10);
		
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		Sexo.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(91, 139, 91, 21);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		Sexo.add(rdbtnFemenino);
		rdbtnFemenino.setBounds(184, 139, 93, 21);
		contentPane.add(rdbtnFemenino);
		
		JRadioButton rdbtnOtro = new JRadioButton("Otro");
		Sexo.add(rdbtnOtro);
		rdbtnOtro.setBounds(279, 139, 71, 21);
		contentPane.add(rdbtnOtro);  
		
		///Corregir BD No se conecta al driver
		
		btnResgistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombre; 
				String contrasenya; 
				String correo; 
				String sexo; 
				String edad; 
				
				nombre = textNombre.getText();
				contrasenya = passwordContrasenya.getText();
				correo = textCorreo.getText();
				sexo = JRadioButton.getDefaultLocale().toString(); 
			    edad= comboBoxEdad.getSelectedItem().toString(); 
				
				try {
					
					if (nombre.equals("") || contrasenya.equals("") || correo.equals("")) {
						JOptionPane.showMessageDialog(null, "Alguno de los valores estan vacios");
					} else {
						
						if (correo.contains("@") && correo.contains(".")); {
						
						Class.forName("org.sqlite.JDBC");
						
						Connection conn = DriverManager.getConnection("jdbc:sqlite:data/bdtetris.db");
						Statement stmt = conn.createStatement();
						
						String query = "INSERT INTO  usuarios (nombre, contraseña, correo, sexo, edad) VALUES ('" + nombre + "', '" + contrasenya + "', '" + correo + "', '" + sexo + "', '" + edad + "')";
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Correcto", 1); 

					  
					         stmt.close();
					         conn.close();
					         
					         ventanaPrincipal p = new ventanaPrincipal(); 
								p.setVisible(true);
								ventanaRegistro.this.dispose();
				
						JOptionPane.showMessageDialog(null, "Direccion de correo no valida", "Error", 0); 
					}	
			      }
			} catch (ClassNotFoundException e1) {
					 System.out.println("No se ha podido cargar el driver");
		   } catch (SQLException e1) {
			         System.out.println("No se ha podido cargar la BD");
		   }
		
		} 
});
		
	}
}
