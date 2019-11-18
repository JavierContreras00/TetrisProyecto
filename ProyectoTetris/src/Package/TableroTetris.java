package Package;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TableroTetris extends JPanel implements KeyListener {
	
	private BufferedImage bloques; 
	private final int bloquesTamanyo = 30; 
	private final int tableroAncho = 10, tableroAlto = 20; 
	
	private int [][] tableroTetris = new int[tableroAlto][tableroAncho]; 
	
	private FormaTetris[] formas = new FormaTetris[7]; 
    private FormaTetris formaActual; 
    
    private Timer tiempo; 
    private final int FPS = 60; 
    private final int delay = 1000/FPS; 
	
	public TableroTetris() {
		
		try {
		bloques = ImageIO.read(TableroTetris.class.getResource("/o7Q40Cn.png"));
	    } catch (IOException e) {
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
		}, this); 
		
		// Forma Z
		
		formas[1] = new FormaTetris(bloques.getSubimage(bloquesTamanyo, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 0},
			{0, 1, 1}
		}, this); 
		
		// Forma Z invertida
		
		formas[2] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*2, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{0, 1, 1},
			{1, 1, 0}
		}, this); 
		
		// Forma T
		
		formas[3] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*3, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 1},
			{0, 1, 0}
		}, this); 
		
		// Forma L 
		
		formas[4] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*4, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 1},
			{0, 0, 1}
		}, this); 
		
		//Forma L invertida
		
		formas[5] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*5, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1, 1}, 
			{1, 0, 0}
		}, this); 
		
		// Forma O
		
		formas[6] = new FormaTetris(bloques.getSubimage(bloquesTamanyo*6, 0, bloquesTamanyo, bloquesTamanyo), new int[][] {
			{1, 1}, 
			{1, 1}
		}, this); 
		
		siguienteForma(); 
   }
	
	public void descarga() {
		formaActual.descarga();
	}

	public void paint (Graphics g) {
		super.paint(g); 
		
		formaActual.reproducir(g);
		
		for(int fila = 0; fila < tableroTetris.length; fila++)
		    for(int col = 0; col < tableroTetris[fila].length; col++)
		    	if(tableroTetris[fila][col] != 0)
		    		g.drawImage(bloques.getSubimage(0, 0, bloquesTamanyo, bloquesTamanyo), col * bloquesTamanyo, fila * bloquesTamanyo, null); 
		    	
		
		//Crear tablero.
		
		//Lineas Horizontales
		for (int i = 0; i < tableroAlto; i++) {
			g.drawLine(0, i*bloquesTamanyo, tableroAncho * bloquesTamanyo, i * bloquesTamanyo);
		}
		
		//Lineas Verticales
		for (int j = 0; j < tableroAncho; j++) {
			g.drawLine(j*bloquesTamanyo, 0 , j*bloquesTamanyo, tableroAlto*bloquesTamanyo);
		}
	}
	
	
	public void siguienteForma() {
		
		int index = (int)(Math.random()*tableroTetris.length); 
		
		FormaTetris nuevaForma = new FormaTetris(formas[index].getBloques(), formas[index].getCor(), this); 
		
		formaActual = nuevaForma; 
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
}
