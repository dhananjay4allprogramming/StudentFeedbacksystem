import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PassCheck {

	  String password = null;
      
	public String getpass(String sem){
		try {
			Connection con2 = dbConnect.getConnection();
			PreparedStatement psmt2 = con2.prepareStatement("select * from password where semester=?;");
			psmt2.setString(1, sem);
			ResultSet rs2 = psmt2.executeQuery();
			while (rs2.next()) {
			//	System.out.println(rs2.getString("pass"));
				return rs2.getString("pass");
			}
		//	password = rs2.getString(1);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	}


