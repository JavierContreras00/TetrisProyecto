package Package;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ventanaTetris {

	public static final int ancho = 445, alto = 638; 
	private JFrame ventanaTetris; 
	private TableroTetris tablero; 

	
	public static void main(String[] args) {
		new ventanaTetris(); 
	}

	
	public ventanaTetris() {
	  ventanaTetris =new JFrame("Tetris Juego"); 
	  ventanaTetris.setSize(ancho, alto);
	  ventanaTetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  ventanaTetris.setResizable(false);
	  ventanaTetris.setLocationRelativeTo(null);
	  
	  tablero = new TableroTetris() ; 
	 
	  ventanaTetris.add(tablero); 
	  ventanaTetris.addKeyListener(tablero);
	
	  
	  ventanaTetris.setVisible(true);
	 
	}


	


		
}

