

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
 * Servlet implementation class MakeResult
 */
@WebServlet("/MakeResult")
public class MakeResult extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tname = request.getParameter("tname");
		String sem = request.getParameter("sem");
		int fsc=0,tp=0,tsp=0,tsq=0,tpq=0,tb=0;
		int fsca=0,fscb=0,fscc=0,tpa=0,tpb=0,tpc=0,tspa=0,tspb=0,tspc=0,tsqa=0,tsqb=0,tsqc=0,tpqa=0,tpqb=0,tpqc=0,tba=0,tbb=0,tbc=0;
		List alist = new ArrayList<Integer>();
		int a=0;
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement psmt = con.prepareStatement("select * from feedback where teacher=? and sem=?;");
			psmt.setString(1, tname);
			psmt.setString(2, sem);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				if((Integer.parseInt(rs.getString("fsc")))>4){
					fsca++;
				}
				if(((Integer.parseInt(rs.getString("fsc")))>2)&&((Integer.parseInt(rs.getString("fsc")))<=4)){
					fscb++;
				}
				if((Integer.parseInt(rs.getString("fsc")))<=2){
					fscc++;
				}
				fsc = fsc + Integer.parseInt(rs.getString("fsc"));
				if((Integer.parseInt(rs.getString("tp")))>4){
					tpa++;
				}
				if(((Integer.parseInt(rs.getString("tp")))>2)&&((Integer.parseInt(rs.getString("tp")))<=4)){
					tpb++;
				}
				if((Integer.parseInt(rs.getString("tp")))<=2){
					tpc++;
				}
				tp = tp + Integer.parseInt(rs.getString("tp"));
				if((Integer.parseInt(rs.getString("tsp")))>4){
					tspa++;
				}
				if(((Integer.parseInt(rs.getString("tsp")))>2)&&((Integer.parseInt(rs.getString("tsp")))<=4)){
					tspb++;
				}
				if((Integer.parseInt(rs.getString("tsp")))<=2){
					tspc++;
				}
				tsp = tsp + Integer.parseInt(rs.getString("tsp"));
				if((Integer.parseInt(rs.getString("tsq")))>4){
					tsqa++;
				}
				if(((Integer.parseInt(rs.getString("tsq")))>2)&&((Integer.parseInt(rs.getString("tsq")))<=4)){
					tsqb++;
				}
				if((Integer.parseInt(rs.getString("tsq")))<=2){
					tsqc++;
				}
				tsq = tsq + Integer.parseInt(rs.getString("tsq"));
				if((Integer.parseInt(rs.getString("tpq")))>4){
					tpqa++;
				}
				if(((Integer.parseInt(rs.getString("tpq")))>2)&&((Integer.parseInt(rs.getString("tpq")))<=4)){
					tpqb++;
				}
				if((Integer.parseInt(rs.getString("tpq")))<=2){
					tpqc++;
				}
				tpq = tpq + Integer.parseInt(rs.getString("tpq"));
				if((Integer.parseInt(rs.getString("tb")))>4){
					tba++;
				}
				if(((Integer.parseInt(rs.getString("tb")))>2)&&((Integer.parseInt(rs.getString("tb")))<=4)){
					tbb++;
				}
				if((Integer.parseInt(rs.getString("tb")))<=2){
					tbc++;
				}
				tb = tb + Integer.parseInt(rs.getString("tb"));
				
				a++;
			}
			//System.out.println(a + "  " + fsc + " "+tp+ " " + tsp+ " " +tsq+ " " + tpq + " " + tb);
			fsc = fsc/a;
			tp = tp/a;
			tsp = tsp/a;
			tsq = tsq/a;
			tpq = tpq/a;
			tb = tb/a;
			//System.out.println( fsc + " "+tp+ " " + tsp+ " " +tsq+ " " + tpq + " " + tb);
			int average = (fsc+tp+tsp+tsq+tpq+tb)/6;
			//System.out.println(average);
			HttpSession session = request.getSession(false);
			alist.add(fsc);
			alist.add(tp);
			alist.add(tsp);
			alist.add(tsq);
			alist.add(tpq);
			alist.add(tb);
			alist.add(average);
			alist.add(fsca);
			alist.add(fscb);
			alist.add(fscc);
			alist.add(tpa);
			alist.add(tpb);
			alist.add(tpc);
			alist.add(tspa);
			alist.add(tspb);
			alist.add(tspc);
			alist.add(tsqa);
			alist.add(tsqb);
			alist.add(tsqc);
			alist.add(tpqa);
			alist.add(tpqb);
			alist.add(tpqc);
			alist.add(tba);
			alist.add(tbb);
			alist.add(tbc);
			alist.add(tname);
			session.setAttribute("alist", alist);
			response.sendRedirect("ShowResult.jsp");
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			response.sendRedirect("errorpage.html");
		}
	}

}
