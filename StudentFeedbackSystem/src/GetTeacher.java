

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetTeacher")
public class GetTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
   int i =1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement psmt = con.prepareStatement("Select name from teacher");
			ResultSet rs = psmt.executeQuery();
//			while(rs.next()){
//				System.out.println(rs.getString(i));
//			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
