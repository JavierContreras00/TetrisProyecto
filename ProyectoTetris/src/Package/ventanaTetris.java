package Package;


import javax.swing.JFrame;

public class ventanaTetris {
	
	public static final int ancho = 445, alto = 577; 
	private JFrame ventanaTetris; 
	private TableroTetris tablero; 

	
	public static void main(String[] args)  {
		new ventanaTetris(); 
	}

	
	public ventanaTetris()  {
	  ventanaTetris =new JFrame("Tetris Juego"); 
	  ventanaTetris.setSize(ancho, alto);
	  ventanaTetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  ventanaTetris.setResizable(false);
	  ventanaTetris.setLocationRelativeTo(null);
	  
	  tablero = new TableroTetris(); 
	  
	  ventanaTetris.add(tablero); 
	  ventanaTetris.addKeyListener(tablero); 
	  
	  
	  ventanaTetris.setVisible(true);
	}
	

}
