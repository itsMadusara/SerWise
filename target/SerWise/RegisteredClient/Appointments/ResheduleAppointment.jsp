<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/15/2022
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.CS01.SerWise.Controllers.appoinmentTable" %>
<%
    int aId=Integer.parseInt(request.getParameter("Appoinment_Id"));
    HttpSession session1= request.getSession();
    session1.setAttribute("Appointment_Id",aId);
%>
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

<div class="single-content-div title center">
    <div>
        <span class="title">SerWise</span><br>
        <span>Reshedule Appointments</span>
    </div>
</div>

<div class="single-content-div center">
    <div class="single-content-div-form">
        <%
            try{
                ArrayList<String[]> results1 = appoinmentTable.select("*","Appoinment_Id="+aId);
                for (String[] i : results1){
        %>
        <div>
            <form action="../../ResheduleAppointment" method="post">
                <input name="Date" type="date" placeholder="Date" id="date" min="" max="" required value="<%=i[4]%>"><br>
                <input name="Time" type="time" placeholder="Time" id="time" min="08:00:00" max="16:00:00" step="7200" required value="<%=i[5]%>"><br>
                <input type="submit" value="Reshedule" class="button">
            </form>
        </div>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
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
<script>
    const today = new Date();
    const minDate = new Date(today.getFullYear(),today.getMonth(),today.getDate()+1);
    const maxDate = new Date(today.getFullYear(),today.getMonth()+3,today.getDate());

    // set the minimum and maximum values of the input element
    document.getElementById("date").setAttribute("min", minDate.toISOString().slice(0,10));
    document.getElementById("date").setAttribute("max", maxDate.toISOString().slice(0,10));
</script>
</html>

