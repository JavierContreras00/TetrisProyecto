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
import javax.swing.JOptionPane;
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
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		setTitle("Ayuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 326, 284);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setToolTipText("");
		getContentPane().add(scrollPane);
		
	    JTextArea txtrTetriwarEsUn = new JTextArea();
	    txtrTetriwarEsUn.setEditable(false);
	    scrollPane.setViewportView(txtrTetriwarEsUn);
	    txtrTetriwarEsUn.setFont(new Font("Monospaced", Font.PLAIN, 13));
	    txtrTetriwarEsUn.setWrapStyleWord(true);
	    txtrTetriwarEsUn.setLineWrap(true);
	    txtrTetriwarEsUn.setText("CURIOSIDADES: "
	    		+ "El tetris esta hecho por figuras geométricas compuestas por cuatro bloques cuadrados unidos de forma ortogonal, "
	    		+ "las cuales se generan de una zona que ocupa 5x5 bloques en el área superior de la pantalla."
	    		+ "El jugador no puede impedir esta caída, pero puede decidir la rotación de la pieza (0°, 90°, 180°, 270°) "
	    		+ "y en qué lugar debe caer. Cuando una línea horizontal se completa, "
	    		+ "esa línea desaparece y todas las piezas que están por encima descienden una posición, "
	    		+ "liberando espacio de juego y por tanto facilitando la tarea de situar nuevas piezas. "  
	    		+ "CONTROLES: "
	    		+ "> Mueve Derecha"
	    		+ "< Mueve Izquierda"
	    		+ "^ Rota Pieza"
	    		+ "v Aumenta velocidad de bajada"
	    		+ "PUNTUACIONES: "
	    		+ "Cada vez que una pieza se posada el contador sumara +1 y cuando una fila sea despejada se le sumara +1"
	    		+ "NIVELES: "
	    		+ "En este juego no hay niveles por lo que la dificultad y velocidad del juego seran constantes");
	    
	    JButton btnVolver = new JButton("Exit");
	    getContentPane().add(btnVolver, BorderLayout.SOUTH);
	    btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int decision = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres volver al Menu Principal");
				if (decision == JOptionPane.YES_OPTION) {
				ventanaPrincipal p = new ventanaPrincipal(con, u); 
				p.setVisible(true);
				ventanaAyuda.this.dispose();
				} else {
					decision = (Integer) null; 
				}
			}
	    	
	    });
		
		//
		
		
	}
}
