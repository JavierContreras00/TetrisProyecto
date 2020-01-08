

package Package;



import java.awt.EventQueue;



import javax.swing.JFrame;

import javax.swing.JTextField;







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

import java.awt.Font;

import java.awt.Panel;

import java.awt.Color;



public class Registro{



	protected static final Statement My_CNX = null;

	private JFrame frame;

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

					Registro window = new Registro();

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

	



	/**

	 * Initialize the contents of the frame.

	 */

	private void initialize() {

		frame = new JFrame();

		frame.setBounds(100, 100, 508, 364);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		

		JLabel lblUsuario = new JLabel("Usuario:");

		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblUsuario.setBounds(94, 166, 56, 16);

		frame.getContentPane().add(lblUsuario);

		

		textField_Usuario = new JTextField();

		textField_Usuario.setBounds(193, 163, 116, 22);

		frame.getContentPane().add(textField_Usuario);

		textField_Usuario.setColumns(10);

		

		JLabel lblFecha = new JLabel("Fecha:");

		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblFecha.setBounds(94, 262, 56, 16);

		frame.getContentPane().add(lblFecha);

		

		JComboBox comboBox_dia = new JComboBox();

		comboBox_dia.setEditable(true);

		comboBox_dia.setSelectedIndex(1);

		comboBox_dia.setBounds(193, 262, 31, 22);

		frame.getContentPane().add(comboBox_dia);

		

		JComboBox comboBox_mes = new JComboBox();

		comboBox_mes.setEditable(true);

		comboBox_mes.setBounds(236, 262, 31, 22);

		frame.getContentPane().add(comboBox_mes);

		

		JComboBox comboBox_anio = new JComboBox();

		comboBox_anio.setEditable(true);

		comboBox_anio.setBounds(278, 262, 31, 22);

		frame.getContentPane().add(comboBox_anio);

		

		JLabel lblEmail = new JLabel("Email:");

		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblEmail.setBounds(94, 230, 56, 16);

		frame.getContentPane().add(lblEmail);

		

		textField_email = new JTextField();

		textField_email.setBounds(193, 233, 116, 22);

		frame.getContentPane().add(textField_email);

		textField_email.setColumns(10);

		

		JLabel lblNombre = new JLabel("Nombre:");

		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNombre.setBounds(94, 96, 56, 16);

		frame.getContentPane().add(lblNombre);

		

		JLabel lblApellido = new JLabel("Apellido:");

		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblApellido.setBounds(94, 131, 56, 16);

		frame.getContentPane().add(lblApellido);

		

		textField_Nombre = new JTextField();

		textField_Nombre.setBounds(193, 93, 116, 22);

		frame.getContentPane().add(textField_Nombre);

		textField_Nombre.setColumns(10);

		

		textField_Apelido = new JTextField();

		textField_Apelido.setBounds(193, 128, 116, 22);

		frame.getContentPane().add(textField_Apelido);

		textField_Apelido.setColumns(10);

		

		

		

		

		

		

		

		JButton btnRegistrarse = new JButton("Registrarse");

		btnRegistrarse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				 String fname = textField_Nombre.getText();

				 String fapellido = textField_Apelido.getText();

		         String username = textField_Usuario.getText();

		         String pass1 = String.valueOf(passwordField_1.getPassword());

		         String email = textField_email.getText();

		         
			}
			}

			
		        

		        
/*
		      if(verifica())

		         {

		             if(!comprobarUsuario(username))

		             {

		                 PreparedStatement ps;

		                 ResultSet rs;

		                 String registerUserQuery = "INSERT INTO `users`(`idUsuario`, `nombreUsuario`, `email`, `nombre`, `apellido`, `fechaNac`, `contrasenia`) VALUES (?,?,?,?,?,?,?)";

		                 

		                 try {

		                     

		                     ps = My_CNX.getConnection().prepareStatement(registerUserQuery);

		                     ps.setString(1, idUsuario);

		                     ps.setString(2, fname);

		                     ps.setString(3, fapellido);

		                     ps.setString(4, username);

		                     ps.setString(5, pass1);

		                     ps.setString(6, fname);

		                     ps.setString(7, email);





		                     

		                     if(ps.executeUpdate() != 0){

							     JOptionPane.showMessageDialog(null, "Tu cuenta se ha creado");

							 }else{

							     JOptionPane.showMessageDialog(null, "Error al crear la cuenta");

							 }

		                     

		                 } catch (SQLException ex) {

		                     Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);

		                 }

		                 

		             }

		         }

				

			}

			

			 public boolean verifica()

			    {

				 String fname = textField_Nombre.getText();

				 String fapellido = textField_Apelido.getText();

		         String username = textField_Usuario.getText();

		         String pass1 = String.valueOf(passwordField_1.getPassword());

		         

			        

			        if(fname.trim().equals("") || fapellido.trim().equals("") || username.trim().equals("")

			           || pass1.trim().equals("") )

			        {

			            JOptionPane.showMessageDialog(null, "Uno o mas campos estan vacios",null, 2);

			            return false;

			        }

			        else{

			            return true;

			        }

			    }

			    

			    

			    public boolean comprobarUsuario(String username){

			        

			        PreparedStatement st;

			        ResultSet rs;

			        boolean username_exist = false;

			        

			        String query = "SELECT * FROM `usuario` WHERE `nombreUsuario` = ?";

			        

			        try {

			            

			            st = My_CNX.getConnection().prepareStatement(query);

			            st.setString(1, username);

			            rs = st.executeQuery();

			        

			            if(rs.next())

			            {

			                username_exist = true;

			                JOptionPane.showMessageDialog(null, "Ya existe este usuario, por favor elige otro", "Fallo de usuario", 2);

			            }

			            

			        } catch (SQLException ex) {

			            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);

			        }        

			        return username_exist;

			    }*/

		);

		
		
		

		

		

		

		

		btnRegistrarse.setBounds(334, 258, 97, 25);

		frame.getContentPane().add(btnRegistrarse);

		

		JLabel lblContrasena = new JLabel("Contrasena:");

		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblContrasena.setBounds(94, 201, 90, 16);

		frame.getContentPane().add(lblContrasena);

		

		passwordField_1 = new JPasswordField();

		passwordField_1.setBounds(193, 198, 116, 22);

		frame.getContentPane().add(passwordField_1);

		

		Panel panel = new Panel();

		panel.setBackground(Color.YELLOW);

		panel.setBounds(167, 0, 116, 51);

		frame.getContentPane().add(panel);

		

		JLabel lblRegistro = new JLabel("REGISTRO");

		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 17));

		panel.add(lblRegistro);

		

		Panel panel_1 = new Panel();

		panel_1.setBackground(Color.GRAY);

		panel_1.setBounds(0, 0, 490, 51);

		frame.getContentPane().add(panel_1);

	}
	}
