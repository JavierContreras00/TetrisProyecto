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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
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



	/**

	 * Create the frame.
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/contre00/TetrisProyecto.git
	 */

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

		}{;

		btnIngresar.setBounds(288, 72, 97, 25);
		contentPane.add(btnIngresar);
		
		JTextPane txtpnAunNoTienes = new JTextPane();
		txtpnAunNoTienes.setText("Aun no tienes cuenta? Registrate aqui");
		txtpnAunNoTienes.setBounds(44, 156, 211, 22);
		contentPane.add(txtpnAunNoTienes);

	}
);}}
