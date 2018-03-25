

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

import com.sun.corba.se.impl.orb.PrefixParserAction;

/**
 * Servlet implementation class PassChange
 */
@WebServlet("/PassChange")
public class PassChange extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sem = request.getParameter("sem");
		String Password = request.getParameter("pass");
		int record = 0;
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement psmt = con.prepareStatement("update password set pass = ? where semester = ?;");
			psmt.setString(1, Password);
			psmt.setString(2, sem);
			record = psmt.executeUpdate();
			if(record>0){
				response.sendRedirect("sucesspasschange.html");
			}
			else{
				response.sendRedirect("errorpage.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("errorpage.html");
		}
		
	}

}
