

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdmiinLogin
 */
@WebServlet("/AdmiinLogin")
public class AdminLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Ausername = request.getParameter("adminname");
		String Apassword = request.getParameter("adminpass");
		//System.out.println(Ausername + Apassword);
		if(Ausername.equalsIgnoreCase("Admin")||Apassword.equalsIgnoreCase("admin")){
			response.sendRedirect("adminhome.html");
		}
		else{
			response.sendRedirect("Adminlogin.html");
		}
	}

}
