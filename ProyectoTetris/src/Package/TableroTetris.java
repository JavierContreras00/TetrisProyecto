package Package;

import java.awt.BasicStroke; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Timer;


import javax.imageio.ImageIO;
import javax.swing.*;

public class TableroTetris extends JPanel implements KeyListener {
	
	private BufferedImage bloques, fondo;
	
	private final int bloquesTamanyo = 30; 
	private final int tableroAncho = 10, tableroAlto = 20; 
	
	private int [][] tableroTetris = new int[tableroAlto][tableroAncho]; 
	
	private FormaTetris[] formas = new FormaTetris[7]; 
    private FormaTetris formaActual; 
    
    private Timer tiempo; 
    private final int FPS = 60; 
    private final int delay = 1000/FPS; 
    
    private boolean Final = false; 
    
    private int score = 0; 
	
	public TableroTetris() {
		
		try {
			bloques = ImageIO.read(TableroTetris.class.getResource("/o7Q40Cn.png")); 
			fondo = ImageIO.read(TableroTetris.class.getResource("/fondo.png")); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		tiempo = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				descarga(); 
				repaint(); 
				
			}
			
		});
	
		tiempo.start(); 
	
		// Formas
		
		// Forma I (subimage para que no crashe la ventana)
		
		formas[0] = new FormaTetris(bloques.getSubimage(0, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 1, 1}
		}, this, 1); 
		
		// Forma Z
		
		formas[1] = new FormaTetris(bloques.getSubimage(bloquesTamanyo, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 0},
			{0, 1, 1}
		}, this, 2); 
		
		// Forma Z invertida
		
		formas[2] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*2, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{0, 1, 1},
			{1, 1, 0}
		}, this, 3); 
		
		// Forma T
		
		formas[3] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*3, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 1},
			{0, 1, 0}
		}, this, 4); 
		
		// Forma L 
		
		formas[4] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*4, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 1},
			{0, 0, 1}
		}, this, 5); 
		
		//Forma L invertida
		
		formas[5] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*5, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 1}, 
			{1, 0, 0}
		}, this, 6); 
		
		// Forma O
		
		formas[6] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*6, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1}, 
			{1, 1}
		}, this, 7); 
		
		siguienteForma(); 
   }
	
	public void descarga() {
		formaActual.descarga();
		
		if(Final) 
			tiempo.stop();
	}

	public void paint (Graphics g) {
		super.paint(g); 
		
		g.drawImage(fondo, 0, 0, null); 
		
		for(int fila = 0; fila < tableroTetris.length; fila++) {
		    for(int col = 0; col < tableroTetris[fila].length; col++) {
		    	if(tableroTetris[fila][col] != 0) {
		    		g.drawImage(bloques.getSubimage((tableroTetris[fila][col]-1)*bloquesTamanyo, 0, bloquesTamanyo, bloquesTamanyo), col * bloquesTamanyo, fila * bloquesTamanyo, null); 
		    	}
		    }
		}
		
		g.setColor(Color.GRAY);	
	
	    g.setFont(new Font("Georgia", Font.BOLD, 30));
		    
	    g.drawString("SCORE", TableroTetris.WIDTH + 310, TableroTetris.HEIGHT + 300);
		g.drawString(score+"", TableroTetris.WIDTH + 310, TableroTetris.HEIGHT/2 + 330);
		
		//Crear tablero.
		
		//Lineas Horizontales
		for (int i = 0; i <= tableroAlto; i++) {
			g.drawLine(0, i*bloquesTamanyo, tableroAncho * bloquesTamanyo, i * bloquesTamanyo);
		}
		
		//Lineas Verticales
		for (int j = 0; j <= tableroAncho; j++) {
			g.drawLine(j*bloquesTamanyo, 0 , j*bloquesTamanyo, tableroAlto*bloquesTamanyo);
		}
		
		
		formaActual.reproducir(g);
	
	}
	
	//Sale siguiete figura
	
	public void siguienteForma() {
		
		int index = (int)(Math.random()*formas.length); 
		
		FormaTetris nuevaForma = new FormaTetris(formas[index].getBloques(), formas[index].getCor(), this, formas[index].getColor()); 
		
		formaActual = nuevaForma; 
		
		for(int fila = 0; fila < formaActual.getCor().length; fila++)
		    for(int col = 0; col < formaActual.getCor()[fila].length; col++)
		    	if(formaActual.getCor()[fila][col] != 0) {
		    		
		    		if(tableroTetris[fila][col+3] != 0) {
		    			
		    			Final = true; 
		    		
		    		System.out.println("GAME OVER");
		    		}
		    	}
		
	}
	
	public int[][] getTablero() {
		return tableroTetris; 
	}
	
	public int getTamanyoBloque() {
		return bloquesTamanyo; 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Mover piezas

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			formaActual.setDeltaX(-1);
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			formaActual.setDeltaX(1);
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			formaActual.bVelocidad();
		if(e.getKeyCode() == KeyEvent.VK_UP)                  // [ 1, 1]  --> [0, 1]
			formaActual.rotar();                              // [ 0, 1]  --> [0, 1]
	}                                                         // [ 0, 1]  --> [1, 1]

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			formaActual.nVelocidad();
	}
	
	public void stopGame(){
		score = 0;
		
		for(int fila = 0; fila < tableroTetris.length; fila++)
		{
			for(int col = 0; col < tableroTetris[fila].length; col ++)
			{
				tableroTetris[fila][col] = 0;
			}
		}
		tiempo.stop();
	}
	
	public void addScore() {
		score++; 
	}
}