package Package;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;


public class LogIn extends JFrame {



	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField jpassclave;
	private JButton btnIngresar;



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static void conectar() {
		
	try {
		Class.forName("org.sqlite.JDBC");
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:data/bdtetris.db");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT nombre, contraseņa FROM usuarios");
	   
		while(rs.next()) {
			String nombre = rs.getString("nombre");
			String contrasenya = rs.getString("contraseņa");

			System.out.println("Nombre;" + nombre + "Contraseņa" + contrasenya);
		}
	         stmt.close();
	         conn.close();

	    } catch (ClassNotFoundException e) {
	         System.out.println("No se ha podido cargar el driver");
	    } catch (SQLException e) {
	         System.out.println("No se ha podido cargar la BD");
	    }
	}

	public LogIn() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 238);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(172, 13, 56, 16);
		contentPane.add(lblLogin);

		

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(44, 76, 56, 16);
		contentPane.add(lblUsuario);

		

		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasena.setBounds(44, 116, 90, 16);
		contentPane.add(lblContrasena);

		

		txtusuario = new JTextField();
		txtusuario.setBounds(139, 76, 116, 16);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);

		

		jpassclave = new JPasswordField();
		jpassclave.setBounds(139, 115, 116, 18);
		contentPane.add(jpassclave);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(267, 76, 116, 16);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre; 
				String contrasenya; 
				
				nombre = txtusuario.getText();
				contrasenya = jpassclave.getText();
				
				try {
					
					if (nombre.equals("") || contrasenya.equals("") ) {
						JOptionPane.showMessageDialog(null, "Alguno de los valores estan vacios");
					} else {
						
						Class.forName("org.sqlite.JDBC");
						
						Connection conn = DriverManager.getConnection("jdbc:sqlite:data/bdtetris.db");
						Statement stmt = conn.createStatement();
						
						String query = "INSERT INTO  usuarios (nombre, contraseņa) VALUES ('" + nombre + "', '" + contrasenya + "')";
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Correcto", 1); 

					  
					         stmt.close();
					         conn.close();
					         
					         ventanaPrincipal p = new ventanaPrincipal(); 
								p.setVisible(true);
								LogIn.this.dispose();
				
						JOptionPane.showMessageDialog(null, "Direccion de correo no valida", "Error", 0); 
					}	
			      }
		     catch (ClassNotFoundException e2) {
					 System.out.println("No se ha podido cargar el driver");
		   } catch (SQLException e2) {
			         System.out.println("No se ha podido cargar la BD");
		   }
				
			}
			
		});
		
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(267, 112, 116, 25);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ventanaRegistro r = new ventanaRegistro();
				r.setVisible(true);
				LogIn.this.dispose();
				
			}
			
		});
		

		

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			char[] clave = jpassclave.getPassword();
				String claveFinal = new String (clave);

				if(txtusuario.getText().equals("Javier") && claveFinal.equals("123") ) { 
			dispose();
			JOptionPane.showMessageDialog(null, "Disfruta de la partida","Ingresaste",JOptionPane.INFORMATION_MESSAGE);
			LogIn p = new LogIn();

      p.setVisible(true);

				}else {

      JOptionPane.showMessageDialog ( null, "Usuario o contrasena incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
      
      txtusuario.setText(" ");
      jpassclave.setText(" ");
      txtusuario.requestFocus();

      
 //prueba

				}

		 {

		btnIngresar.setBounds(288, 72, 97, 25);
		contentPane.add(btnIngresar);
		
		JTextPane txtpnAunNoTienes = new JTextPane();
		txtpnAunNoTienes.setText("Aun no tienes cuenta? Registrate aqui");
		txtpnAunNoTienes.setBounds(44, 156, 211, 22);
		contentPane.add(txtpnAunNoTienes);

	}

		} 
		});
	}
	}
