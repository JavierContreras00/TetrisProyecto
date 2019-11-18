package Package;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FormaTetris {
	
	private BufferedImage bloques;
	private int [][] cor; 
	private TableroTetris tablero;
	
	public int deltaX = 0; 
	private int x, y; 
	
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
		
		//Limites laterales del tetris
	
	if(!(x + deltaX + cor[0].length > 10) && !(x + deltaX < 0))	
		
	 x += deltaX; 
	

	if (!(y +1 + cor.length > 18)) {
		
		if (tiempo > velocidadActual) {
			
			  y++; 
			  tiempo = 0; 
			  
			}
	}
	
	 deltaX = 0; 
	 
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
		
		rotarMatriz = getTranspuestaMatriz(rotarMatriz); 
		
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
	
	private int[][] getTranspuestaMatriz(int [][] matriz) {
		
		int medio = matriz.length / 2; 
		
		for(int i = 0; i < medio; i++) {
			int[] m = matriz[1]; 
			matriz[1] = matriz[matriz.length - i - 1];
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
	
}
