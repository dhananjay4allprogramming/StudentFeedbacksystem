

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
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Susername = request.getParameter("studentname");
		String Spassword = request.getParameter("studentpass");
		HttpSession session1 = request.getSession(true); 
		List<String> al = new ArrayList<String>();
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement psmt = con.prepareStatement("select branch,semester from student where rollno=?;");
			psmt.setString(1, Susername);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()){
				String Sbranch = rs.getString("branch");
				String Ssem = rs.getString("semester");
				PassCheck pc = new PassCheck();
				String pass = pc.getpass(Ssem);
				if(Spassword.equalsIgnoreCase(pass)){
				//	System.out.println(Sbranch + Ssem);
					Connection con1 = dbConnect.getConnection();
					PreparedStatement psmt1 = con1.prepareStatement("select name from teacher where dept=? and semester=?;");
				//	System.out.println(psmt1);
					psmt1.setString(1, Sbranch);
					psmt1.setString(2, Ssem);
					ResultSet rs1 = psmt1.executeQuery();
					session1.setAttribute("Susername", Susername);
					session1.setAttribute("Sbranch", Sbranch);
					session1.setAttribute("Ssem", Ssem);
					int i=1;
					while(rs1.next()){
						//System.out.println(rs1.getString(i));
						al.add(rs1.getString(i));
					}
//					for(int j=0;j<al.size();j++){
//						System.out.println(al.get(j));
//					}
					session1.setAttribute("list", al);
					response.sendRedirect("StudentHome.jsp");
					rs = null;
				}
				else{
					response.sendRedirect("stulogin.html");
				}
				}
				
			else{
				response.sendRedirect("stulogin.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("errorpage.html");
		}
		

	}

}
