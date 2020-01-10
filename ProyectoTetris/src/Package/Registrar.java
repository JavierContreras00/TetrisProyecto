package Package;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrar extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombreUsuario;
	private JTextField tfEmail;
	private JTextField tfContrasenia;
	private JTextField tfNombre;
	private JTextField tfApellido;

	/**
	 * Launch the application.
	 */
	public static void main(Connection con) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar frame = new Registrar(con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registrar(Connection con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(25, 175, 104, 16);
		contentPane.add(lblNombreUsuario);

		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setBounds(185, 172, 116, 22);
		contentPane.add(tfNombreUsuario);
		tfNombreUsuario.setColumns(10);

		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(25, 223, 104, 16);
		contentPane.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(185, 220, 116, 22);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblContrasenia = new JLabel("Contrasenia:");
		lblContrasenia.setBounds(25, 276, 104, 16);
		contentPane.add(lblContrasenia);

		tfContrasenia = new JTextField();
		tfContrasenia.setBounds(185, 273, 116, 22);
		contentPane.add(tfContrasenia);
		tfContrasenia.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 72, 56, 16);
		contentPane.add(lblNombre);

		tfNombre = new JTextField();
		tfNombre.setBounds(185, 69, 116, 22);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(25, 122, 56, 16);
		contentPane.add(lblApellido);

		tfApellido = new JTextField();
		tfApellido.setBounds(185, 119, 116, 22);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);


		JLabel lblAnio = new JLabel("Anio:");
		lblAnio.setBounds(25, 327, 56, 16);
		contentPane.add(lblAnio);

		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(25, 371, 56, 16);
		contentPane.add(lblMes);

		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(25, 415, 56, 16);
		contentPane.add(lblDia);

		JComboBox<String> cbAnio = new JComboBox<String>();
		cbAnio.setBounds(185, 324, 116, 22);
		contentPane.add(cbAnio);

		int anio = 2020;
		for (int i = anio; i > anio - 100; i--) {
			if (i > 9) {
				cbAnio.addItem(i + "");
			} else {
				cbAnio.addItem("0" + i);
			}

		}

		JComboBox<String> cbMes = new JComboBox<String>();
		cbMes.setBounds(185, 368, 116, 22);
		contentPane.add(cbMes);

		for (int i = 1; i <= 12; i++) {
			if (i < 10) {
				cbMes.addItem("0" + i);
			} else {
				cbMes.addItem(i + "");
			}
		}

		JComboBox<String> cbDia = new JComboBox<String>();
		cbDia.setBounds(185, 412, 116, 22);
		contentPane.add(cbDia);
		for (int i = 1; i <= 31; i++) {
			if (i < 10) {
				cbDia.addItem("0" + i);
			} else {
				cbDia.addItem(i + "");
			}
		}
	
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement pst;
				try {
					pst = con.prepareStatement("select * from usuario where email=?");
					pst.setString(1,  tfEmail.getText());
//					pst.setString(2, tfNombreUsuario.getText());
					ResultSet rs = pst.executeQuery();
					boolean emailExiste = false;
					while (rs.next()) {
						emailExiste = true;
					}
					PreparedStatement pst2 = con.prepareStatement("select * from usuario where nombreUsuario=?");
					pst2.setString(1, tfNombreUsuario.getText());
					ResultSet rs1 = pst2.executeQuery();
					boolean nombreUsuarioExiste = false;
					while (rs1.next()) {
						nombreUsuarioExiste = true;
					}
					
					if (emailExiste==false && nombreUsuarioExiste==false) {
						String fecha = cbAnio.getSelectedItem() + "-" + cbMes.getSelectedItem() + "-" + cbDia.getSelectedItem(); 
						PreparedStatement pst1 = con.prepareStatement("insert into usuario (nombreUsuario, email, nombre, apellido, fechaNac, contrasenia) values(?,?,?,?,?,?) ");
						pst1.setString(1, tfNombreUsuario.getText());
						pst1.setString(2,  tfEmail.getText());
						pst1.setString(3,  tfNombre.getText());
						pst1.setString(4, tfApellido.getText());
						pst1.setString(5, fecha);
						pst1.setString(6, tfContrasenia.getText());
						pst1.execute();
						con.close();
						dispose();
						VentanaLogIn.main(null);
					}else {
						if (emailExiste==true && nombreUsuarioExiste==false){
						JOptionPane.showMessageDialog(contentPane, "Error, el  email ya existe.");
						}else if (emailExiste==false && nombreUsuarioExiste==true){
							JOptionPane.showMessageDialog(contentPane, "Error, el  nombre de usuario ya existe.");
						}else if (emailExiste==true && nombreUsuarioExiste==true) {
							JOptionPane.showMessageDialog(contentPane, "Error, el email y el nombre de usuario ya existen.");
						}
						}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			

			}
		});
		btnRegistrar.setBounds(420, 411, 97, 25);
		contentPane.add(btnRegistrar);
	
	}
}
