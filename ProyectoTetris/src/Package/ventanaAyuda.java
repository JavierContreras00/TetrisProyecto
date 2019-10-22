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

public class ventanaAyuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAyuda frame = new ventanaAyuda();
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
	
	public ventanaAyuda() {
		setTitle("Ayuda");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 392, 425, -383);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(scrollPane);
		 
		JTextArea txtrTetriwarEsUn = new JTextArea();
		txtrTetriwarEsUn.setBounds(10, 10, 456, 372);
		txtrTetriwarEsUn.setEditable(false);
		txtrTetriwarEsUn.setColumns(1);
		txtrTetriwarEsUn.setToolTipText("");
		txtrTetriwarEsUn.setText("TetriWar es un juego basado en el tetris de 1 a 4 personas. El jugador dispone del tablero principal para jugar y podr\u00E1 ver el juego de sus oponentes en los tableros auxiliares.\r\n\r\nEl juego consta de 7 piezas de forma geom\u00E9trica (con forma de I, O, J, L, S, Z y T) formadas por 4 bloques conectados. Una pieza aleatoria cae cada vez por la parte superior. El jugador deber\u00E1 controlarla y hacer que encaje con las que ya tiene en el tablero. Cuando consigue una l\u00EDnea horizontal y contigua de bloques, \u00E9sta se da como completa y desaparece.\r\n\r\nObjetivo del juego\r\nEl objetivo del juego es ganar m\u00E1s puntos que tus adversarios en el tiempo establecido. Los puntos se consiguen colocando piezas y eliminando l\u00EDneas. A mayor nivel de dificultad, mayor puntuaci\u00F3n (el nivel m\u00E1s alto es el 10).\r\n\r\n1 l\u00EDnea: 10 puntos \u00D7 n\u00FAmero de nivel en el que te encuentras.\r\n2 l\u00EDneas: 25 puntos \u00D7 nivel.\r\n3 l\u00EDneas: 40 puntos \u00D7 nivel.\r\n4 l\u00EDneas: 60 puntos \u00D7 nivel.\r\nPor cada pieza colocada: 1 punto \u00D7 nivel.\r\nPor ejemplo, si se hacen 3 l\u00EDneas de golpe en nivel 6 conseguir\u00E9 40\u00D76=240 puntos.\r\n\r\nSi te eliminan durante la partida, continuar\u00E1s jugando, aunque empezar\u00E1s de nuevo desde nivel 1 (o desde el nivel inicial).\r\n\r\nSi se juega por parejas, se sumar\u00E1 la puntuaci\u00F3n de ambos jugadores para conocer el resultado.\r\n\r\nLas bombas\r\nSi se juega con la opci\u00F3n de bombas activada, cada vez que se completa una l\u00EDnea aparecer\u00E1 una bomba en la zona de juego. El jugador podr\u00E1 recoger la bomba si elimina la l\u00EDnea en la que se encuentra, y lanz\u00E1rsela a sus oponentes (o a s\u00ED mismo). Las bombas se pueden acumular para lanzar varias de golpe.\r\nTetriWar es un juego basado en el tetris de 1 a 4 personas. El jugador dispone del tablero principal para jugar y podr\u00E1 ver el juego de sus oponentes en los tableros auxiliares.\r\n\r\nEl juego consta de 7 piezas de forma geom\u00E9trica (con forma de I, O, J, L, S, Z y T) formadas por 4 bloques conectados. Una pieza aleatoria cae cada vez por la parte superior. El jugador deber\u00E1 controlarla y hacer que encaje con las que ya tiene en el tablero. Cuando consigue una l\u00EDnea horizontal y contigua de bloques, \u00E9sta se da como completa y desaparece.\r\n\r\nEl objetivo del juego es ganar m\u00E1s puntos que tus adversarios en el tiempo establecido. Los puntos se consiguen colocando piezas y eliminando l\u00EDneas. A mayor nivel de dificultad, mayor puntuaci\u00F3n (el nivel m\u00E1s alto es el 10).\r\n\r\n1 l\u00EDnea: 10 puntos \u00D7 n\u00FAmero de nivel en el que te encuentras.\r\n2 l\u00EDneas: 25 puntos \u00D7 nivel.\r\n3 l\u00EDneas: 40 puntos \u00D7 nivel.\r\n4 l\u00EDneas: 60 puntos \u00D7 nivel.\r\nPor cada pieza colocada: 1 punto \u00D7 nivel.\r\nPor ejemplo, si se hacen 3 l\u00EDneas de golpe en nivel 6 conseguir\u00E9 40\u00D76=240 puntos.\r\n\r\nSi te eliminan durante la partida, continuar\u00E1s jugando, aunque empezar\u00E1s de nuevo desde nivel 1 (o desde el nivel inicial).\r\n\r\nSi se juega por parejas, se sumar\u00E1 la puntuaci\u00F3n de ambos jugadores para conocer el resultado.\r\nEn modo manual, el jugador puede decidir cuando y a quien lanzar las bombas. V\u00E9ase controles de juego m\u00E1s abajo.\r\n\r\nSi se juega con la opci\u00F3n de bombas activada, cada vez que se completa una l\u00EDnea aparecer\u00E1 una bomba en la zona de juego. El jugador podr\u00E1 recoger la bomba si elimina la l\u00EDnea en la que se encuentra, y lanz\u00E1rsela a sus oponentes (o a s\u00ED mismo). Las bombas se pueden acumular para lanzar varias de golpe.\r\n\r\nEn modo autom\u00E1tico, el ordenador lanzar\u00E1 una bomba nada m\u00E1s recogerla.\r\nEn la parte superior de la pantalla aparecen las bombas que recibes. El n\u00FAmero situado bajo la bomba indica el n\u00FAmero del jugador que te la ha enviado.\r\n\r\n");
		contentPane.add(txtrTetriwarEsUn);
		
	}
}
