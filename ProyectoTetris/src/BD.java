import java.sql.*;
public class BD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("org.sqlite.JDBC");
	
	Connection conn = DriverManager.getConnection("jdbc:sqlite:data/bdtetris.db");
	
	ResultSet rs = stmt.executeQuery("SELECT Nombre, Apellidos FROM usuarios");
   
	while(rs.next()) {
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");

		System.out.println("Nombre;" +nombre + "apellido" + apellido);
	}
stmt.close();
conn.close();

}catch(ClassNotFoundException e) {
System.out.println("No se ha podido cargar el driver");
}catch(SQLException e) {
System.out.println("No se ha podido cargar la BD");
}
}
	}


