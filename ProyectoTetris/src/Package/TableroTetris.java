package Package;

import java.awt.BasicStroke; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.Timer;


import javax.imageio.ImageIO;
import javax.swing.*;

public class TableroTetris extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	
	private BufferedImage bloques, fondo, pausa, refresh;
	
	private final int bloquesTamanyo = 30; 
	private final int tableroAncho = 10, tableroAlto = 20; 
	
	private int [][] tableroTetris = new int[tableroAlto][tableroAncho]; 
	
	private FormaTetris[] formas = new FormaTetris[7]; 
    private FormaTetris formaActual, nuevaForma; 
    private Rectangle stopBounds, refreshBounds; 
    private int mouseX, mouseY;
    private boolean leftClick = false;
    
    private Timer tiempo; 
    private final int FPS = 60; 
    private final int delay = 1000/FPS; 
    
    private boolean stopGame = false;
    private boolean Final = false; 
    
    private Timer intervalo = new Timer(300, new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			intervalo.stop();
		}});
    
    private int score = 0; 
	
	public TableroTetris() {
		
		try {
			pausa = ImageIO.read(TableroTetris.class.getResource("/Pause.png"));
			refresh = ImageIO.read(TableroTetris.class.getResource("/refresh.png"));
			bloques = ImageIO.read(TableroTetris.class.getResource("/o7Q40Cn.png")); 
			fondo = ImageIO.read(TableroTetris.class.getResource("/fondo.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		mouseX = 0;
		mouseY = 0;
		
		stopBounds = new Rectangle(350, 500, pausa.getWidth(), pausa.getHeight() + pausa.getHeight()/2);
		refreshBounds = new Rectangle(350, 500 - refresh.getHeight() - 20,refresh.getWidth(),
				refresh.getHeight() + refresh.getHeight()/2);
		
		
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
		if(stopBounds.contains(mouseX, mouseY) && leftClick && !intervalo.isRunning() && !Final)
		{
			intervalo.start();
			stopGame = !stopGame;
		}
		
		if(refreshBounds.contains(mouseX, mouseY) && leftClick)
			startGame();
		
		if(stopGame || Final)
		{
			return;
		}
		formaActual.descarga();
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
		}for(int row = 0; row < nuevaForma.getCor().length; row ++)
		{
			for(int col = 0; col < nuevaForma.getCor()[0].length; col ++)
			{
				if(nuevaForma.getCor()[row][col] != 0)
				{
					g.drawImage(nuevaForma.getBloques(), col*30 + 320, row*30 + 50, null);	
				}
			}		
		}
		formaActual.reproducir(g);
		
		if(stopBounds.contains(mouseX, mouseY))
			g.drawImage(pausa.getScaledInstance(pausa.getWidth() + 3, pausa.getHeight() + 3, BufferedImage.SCALE_DEFAULT)
					, stopBounds.x + 3, stopBounds.y + 3, null);
		else
			g.drawImage(pausa, stopBounds.x, stopBounds.y, null);
		
		if(refreshBounds.contains(mouseX, mouseY))
			g.drawImage(refresh.getScaledInstance(refresh.getWidth() + 3, refresh.getHeight() + 3,
					BufferedImage.SCALE_DEFAULT), refreshBounds.x + 3, refreshBounds.y + 3, null);
		else
			g.drawImage(refresh, refreshBounds.x, refreshBounds.y, null);
		
		
		if(stopGame)
		{
			String gamePausedString = "GAME PAUSED";
			g.setColor(Color.WHITE);
			g.setFont(new Font("Georgia", Font.BOLD, 30));
			g.drawString(gamePausedString, 35, TableroTetris.HEIGHT/2);
		}
		if(Final)
		{
			String gameOverString = "GAME OVER";
			g.setColor(Color.WHITE);
			g.setFont(new Font("Georgia", Font.BOLD, 30));
			g.drawString(gameOverString, 50, TableroTetris.HEIGHT/2);
		}	
		
		g.setColor(Color.WHITE);	
	
	    g.setFont(new Font("Georgia", Font.BOLD, 20));
		    
	    g.drawString("SCORE", TableroTetris.WIDTH + 310, TableroTetris.HEIGHT + 300);
		g.drawString(score+"", TableroTetris.WIDTH + 310, TableroTetris.HEIGHT/2 + 330);
		
		g.drawString("RESET", TableroTetris.WIDTH + 310, TableroTetris.HEIGHT + 480);
		g.drawString("PAUSA", TableroTetris.WIDTH + 310, TableroTetris.HEIGHT + 380);
		g.drawString("PIEZA", TableroTetris.WIDTH + 310, TableroTetris.HEIGHT + 50);
		
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
	
	public void setForma() {
		
         int index = (int)(Math.random()*formas.length); 
		 nuevaForma = new FormaTetris(formas[index].getBloques(), formas[index].getCor(), this, formas[index].getColor()); 
	}
	
	public void siguienteForma() {
		
		formaActual = nuevaForma; 
		setForma(); 
		
		for(int fila = 0; fila < formaActual.getCor().length; fila++)
		    for(int col = 0; col < formaActual.getCor()[fila].length; col++)
		    	if(formaActual.getCor()[fila][col] != 0) {
		    		
		    		if(tableroTetris[formaActual.getY() + fila][formaActual.getX() + col] != 0) {
		    			
		    			Final = true; 
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
	
	public void startGame(){
		stopGame();
		siguienteForma();
		Final = false;
		tiempo.start();
		
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
	
	public void PuntuacionMax(Connection con, Usuario  u) throws SQLException {
		if (score > u.getPuntuacionMax() ) {
			u.setPuntuacionMax(score);
			BD.actualizarDatosUsuario(con, u);		
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftClick = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftClick = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}
}