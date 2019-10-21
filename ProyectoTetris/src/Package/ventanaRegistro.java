package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class ventanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCorreo;
	private JPasswordField passwordContrasenya;

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

	/**
	 * Create the frame.
	 */
	public ventanaRegistro() {
		setTitle("Registrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 23, 46, 13);
		contentPane.add(lblNombre);
		
		JLabel lblContraseanya = new JLabel("Contrase\u00F1a:");
		lblContraseanya.setBounds(25, 63, 59, 13);
		contentPane.add(lblContraseanya);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(25, 103, 46, 13);
		contentPane.add(lblCorreo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(25, 143, 46, 13);
		contentPane.add(lblSexo);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(25, 183, 46, 13);
		contentPane.add(lblEdad);
		
		JButton btnResgistrarse = new JButton("Resgistrarse");
		btnResgistrarse.setBounds(116, 232, 99, 21);
		contentPane.add(btnResgistrarse);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(225, 232, 99, 21);
		contentPane.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		}
				);
		
		textNombre = new JTextField();
		textNombre.setBounds(91, 20, 311, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JCheckBox chckbxMostrar = new JCheckBox("Mostrar");
		chckbxMostrar.setBounds(335, 59, 95, 21);
		contentPane.add(chckbxMostrar);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(91, 100, 311, 19);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(91, 139, 83, 21);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(182, 139, 83, 21);
		contentPane.add(rdbtnFemenino);
		
		JRadioButton rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.setBounds(267, 139, 83, 21);
		contentPane.add(rdbtnOtro);
		
		JComboBox comboBoxEdad = new JComboBox();
		comboBoxEdad.setModel(new DefaultComboBoxModel(new String[] {"3-12", "12-18", "18-32", ">32"}));
		comboBoxEdad.setBounds(91, 179, 59, 21);
		contentPane.add(comboBoxEdad);
		
		passwordContrasenya = new JPasswordField();
		passwordContrasenya.setBounds(94, 60, 230, 19);
		contentPane.add(passwordContrasenya);
	}
}
