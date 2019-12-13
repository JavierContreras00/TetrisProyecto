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
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;

public class ventanaPrincipal extends JFrame {

	private JPanel absPane;

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
		setBounds(100, 100, 438, 426);
		absPane = new JPanel();
		absPane.setToolTipText("");
		absPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(absPane);
		absPane.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(150, 100, 108, 21);
		absPane.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ventanaTetris v = new ventanaTetris(); 
				ventanaPrincipal.this.dispose();
					
			}
		});
		
		JButton btnPuntuacion = new JButton("Puntuacion");
		btnPuntuacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ventanaPuntuacion o = new ventanaPuntuacion(); 
				o.setVisible(true);
				ventanaPrincipal.this.dispose();
				
			}
		});
		btnPuntuacion.setBounds(150, 134, 108, 21);
		absPane.add(btnPuntuacion);
		
		JButton btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ventanaOpciones o = new ventanaOpciones(); 
				o.setVisible(true);
				ventanaPrincipal.this.dispose();
			}
		});
		
		btnOpciones.setBounds(150, 168, 108, 21);
		absPane.add(btnOpciones);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(150, 236, 108, 21);
		absPane.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(150, 202, 108, 21);
		absPane.add(btnAyuda);
		
		Panel panel = new Panel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(136, 0, 156, 51);
		absPane.add(panel);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblMenu);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 0, 420, 51);
		absPane.add(panel_1);
		btnAyuda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAyuda a = new ventanaAyuda(); 
				a.setVisible(true);
				ventanaPrincipal.this.dispose();
			}
			
		});
		
	}
}
