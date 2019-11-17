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
			buffer += rs.getInt(1) + " " + rs.getString(2) + " " +  rs.getString(3) + " " + rs.getDouble(4) + "\n";
		return buffer;
	}
	
	public static double getPricesOfRoom(int roomID) throws SQLException {
		String queryRoom = "select * from raeume where id =";
		
		Statement stRoom = con.createStatement();
		ResultSet rsRoom = stRoom.executeQuery(queryRoom + roomID);
		if(rsRoom.next())
			return rsRoom.getDouble(3);
		return 0;
	}
	
	public static double getPricesOfVarCost(int varcostID) throws SQLException {
		String queryVarcost = "select * from varkosten where id =";
		
		Statement stVarcost = con.createStatement();
		ResultSet rsVarcost = stVarcost.executeQuery(queryVarcost + varcostID);
		if(rsVarcost.next())
			return rsVarcost.getDouble(4);
		return 0;
	}
	
	public static Connection getConnection() {
		return con;
	}

	
}
