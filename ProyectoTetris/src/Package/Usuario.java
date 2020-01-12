package Package;

public class Usuario {
	int idUsuario;
	String nombreUsuario;
	String email;
	String nombre;
	String apellido;
	String fechaNac;
	String contrasenia;
	int puntuacionMax;
	
	public Usuario(int idUsuario, String nombreUsuario, String email, String nombre, String apellido, String fechaNac,
			String contrasenia, int puntuacionMax) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.contrasenia = contrasenia;
		this.puntuacionMax = puntuacionMax;
	}

	public int getPuntuacionMax() {
		return puntuacionMax;
	}

	public void setPuntuacionMax(int puntuacionMax) {
		this.puntuacionMax = puntuacionMax;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", email=" + email + ", nombre="
				+ nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", contrasenia=" + contrasenia + "]";
	}

	public int getPuntos() {
		// TODO Auto-generated method stub
		return 0;
	}


}
