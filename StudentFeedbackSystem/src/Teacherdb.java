

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
 * Servlet implementation class Teacherdb
 */
@WebServlet("/Teacherdb")
public class Teacherdb extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newtname = request.getParameter("Teachername");
		String newmn = request.getParameter("mn");
		String sub = request.getParameter("sub");
		String dept = request.getParameter("dept");
		String sem = request.getParameter("sem");
		PreparedStatement psmt = null;
		ResultSet  rs = null;
		try {
			Connection con = dbConnect.getConnection();
			//System.out.println(con);
			psmt = con.prepareStatement("insert into teacher values(?,?,?,?,?);");
			psmt.setString(1, newtname);
			psmt.setString(2, newmn);
			psmt.setString(3, sub);
			psmt.setString(4, dept);
			psmt.setString(5, sem);
			//System.out.println(psmt);

			int recordCount = psmt.executeUpdate();
			if(recordCount>0){
				response.sendRedirect("SucessTeacher.html");
			}
			else
			{
				response.sendRedirect("errorpage.html");
			}
		} catch (ClassNotFoundException e) {
			response.sendRedirect("errorpage.html");
		} catch (SQLException e) {
			//e.printStackTrace();
			response.sendRedirect("errorpage.html");
		}
		
	}

}
