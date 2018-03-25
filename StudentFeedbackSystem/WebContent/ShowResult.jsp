<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Show Results</title>
	 <link href="bootstrap/css/bootstrap.min.css" />
	   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
    text-align:center;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s

}

.sidenav a:hover{
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}
    #addt{
        font-family: fantasy;
        font-size: 40px;
        margin-top: 17%;
        margin-left: 37%;
    }

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
h3{
 margin-left: 25%;
 margin-top: 20px;
}
h4{
margin-top:-30px;
 margin-left: 40%;
}
</style>
</head>
<body>
<%
HttpSession session1 = request.getSession(false);
	List alist = (ArrayList)session.getAttribute("alist");
%>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <br><br>
    <a href="adminhome.html">Home</a>
  <a href="addStudent.jsp" >Add Student</a>
<a href="delStudent.jsp" >Delete Student</a>
<a href="addTeacher.jsp" >Add Teacher</a>
<a href="delTeacher.jsp" >Delete Teacher</a>
<a href="GetSemester.jsp" >Show Results</a>
<a href="Passkey.jsp">Passkey</a>
<a href="logout.jsp">Logout</a>
</div>

&nbsp;<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
<h3>Teacher Name:</h3><h4><%out.println(alist.get(25));%></h4>
<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Questions</th>
        <th>Results</th>
        <th>More</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Understanding of subject by Students :</td>
        <td><%out.println(alist.get(0));%></td>
        <td><button type="button" class="btn btn-success" data-toggle="collapse" data-target="#demo">Details</button></td>
      </tr>
      <tr id="demo" class="collapse">
        <th>Marks > 4  &rarr;<%out.println(alist.get(7));%></th>
        <th>4 > Marks >2  &rarr;<%out.println(alist.get(8));%></th>
         <th>Marks < 2  &rarr;<%out.println(alist.get(9));%></th>
      </tr>
      <tr>
        <td>Punctuality :</td>
        <td><%out.println(alist.get(1));%></td>
        <td><button type="button" class="btn btn-success" data-toggle="collapse" data-target="#demo1">Details</button></td>
      </tr>
      <tr id="demo1" class="collapse">
         <th>Marks > 4  &rarr;<%out.println(alist.get(10));%></th>
        <th>4 > Marks >2  &rarr;<%out.println(alist.get(11));%></th>
         <th>Marks < 2  &rarr;<%out.println(alist.get(12));%></th>
      </tr>
     <tr>
        <td>Teacher taught Subject Clearly :</td>
        <td><%out.println(alist.get(2));%></td>
        <td><button type="button" class="btn btn-success"  data-toggle="collapse" data-target="#demo2">Details</button></td>
      </tr>
      <tr id="demo2" class="collapse">
        <th>Marks > 4 &rarr;<%out.println(alist.get(13));%></th>
        <th>4 > Marks >2  &rarr;<%out.println(alist.get(14));%></th>
         <th>Marks < 2  &rarr;<%out.println(alist.get(15));%></th>
      </tr>
      <tr>
        <td>Availablity of Teacher for queries :</td>
        <td><%out.println(alist.get(3));%></td>
        <td><button type="button" class="btn btn-success"  data-toggle="collapse" data-target="#demo3">Details</button></td>
      </tr>
      <tr id="demo3" class="collapse">
        <th>Marks > 4  &rarr;<%out.println(alist.get(16));%></th>
        <th>4 > Marks >2  &rarr;<%out.println(alist.get(17));%></th>
         <th>Marks < 2  &rarr;<%out.println(alist.get(18));%></th>
      </tr>
      <tr>
        <td>Solution prevoius year ques papers :</td>
        <td><%out.println(alist.get(4));%></td>
        <td><button type="button" class="btn btn-success"  data-toggle="collapse" data-target="#demo4">Details</button></td>
      </tr>
      <tr id="demo4" class="collapse">
        <th>Marks > 4  &rarr;<%out.println(alist.get(19));%></th>
        <th>4 > Marks >2  &rarr;<%out.println(alist.get(20));%></th>
         <th>Marks < 2  &rarr;<%out.println(alist.get(21));%></th>
      </tr>
      <tr>
        <td>Teacher Behaviour :</td>
        <td><%out.println(alist.get(5));%></td>
        <td><button type="button" class="btn btn-success" data-toggle="collapse" data-target="#demo5">Details</button></td>
      </tr>
      <tr id="demo5" class="collapse">
        <th>Marks > 4  &rarr;<%out.println(alist.get(22));%></th>
        <th>4 > Marks >2  &rarr;<%out.println(alist.get(23));%></th>
         <th>Marks < 2  &rarr;<%out.println(alist.get(24));%></th>
      </tr>
      <tr>
        <td>Total Average Rating :</td>
        <td><%out.println(alist.get(6));%></td>
        <td></td>
      </tr>
    </tbody>
  </table>
</div>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "100%";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
</body>
</html>