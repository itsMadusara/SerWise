<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/3/2022
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../CSS/content.css">
  <link rel="stylesheet" href="../../CSS/navigation.css">
  <link rel="stylesheet" href="../../CSS/footer.css">
  <link rel="stylesheet" href="../../CSS/backgrount.css">
  <title>Document</title>
</head>
<body>
<%
  if (session.getAttribute("uid")==null){
    response.sendRedirect("../../Login/login.html");
  }
%>
<header class="navigation"></header>

<div class="two-content-div">
  <div>
    <span class="title">SerWise</span><br>
    <span>Your Vehicles</span>
  </div>
  <div>
    <div class="colomn-content-div">
      <div>
        <span class="title">Add New Vehicle</span><br>
        <span>Make an appointment to get the best services.
                        Make an appointment to get the best services</span><br>
        <a href="addVehicle.jsp"><button class="button">Click Here</button></a>
      </div>
      <div>
        <span class="title">View Your Vehicles</span><br>
        <span>View your appointments here to keep track.
                        View your appointments here to keep track.</span><br>
        <a href="selectVehicle.jsp"><button class="button">Click Here</button></a>
      </div>
    </div>
  </div>
</div>


<footer class="footer">
  <div class="center"><img src="../../Assets/SerWise.png" class="logo"></div>
  <div class="center"><a href="#"> Contact Us </a> &nbsp|
    &nbsp<a href="#"> About Us </a> &nbsp|
    &nbsp <a href="#"> Legal Stuff </a></div>
  <div class="center">All Rights Recieved</div>
</footer>
<script src="/SerWise_war/RegisteredClient/RegisteredClientHeader.js"></script>
</body>
</html>
