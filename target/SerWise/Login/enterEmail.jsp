<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/11/2022
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../CSS/content.css">
  <link rel="stylesheet" href="../CSS/navigation.css">
  <link rel="stylesheet" href="../CSS/footer.css">
  <link rel="stylesheet" href="../CSS/backgrount.css">
  <title>Document</title>
</head>
<body>
<header class="navigation">
  <img src="../Assets/SerWise.png" class="navimg">
  <table>
    <tr>
      <td><a href="../Home/home.jsp">Home</a></td>
      <td><a href="../UnregisteredClient/Services/selectBranch.jsp">Services</a></td>
      <td><a href="../UnregisteredClient/Register/register.jsp">Register</a></td>
      <td><a href="../Login/login.jsp"><button class="button">Login</button></a></td>
    </tr>
  </table>
</header>

<div class="two-content-div">
  <div class="two-content-div-one">
    <span class="title">SerWise</span><br>
    <span>Forgot Password</span>
  </div>
  <div class="two-content-div-form">
    <span class="subtitle">Email</span>
    <form action="forgetPassword.jsp" method="post">
      <label>Email:</label>
      <input type="text" name="id" placeholder="Enter Email" required><br>
      <input type="submit" value="Next" class="button"> &MediumSpace;
    </form>
  </div>
</div>

<footer class="footer">
  <div class="center"><img src="../Assets/SerWise.png" class="logo"></div>
  <div class="center"><a href="#"> Contact Us </a> &nbsp|
    &nbsp<a href="#"> About Us </a> &nbsp|
    &nbsp <a href="#"> Legal Stuff </a></div>
  <div class="center">All Rights Recieved</div>
</footer>
</body>
</html>
