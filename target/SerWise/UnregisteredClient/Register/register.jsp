<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 11/22/2022
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.CS01.SerWise.Services.Hash"%>
<!DOCTYPE html>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/content.css">
    <link rel="stylesheet" href="../../CSS/navigation.css">
    <link rel="stylesheet" href="../../CSS/footer.css">
    <link rel="stylesheet" href="../../CSS/backgrount.css">
    <title>Register</title>
</head>
<body>
<header class="navigation">
    <img src="../../Assets/SerWise.png" class="navimg">
    <table>
        <tr>
            <td><a href="../../Home/home.jsp">Home</a></td>
            <td><a href="../Services/selectBranch.jsp">Services</a></td>
            <td><a href="register.jsp">Register</a></td>
            <td><a href="../../Login/login.jsp"><button class="button">Login</button></a></td>
        </tr>
    </table>
</header>


<div class="two-content-div">
    <div class="two-content-div-one">
        <span class="title">SerWise</span><br>
        <span>Register</span>
    </div>
    <div class="two-content-div-form">
        <span class="subtitle">Register</span>
        <form id="reform" action="../../ServletRegister" method="post">
            <input type="text" id="Fname" name="Fname" placeholder="First Name" required> <br>
            <input type="text" id="Lname" name="Lname" placeholder="Last Name" required><br>
            <input type="tel" id="phone" name="Contact" pattern="[0-9]{10}" placeholder="Contact" required><br>
            <input type="email" id="email" name="Email" placeholder="Email" required><br>
            <input type="password" id="password" name="pswd" placeholder="Password" required><br>
            <input type="password" id="confirm_password" name="confirm_password" placeholder="Confirm Password" required><br>
            <div style="color:red" id="err"></div>
            <%
                String msg=request.getParameter("message");
                if(msg==null){
                    msg="";
                }
            %>
            <br><h4 style="color: #EE534F"><%=msg%></h4>
            <button type="submit" id="submitButton" class="button" >Register</button>
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
<script src="register.js"></script>
</body>
</html>