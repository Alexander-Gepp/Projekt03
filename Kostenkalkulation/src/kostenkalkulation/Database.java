package kostenkalkulation;

import java.sql.*;

public class Database {
	
	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static String connectionPrefix = "jdbc:mysql:";
	private static Connection con;
	
	public static void createDatabaseConnection(String ip, String port, String dbname, String user, String password) 
	throws SQLException, ClassNotFoundException {
		Class.forName(dbDriver);
		con=DriverManager.getConnection(  
		connectionPrefix + "//" + ip + ":" + port + "/" + dbname, user, password);
		//here sonoo is database name, root is username and password  
	}
	
	public static String createStatementRoom(String statement) throws SQLException {
		String buffer = "";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(statement);
		while(rs.next())
			buffer += rs.getInt(1) + " " + rs.getString(2) + " " +  rs.getDouble(3) + "\n";
		return buffer;
	}
	
	public static String createStatementVarCost(String statement) throws SQLException {
		String buffer = "";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(statement);
		while(rs.next())
			buffer += rs.getInt(1) + " " + rs.getString(2) + " " +  rs.getString(3) + rs.getDouble(4) + "\n";
		return buffer;
	}
	
	public static Connection getConnection() {
		return con;
	}

	
}
