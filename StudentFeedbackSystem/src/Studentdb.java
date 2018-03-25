

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
 * Servlet implementation class Studentdb
 */
@WebServlet("/Studentdb")
public class Studentdb extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsname = request.getParameter("Studentname");
		String newrn = request.getParameter("rn");
		String year = request.getParameter("year");
		String sem = request.getParameter("sem");
		String br = request.getParameter("br");
	//	System.out.println(newrn+ newsname + year + sem);
		PreparedStatement psmt = null;
		ResultSet  rs = null;
		try {
			Connection con = dbConnect.getConnection();
			//System.out.println(con);
			psmt = con.prepareStatement("insert into student values(?,?,?,?,?);");
			psmt.setString(1, newrn);
			psmt.setString(2, newsname);
			psmt.setString(3, br);
			psmt.setString(4, year);
			psmt.setString(5, sem);
		//	System.out.println(psmt);
			int recordCount = psmt.executeUpdate();
			if(recordCount>0){
				response.sendRedirect("SucessStu.html");
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
