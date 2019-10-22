package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ventanaPrincipal extends JFrame {

	private JPanel absPane;
	private final Action Play = new SwingAction();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
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
	
	public ventanaPrincipal() {
		setTitle("VentanaPrincipal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 235);
		absPane = new JPanel();
		absPane.setToolTipText("");
		absPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(absPane);
		absPane.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setAction(Play);
		btnJugar.setBounds(88, 44, 108, 21);
		absPane.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {

			/// LLamar a otra ventana
			
		@Override
		public void actionPerformed(ActionEvent e) {
			 ventanaRegistro r = new ventanaRegistro(); 
			   r.setVisible(true);
			   ventanaPrincipal.this.dispose();	
		}
		});
		
		JButton btnPuntuacion = new JButton("Puntuacion");
		btnPuntuacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPuntuacion.setBounds(88, 75, 108, 21);
		absPane.add(btnPuntuacion);
		
		JButton btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/// ...
				
			}
		});
		
		btnOpciones.setBounds(88, 106, 108, 21);
		absPane.add(btnOpciones);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(88, 165, 108, 21);
		absPane.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		}
				);
		
		JLabel lblTetrisdeusto = new JLabel(" TetrisDeusto");
		lblTetrisdeusto.setBounds(100, 10, 76, 13);
		absPane.add(lblTetrisdeusto);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(88, 137, 108, 21);
		absPane.add(btnAyuda);
	}
	
	/// Accion del btnPlay
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Play");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
