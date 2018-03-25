

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rollno = request.getParameter("rollno");
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement psmt = con.prepareStatement("delete from student where rollno=?;");
			psmt.setString(1, rollno);
			int rs = psmt.executeUpdate();
			if(rs>0){
				response.sendRedirect("sucessdelS.html");
			}
			else{
				response.sendRedirect("errorpage.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("errorpage.html");
		}
		
	}

}
