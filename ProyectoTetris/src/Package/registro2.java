package Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import login_ragister_design.My_CNX;
import login_ragister_design.Register_Form;

import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class registro2 {

	protected static final Statement My_CNX = null;
	private JFrame frame;
	private JPasswordField passwordField_2;
	private JTextField textField_Usuario;
	private JTextField textField_email;
	private JTextField textField_Nombre;
	private JTextField textField_Apelido;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro2 window = new registro2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registro2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(230, 224, 105, 22);
		frame.getContentPane().add(passwordField_2);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(94, 115, 56, 16);
		frame.getContentPane().add(lblUsuario);
		
		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(193, 112, 116, 22);
		frame.getContentPane().add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(94, 288, 56, 16);
		frame.getContentPane().add(lblFecha);
		
		JComboBox comboBox_dia = new JComboBox();
		comboBox_dia.setBounds(193, 285, 31, 22);
		frame.getContentPane().add(comboBox_dia);
		
		JComboBox comboBox_mes = new JComboBox();
		comboBox_mes.setBounds(236, 285, 31, 22);
		frame.getContentPane().add(comboBox_mes);
		
		JComboBox comboBox_anio = new JComboBox();
		comboBox_anio.setBounds(278, 285, 31, 22);
		frame.getContentPane().add(comboBox_anio);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(94, 259, 56, 16);
		frame.getContentPane().add(lblEmail);
		
		textField_email = new JTextField();
		textField_email.setBounds(193, 250, 116, 22);
		frame.getContentPane().add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(94, 48, 56, 16);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(94, 83, 56, 16);
		frame.getContentPane().add(lblApellido);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(193, 45, 116, 22);
		frame.getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		textField_Apelido = new JTextField();
		textField_Apelido.setBounds(193, 80, 116, 22);
		frame.getContentPane().add(textField_Apelido);
		textField_Apelido.setColumns(10);
		
		
		
		
		
		
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String fname = textField_Nombre.getText();
				 String fapellido = textField_Apelido.getText();
		         String username = textField_Usuario.getText();
		         String pass1 = String.valueOf(passwordField_1.getPassword());
		         String pass2 = String.valueOf(passwordField_2.getPassword());
		         
		        
		        
		         if(verifyFields())
		         {
		             if(!checkUsername(username))
		             {
		                 PreparedStatement ps;
		                 ResultSet rs;
		                 String registerUserQuery = "INSERT INTO `users`(`full_name`, `username`, `password`, `phone`, `gender`, `picture`) VALUES (?,?,?,?,?,?)";
		                 
		                 try {
		                     
		                     ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
		                     ps.setString(1, fname);
		                     ps.setString(2, fapellido);
		                     ps.setString(3, username);
		                     ps.setString(4, pass1);
		                     ps.setString(5, pass2);
		                     
		                     
		                     try {
		                         
		              
		                         
		                         if(ps.executeUpdate() != 0){
		                             JOptionPane.showMessageDialog(null, "Your Account Has Been Created");
		                         }else{
		                             JOptionPane.showMessageDialog(null, "Error: Check Your Information");
		                         }
		                         
		                     } catch (FileNotFoundException ex) {
		                         Logger.getLogger(registro2.class.getName()).log(Level.SEVERE, null, ex);
		                     }
		                     
		                 } catch (SQLException ex) {
		                     Logger.getLogger(registro2.class.getName()).log(Level.SEVERE, null, ex);
		                 }
		                 
		             }
		         }
				
			}
		});
		btnRegistrarse.setBounds(332, 284, 97, 25);
		frame.getContentPane().add(btnRegistrarse);
		
		JLabel lblConfirmarContrasena = new JLabel("Confirmar contrasena");
		lblConfirmarContrasena.setBounds(94, 224, 124, 22);
		frame.getContentPane().add(lblConfirmarContrasena);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setBounds(94, 195, 90, 16);
		frame.getContentPane().add(lblContrasena);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(212, 192, 90, 22);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnX.setBounds(437, 13, 41, 25);
		frame.getContentPane().add(btnX);
	}
}
