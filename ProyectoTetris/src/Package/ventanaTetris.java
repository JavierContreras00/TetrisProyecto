package Package;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ventanaTetris {

	public static final int ancho = 445, alto = 638; 
	private JFrame ventanaTetris; 
	private TableroTetris tablero; 

	
	public static void main(Connection con, Usuario u) {
		new ventanaTetris(con, u); 
	}

	
	public ventanaTetris(Connection con, Usuario u) {
	  ventanaTetris =new JFrame("Tetris Juego"); 
	  ventanaTetris.setSize(ancho, alto);
	  ventanaTetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  ventanaTetris.setResizable(false);
	  ventanaTetris.setLocationRelativeTo(null);
	  
	  tablero = new TableroTetris() ; 
	 
	  ventanaTetris.add(tablero); 
	  ventanaTetris.addKeyListener(tablero);
	  ventanaTetris.addKeyListener(tablero);
	  ventanaTetris.addMouseMotionListener(tablero);
	  ventanaTetris.addMouseListener(tablero);
	  
	  ventanaTetris.setVisible(true);
	  
	}
	
	  public void startTetris() {
	    ventanaTetris.addMouseMotionListener(tablero);
		ventanaTetris.addMouseListener(tablero);
		ventanaTetris.add(tablero);
		tablero.startGame();
		ventanaTetris.revalidate();
     }
		
}

