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
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setAction(Play);
		btnPlay.setBounds(100, 72, 85, 21);
		absPane.add(btnPlay);
		btnPlay.addActionListener(new ActionListener() {

			/// LLamar a otra ventana
			
		@Override
		public void actionPerformed(ActionEvent e) {
			 ventanaRegistro r = new ventanaRegistro(); 
			   r.setVisible(true);
			   ventanaPrincipal.this.dispose();	
		}
		});
		
		JButton btnScore = new JButton("Score");
		btnScore.setBounds(100, 103, 85, 21);
		absPane.add(btnScore);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/// ...
				
			}
		});
		
		btnOptions.setBounds(100, 134, 85, 21);
		absPane.add(btnOptions);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(100, 165, 85, 21);
		absPane.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		}
				);
		
		JLabel lblTetrisdeusto = new JLabel("TetrisDeusto");
		lblTetrisdeusto.setBounds(114, 35, 58, 13);
		absPane.add(lblTetrisdeusto);
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
