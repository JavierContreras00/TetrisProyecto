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
		setBounds(100, 100, 326, 284);
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
	    txtrTetriwarEsUn.setText("TetriWar es un juego basado en el tetris de 1 a 4 personas. El jugador dispone del tablero principal para jugar y podr\u00E1 ver el juego de sus oponentes en los tableros auxiliares.\r\n\r\nEl juego consta de 7 piezas de forma geom\u00E9trica (con forma de I, O, J, L, S, Z y T) formadas por 4 bloques conectados. Una pieza aleatoria cae cada vez por la parte superior. El jugador deber\u00E1 controlarla y hacer que encaje con las que ya tiene en el tablero. Cuando consigue una l\u00EDnea horizontal y contigua de bloques, \u00E9sta se da como completa y desaparece.\r\n\r\nEl objetivo del juego es ganar m\u00E1s puntos que tus adversarios en el tiempo establecido. Los puntos se consiguen colocando piezas y eliminando l\u00EDneas. A mayor nivel de dificultad, mayor puntuaci\u00F3n (el nivel m\u00E1s alto es el 10).");
	    
	    JButton btnVolver = new JButton("Volver");
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
		
		
		
		
	}
}
