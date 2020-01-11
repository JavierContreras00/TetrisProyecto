package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;

public class BD {
	/*private static Thread hilo = null;
	private static Vector<Runnable> tareasPendientes;  
	static {
		tareasPendientes = new Vector<>();
	}
	private static void initHilo() {
		hilo = new Thread() {
			@Override
			public void run() {
				while (!interrupted()) {
					while (!tareasPendientes.isEmpty()) {
						Runnable r = tareasPendientes.remove(0);
						r.run();
					}
					try { Thread.sleep( 10 ); } catch (InterruptedException e) { break; }
				}
				hilo = null;
				System.out.println( "Cierre de hilo." );
			}
		};
		hilo.start();
	}
	private static Exception lastError = null;  // Información de último error SQL ocurrido
	
	public static Connection initBD( String bdtetris ) {
		if (hilo == null) initHilo();
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + bdtetris );
			log( Level.INFO, "Conectada base de datos " + bdtetris, null );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexión de base de datos " + bdtetris, e );
			e.printStackTrace();
			return null;
		}
	}
	
	

	private static void log(Level info, String string, Object object) {
		// TODO Auto-generated method stub
		
	}

*/

       public static Connection initBD() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tetrix", "root", "deusto");
		//Class.forName("org.sqlite.JDBC");
		//Connection con = DriverManager.getConnection("jdbc:sqlite:C/sqlite/db/bdtetris.sql");
		return con;
	}
	
	/*public static Connection initBD() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/bdtetris.db";
            conn = DriverManager.getConnection(url);
            
            System.out.println("Se ha establecido conexion con la base de datos.");
            
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
		return conn;
    }
	
*/
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
