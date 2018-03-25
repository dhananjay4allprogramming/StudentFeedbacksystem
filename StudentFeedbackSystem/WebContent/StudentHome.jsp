<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Feedback</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
     <script language="Javascript" type="text/javascript">
 
        function onlyNos(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if (charCode > 31 && (charCode < 48 || charCode > 53)) {
                    return false;
                }
                return true;
            }
            catch (err) {
                alert(err.Description);
            }
        }
 
    </script>
    </head>
<body>

<div class="container">
    <div class="col-sm-offset-5"><h2>Student Feedback</h2></div><br><br>
    <%
 	HttpSession session1 = request.getSession(false);
     String Susername =(String) session1.getAttribute("Susername");
     %>
     <div class="col-sm-offset-5">
     <% 
     out.println("RollNO : " + Susername + "<br>");
 	String sem = (String)session1.getAttribute("Ssem");
 	String branch = (String)session1.getAttribute("Sbranch");
 	out.println("Branch : "+ branch + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"Semester : "+sem);
	ArrayList<String> ay = (ArrayList<String>)session1.getAttribute("list");
   %>
   </div>
   <br><br>
  <form class="form-horizontal" action="StudentFeedback" name="GiveFeedback" method="post">
      <div class="form-group">
      <label class="col-sm-6 control-label"  for="sel1">Select your teacher</label>
      <div class="col-sm-4">
        <select class="form-control" id="sel1" name="teachername">
        <option>Select teacher</option>    
        <%	
		for(int i=0;i<ay.size();i++){%>
			<option name="<%ay.get(i);%>"><%out.println(ay.get(i));%></option><%
		}
        %>
      </select>
      </div>
    </div> 
    <div class="form-group">
      <label class="col-sm-6 control-label">Are you understanding Subject clearly?</label>
      <div class="col-sm-4">
        <input class="form-control" type="number" name="fsc" placeholder="Enter values between 1 and 5" required="required" maxlength="1" min="1" max="5">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-6 control-label">Is the teacher punctual?</label>
      <div class="col-sm-4">
        <input class="form-control" type="number" name="tp" placeholder="Enter values between 1 and 5"  required="required" maxlength="1" min="1" max="5">
      </div>
    </div>
      <div class="form-group">
      <label class="col-sm-6 control-label">Is the teacher telling the subject properly?</label>
      <div class="col-sm-4">
       <!-- <input class="form-control" type="text" name="tsp" placeholder="Enter values between 1 and 5" onmousedown="return onlyNos(event,this);" required="required" maxlength="1">-->
        <input class="form-control" type="number" name="tsp" placeholder="Enter values between 1 and 5" required="required" maxlength="1" min="1" max="5">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-6 control-label">Is the teacher available for solving queries?</label>
      <div class="col-sm-4">
        <input class="form-control" type="number" name="tsq" placeholder="Enter values between 1 and 5" min="1" max="5" required="required" maxlength="1">
      </div>
    </div>
   <div class="form-group">
      <label class="col-sm-6 control-label">Are prevoius year question papers solved by teacher?</label>
      <div class="col-sm-4">
        <input class="form-control" type="number" name="tpq" placeholder="Enter values between 1 and 5" min="1" max="5" required="required" maxlength="1">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-6 control-label">Give number on teacher behaviour</label>
      <div class="col-sm-4">
        <input class="form-control" type="number" name="tb" placeholder="Enter values between 1 and 5" min="1" max="5" required="required" maxlength="1">
      </div>
    </div>
       <div class="form-group">
      <div class="col-sm-1 col-sm-offset-6">
        <button type="reset" class="btn btn-default">Reset</button>
      </div>
           <div class="col-sm-2">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
    </form>
    </div>
    </body>
</html>