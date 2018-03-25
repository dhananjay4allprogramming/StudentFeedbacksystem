

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

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("tname");
		String Subject = request.getParameter("subject");
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement psmt = con.prepareStatement("delete from teacher where name=? and subject=?;");
			psmt.setString(1, name);
			psmt.setString(2, Subject);
			int rs = psmt.executeUpdate();
			if(rs>0){
				response.sendRedirect("sucessdelT.html");
			}
			else{
				response.sendRedirect("errorpage.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("errorpage.html");
		} 
	}

}
