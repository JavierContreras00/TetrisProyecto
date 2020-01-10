package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {

	//public static Connection initBD() throws SQLException, ClassNotFoundException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
	//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tetrix", "root", "deusto");
		//Connection con = DriverManager.getConnection("jdbc:sqlite:C/sqlite/db/usuario.db");
	//	return con;
	//}
	
	public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/usuario.db";
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
	

	public static Usuario crearUsuario(Connection con, String nombreUsuario) throws SQLException {
		PreparedStatement pst = con.prepareStatement("select * from usuario where nombreUSuario=?");
		pst.setString(1, nombreUsuario);
		ResultSet rs = pst.executeQuery();
		Usuario u = null;
		while (rs.next()) {
			u = new Usuario(rs.getInt("idUsuario"), rs.getString("nombreUsuario"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("fechaNac"), rs.getString("contrasenia"), rs.getInt("PuntuacionMax"));
		}
		return u;
	}
	public static void actualizarDatosUsuario(Connection con, Usuario u) throws SQLException {
		PreparedStatement pst = con.prepareStatement("update usuario (nombreUsuario, email, nombre, apellido, fechaNac, contrasenia, puntuacionMax) set (?,?,?,?,?,?,?) where idUsuario=?");
		pst.setString(1, u.getNombreUsuario());
		pst.setString(2, u.getEmail());
		pst.setString(3, u.getNombre());
		pst.setString(4, u.getApellido());
		pst.setString(5, u.getFechaNac());
		pst.setString(6, u.getContrasenia());
		pst.setInt(7, u.getPuntuacionMax());
		pst.executeUpdate();
	}
	

}
