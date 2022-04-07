import java.sql.*;
import java.util.ResourceBundle;

public class DBHandler {
    
	public Connection establishConnection() throws SQLException, ClassNotFoundException 
	{
		ResourceBundle rb=ResourceBundle.getBundle("db");
		String driver=rb.getString("db.classname");
		String url=rb.getString("db.url");
		String username=rb.getString("db.username");
		String password=rb.getString("db.password");
		Class.forName(driver);
		return DriverManager.getConnection(url,username,password);
	}

}
