<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Teacher</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <style>
body {
    font-family: "Lato", sans-serif;
    background: #1E547F;
    color: #fff;
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
    .wel{
        font-size: 40px;
        font-family: fantasy;
        margin-top: 17%;
    }
    .container{
        text-align: center;
    }
@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
    </head>
<body>

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
<div class="container">
    <div class="col-sm-offset-2"><h2>Add Teacher</h2></div><br><br><br>
  <form class="form-horizontal" action="Teacherdb" name="addteacher" method="post">
    <div class="form-group">
      <label class="col-sm-2 control-label">Enter Name</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Teacher Name" name="Teachername" required="required" >
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-2 control-label">Enter mobile no</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter mobileno" name="mn" maxlength="10" required="required">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-2 control-label">Enter subject</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter subject " name="sub" required="required">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-2 control-label">Enter department</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter dept" name="dept" required="required">
      </div>
    </div>
       <div class="form-group">
      <label class="col-sm-2 control-label">Enter Semester</label>
      <div class="col-sm-10">
        <input class="form-control" type="text" placeholder="Enter Semester" name="sem"  maxlength="1" required="required">
      </div>
    </div>
       <div class="form-group">
      <div class="col-sm-1 col-sm-offset-2">
        <button type="reset" class="btn btn-default">Reset</button>
      </div>
           <div class="col-sm-2">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
    </form>
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