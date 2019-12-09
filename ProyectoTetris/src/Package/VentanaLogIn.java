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
		tfUsuario.setBounds(148, 128, 116, 22);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);

		tfContrasenia = new JTextField();
		tfContrasenia.setBounds(148, 187, 116, 22);
		contentPane.add(tfContrasenia);
		tfContrasenia.setColumns(10);

		JLabel lblNombreusuario = new JLabel("Nombre de usuario");
		lblNombreusuario.setBounds(12, 131, 124, 16);
		contentPane.add(lblNombreusuario);

		JLabel lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setBounds(12, 190, 108, 16);
		contentPane.add(lblContrasea);

		JButton btnIniciarSesin = new JButton("Iniciar sesión");
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
							System.out.println("contraseña incorrecta");
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnIniciarSesin.setBounds(292, 143, 108, 25);
		contentPane.add(btnIniciarSesin);

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
