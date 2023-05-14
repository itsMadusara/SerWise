 <%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/13/2022
  Time: 5:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../CSS/content.css">
  <link rel="stylesheet" href="../../CSS/navigation.css">
  <link rel="stylesheet" href="../../CSS/footer.css">
  <link rel="stylesheet" href="../../CSS/backgrount.css">
  <title>Profile</title>
</head>
<body>
<%
  if (session.getAttribute("uid")==null){
    response.sendRedirect("../../Login/login.html");
  }
%>
<header class="navigation"></header>
<div class="two-content-div">
  <div class="two-content-div-one">
    <span class="title">Profile</span><br>
    <span>User Information</span><br>
    <span><img src="../../Assets/ProfilePic.jpg" class="logo"></span>
  </div>
  <div class="two-content-div-form">
    <form name="rform" action="#" method="post">
      <input type="text" name="Fname" placeholder="First Name" required><br>
      <input type="text" name="Lname" placeholder="Last Name" required><br>
      <input type="tel" name="Contact" pattern="[0-9]{10}" placeholder="Contact" required><br>
      <input type="email" name="Email" placeholder="Email" required><br>
      <input type="password" name="pswd" pattern="{8,}" id="password" placeholder="Password" required><br>
      <div id="err"></div>
      <h4 style="color: #EE534F"><%= request.getParameter("message") %></h4>
      <input type="submit" value="Register" onclick=return validate()" class="button">
    </form>
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
