package Package;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void testGetUsuario() {
		Usuario u = new Usuario(0, "Unicajo", "unaifer@gmail.com", "Unai", "Fernandez", "30/03/00", "bsklabksb", 1000); 
		assertEquals("Unai", u.getNombre()); 
	}

	@Test
	public void testGetPuntuacion() {
		Usuario u = new Usuario(0, "Unicajo", "unaifer@gmail.com", "Unai", "Fernandez", "30/03/00", "bsklabksb", 1000); 
		assertEquals(1000, u.getPuntuacionMax());
}
	
	@Test
	public void testGetContrasenia() {
		Usuario u = new Usuario(0, "Unicajo", "unaifer@gmail.com", "Unai", "Fernandez", "30/03/00", "bsklabksb", 1000); 
		assertEquals("bsklabksb", u.getContrasenia());
	
}
	
	@Test
	public void testGetFechaNac() {
		Usuario u = new Usuario(0, "Unicajo", "unaifer@gmail.com", "Unai", "Fernandez", "30/03/00", "bsklabksb", 1000); 
		assertEquals("30/03/00", u.getFechaNac());
	
}
}