

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetTeacherNames
 */
@WebServlet("/GetTeacherNames")
public class GetTeacherNames extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<String> name = new ArrayList<String>();
		 HttpSession session = request.getSession(false);
		 String sem = request.getParameter("sem");
		 try {
			Connection con = dbConnect.getConnection();
			PreparedStatement psmt = con.prepareStatement("Select name from teacher where semester=?;");
			psmt.setString(1,sem);
			ResultSet rs = psmt.executeQuery();
			int i = 1;
			while(rs.next()){
				name.add(rs.getString(i));
			}
			session.setAttribute("sem", sem);
			session.setAttribute("name", name);
			response.sendRedirect("Getresult.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
