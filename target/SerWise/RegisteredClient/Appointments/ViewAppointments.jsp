<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/10/2022
  Time: 1:36 PM
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
        <span>Appointments</span>
    </div>
    <div>
        <div class="colomn-content-div">
            <div>
                <span class="title">Ongoing Appointments</span><br>
                <span>You can effectively manage ongoing appointments and ensure that your vehicle receives regular maintenance to keep it running smoothly.</span><br>
                <a href="SelectOngoingAppointment.jsp"><button class="button">View</button></a>
            </div>
            <div>
                <span class="title">Previous Appointments</span><br>
                <span>The necessary details about your previous appointments and services performed on your vehicle.</span><br>
                <a href="SelectPreviousAppointment.jsp"><button class="button">View</button></a>
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
