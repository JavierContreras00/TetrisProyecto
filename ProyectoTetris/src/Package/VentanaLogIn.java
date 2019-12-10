package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;

public class VentanaLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogIn frame = new VentanaLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public VentanaLogIn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tetrix", "root", "deusto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(148, 140, 116, 22);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);

		tfContrasenia = new JTextField();
		tfContrasenia.setBounds(148, 169, 116, 22);
		contentPane.add(tfContrasenia);
		tfContrasenia.setColumns(10);

		JLabel lblNombreusuario = new JLabel("Nombre de usuario");
		lblNombreusuario.setBounds(12, 143, 124, 16);
		contentPane.add(lblNombreusuario);

		JLabel lblContrasea = new JLabel("Contrasenia: ");
		lblContrasea.setBounds(33, 172, 108, 16);
		contentPane.add(lblContrasea);

		JButton btnIniciarSesin = new JButton("Iniciar sesion");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombreUsuario = tfUsuario.getText();
				String contrasenia = tfContrasenia.getText();
				System.out.println(nombreUsuario);
				try {

					PreparedStatement pst = con.prepareStatement("select * from usuario where nombreUsuario=?");
					pst.setString(1, nombreUsuario);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String contraseniaBaseDatos = rs.getString("contrasenia");
						if (contrasenia.equals(contraseniaBaseDatos)) {
							System.out.println("iniciar sesion");
							
						} else {
							System.out.println("contrasena incorrecta");
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnIniciarSesin.setBounds(290, 137, 130, 25);
		contentPane.add(btnIniciarSesin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro2 re = new registro2();
			}   
		});
		btnRegistrarse.setBounds(290, 168, 130, 25);
		contentPane.add(btnRegistrarse);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBounds(148, 0, 116, 51);
		contentPane.add(panel_1);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblLogIn);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 432, 51);
		contentPane.add(panel);
		
		JButton btnJuegaSinRegistrarte = new JButton("Juega sin registrarte aqui");
		btnJuegaSinRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaTetris gfds = new ventanaTetris();
			}
		});
		btnJuegaSinRegistrarte.setBounds(148, 215, 189, 25);
		contentPane.add(btnJuegaSinRegistrarte);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					con.close();
					System.out.println("cerrando sesion");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

	}
}
