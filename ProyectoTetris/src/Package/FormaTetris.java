package Package;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FormaTetris {
	
	private BufferedImage bloques;
	private int [][] cor; 
	private TableroTetris tablero;
	
	public int deltaX = 0; 
	private int x, y; 
	
	private boolean colision = false, ejeX = false; 
	
	private int nVelocidad = 600, bVelocidad = 100, velocidadActual; 
	private long tiempo, uTiempo; 
	
	public FormaTetris(BufferedImage bloques, int [][] cor, TableroTetris tablero) {
		this.bloques = bloques; 
		this.cor = cor; 
		this.tablero = tablero; 
		
		velocidadActual = nVelocidad; 
		tiempo = 0; 
		uTiempo = System.currentTimeMillis(); 
		
		x = 4; 
		y = 0; 
	}

	public void descarga() {
		
		//Caida de piezas
		
		tiempo += System.currentTimeMillis()-uTiempo; 
		uTiempo = System.currentTimeMillis(); 
		
		//Cuando choque con el suelo sale la siguiente forma
		
		if (colision) {
			
			for(int fila = 0; fila < cor.length; fila++)
			    for(int col = 0; col < cor[fila].length; col++)
			    	if(cor[fila][col] != 0)
			    		tablero.getTablero() [y + fila][x + col] = 1; 
			
			tablero.siguienteForma();
		}
		
		//Limites laterales del tetris
	
	if(!(x + deltaX + cor[0].length > 10) && !(x + deltaX < 0))	{
		
		// Colision en el eje X 
		
		for(int fila = 0; fila < cor.length; fila++)
		    for(int col = 0; col < cor[fila].length; col++)
		    	if(cor[fila][col] != 0) {
		    		if(tablero.getTablero() [y + fila ][x + deltaX + col] !=0)
		    			ejeX = false; 
		    	}
		if (ejeX)
		x += deltaX; 
	}

	if (!(y +1 + cor.length > 18)) {
		
		// Colision Vertical
		
		for(int fila = 0; fila < cor.length; fila++)
		    for(int col = 0; col < cor[fila].length; col++)
		    	if(cor[fila][col] != 0) {
		    		
		    		if(tablero.getTablero() [y + fila + 1][col + x] !=0)
		    			colision = true; 
		    	}
		
		if (tiempo > velocidadActual) {
			
			  y++; 
			  tiempo = 0; 
			  
			}
	} else {
		colision = true; 
	}
	
	 deltaX = 0; 
	 ejeX = true; 
	 
	}
	
	public void reproducir(Graphics g) {
		
		for(int fila = 0; fila < cor.length; fila++)
			for(int columna = 0; columna < cor[fila].length; columna++)
				if(cor[fila][columna] != 0)
					g.drawImage(bloques, columna * tablero.getTamanyoBloque() + x*tablero.getTamanyoBloque(),
							fila * tablero.getTamanyoBloque() + y*tablero.getTamanyoBloque(), null); 
	}
	
	public void rotar() {
		
		int [][] rotarMatriz = null; 
		
		rotarMatriz = getTranspuesta(cor); 
		
		rotarMatriz = getContrariaMatriz(rotarMatriz); 
		
		if(x + rotarMatriz[0].length > 10 || y + rotarMatriz.length > 20 )
		  return; 
		
		cor = rotarMatriz; 
		
	}
	
	private int[][] getTranspuesta(int [][] matriz) {
		
		int[][] nMatriz = new int[matriz[0].length][matriz.length]; 
		
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz[0].length; j++)
				nMatriz[j][i] = matriz [i][j]; 
		
		return nMatriz; 
	}
	
	private int[][] getContrariaMatriz(int [][] matriz) {
		
		int medio = matriz.length / 2; 
		
		for(int i = 0; i < medio; i++) {
			int[] m = matriz[i]; 
			matriz[i] = matriz[matriz.length - i - 1];
			matriz[matriz.length - i - 1] = m; 
		}
		
		return matriz; 
	}
	
	public void setDeltaX(int deltaX) {
	 this.deltaX = deltaX;
	}
	
	public void nVelocidad() {
		velocidadActual = nVelocidad; 
	}
	
	public void bVelocidad() {
		velocidadActual = bVelocidad; 
	}

	public BufferedImage getBloques() {
		return bloques;
	}

	public int[][] getCor() {
		return cor;
	}
	
}
