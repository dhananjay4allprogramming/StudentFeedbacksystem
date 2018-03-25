
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentFeedback
 */
@WebServlet("/StudentFeedback")
public class StudentFeedback extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession(false);
		String rn = (String)session1.getAttribute("Susername");
		String tname = request.getParameter("teachername");
		String sem = (String)session1.getAttribute("Ssem");
		String fsc = request.getParameter("fsc");
		String tp = request.getParameter("tp");
		String tsp = request.getParameter("tsp");
		String tsq = request.getParameter("tsq");
		String tpq = request.getParameter("tpq");
		String tb = request.getParameter("tb");
		PreparedStatement psmt = null;
	//	System.out.println(tname + fsc+tp+tsp+tsq+tpq+tb);
		List ay = (ArrayList)session1.getAttribute("list");
		ResultSet  rs = null;
		try {
			Connection con = dbConnect.getConnection();
			psmt = con.prepareStatement("insert into feedback values(?,?,?,?,?,?,?,?,?);");
			psmt.setString(1, rn);
			psmt.setString(2, tname);
			psmt.setString(3, sem);
			psmt.setString(4, fsc);
			psmt.setString(5, tp);
			psmt.setString(6, tsp);
			psmt.setString(7, tsq);
			psmt.setString(8, tpq);
			psmt.setString(9, tb);
			int recordCount = psmt.executeUpdate();
			if(recordCount>0){
				//System.out.println("Record Added...");
				ay.remove(tname);
				session1.setAttribute("list", ay);
				if(ay.isEmpty()){
					response.sendRedirect("sucessfeed.html");
				}
				else{
					response.sendRedirect("StudentHome.jsp");
				}
			}
				
			else
			{
				System.out.println(recordCount);
				//response.sendRedirect("errorpage.html");
			}
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			response.sendRedirect("errorpage.html");
		} catch (SQLException e) {
			//e.printStackTrace();
			response.sendRedirect("errorpage.html");
		}
		
	}

}
