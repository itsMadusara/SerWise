<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/5/2022
  Time: 6:03 AM
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
    <span>Make Appointments</span>
  </div>
  <div>
    <div class="colomn-content-div">
      <div>
        <span class="title">Lube Appointments</span><br>
        <span>Regular maintenance and lube services help prolong the life of the equipment, optimize performance, and prevent costly repairs.</span><br>
        <a href="makeLubeAppointment.jsp"><button class="button">Make Now</button></a>
      </div>
      <div>
        <span class="title">Check Up Appointments</span><br>
        <span>Problem in your vehicle? Come to us. We can help your.</span><br>
        <a href="makeCheckupAppointment.jsp"><button class="button">Make Now</button></a>
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
