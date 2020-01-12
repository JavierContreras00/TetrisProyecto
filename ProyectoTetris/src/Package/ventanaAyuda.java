package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelListener;
import java.sql.Connection;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class ventanaAyuda extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(Connection con, Usuario u ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAyuda frame = new ventanaAyuda(con, u);
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
	
	public ventanaAyuda(Connection con, Usuario u) {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		setTitle("Ayuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 326, 284);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(0, 0, 312, 214);
		getContentPane().add(scrollPane);
		
	    JTextArea txtrTetriwarEsUn = new JTextArea();
	    txtrTetriwarEsUn.setEditable(false);
	    scrollPane.setViewportView(txtrTetriwarEsUn);
	    txtrTetriwarEsUn.setFont(new Font("Monospaced", Font.PLAIN, 13));
	    txtrTetriwarEsUn.setWrapStyleWord(true);
	    txtrTetriwarEsUn.setLineWrap(true);
	    txtrTetriwarEsUn.setText("Figuras geométricas compuestas por cuatro bloques cuadrados unidos de forma ortogonal, "
	    		+ "las cuales se generan de una zona que ocupa 5x5 bloques en el área superior de la pantalla."
	    		+ "El jugador no puede impedir esta caída, pero puede decidir la rotación de la pieza (0°, 90°, 180°, 270°) "
	    		+ "y en qué lugar debe caer. Cuando una línea horizontal se completa, "
	    		+ "esa línea desaparece y todas las piezas que están por encima descienden una posición, "
	    		+ "liberando espacio de juego y por tanto facilitando la tarea de situar nuevas piezas.");
	    
	    JButton btnVolver = new JButton("Exit");
	    btnVolver.setBounds(111, 219, 85, 21);
	    getContentPane().add(btnVolver);
	    btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal p = new ventanaPrincipal(con, u); 
				p.setVisible(true);
				ventanaAyuda.this.dispose();
			}
	    	
	    });
		
		//
		
		
	}
}
