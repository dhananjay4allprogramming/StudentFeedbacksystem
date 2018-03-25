import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class dbConnect {

	
		
		public static Connection getConnection() throws ClassNotFoundException, SQLException{

			String driverName = "com.mysql.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/puneet" ;
			String userid = "root";
			String password = "root";
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,userid,password);
			//System.out.println(con);
			return con;
			
		}


	

}
