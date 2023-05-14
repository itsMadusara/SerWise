<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/15/2022
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.CS01.SerWise.Controllers.appoinmentTable" %>
<%
  int aId=Integer.parseInt(request.getParameter("Appoinment_Id"));
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
  <%
    try{
      ArrayList<String[]> results1 = appoinmentTable.select("*","Appoinment_Id="+aId);
      for (String[] i : results1){
  %>
  <div>
    <span class="title">A00<%=aId %></span><br>
  </div>
  <%
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  %>
</div>

<div class="single-content-div center">
  <div class="single-content-div-form">
    <%
      try{
        ArrayList<String[]> results1 = appoinmentTable.select("*","Appoinment_Id="+aId);
        for (String[] i : results1){
    %>
    <div class="form-display-table">
      <table>
        <tr><td>Date : <%=i[1]%></td></tr>
        <tr><td>Time : <%=i[2]%></td></tr>
        <tr><td>Type : <%=i[3]%></td></tr>
      </table><br>
      <form method="post" action="../../RemoveAppointment">
        <input type="submit" value="Remove Appointment" class="button"/>
        <input type = "hidden" name="Appoinment_Id" value="<%=aId %>" class="button" />
      </form>
      <form method="post" action="ResheduleAppointment.jsp">
        <input type="submit" value="Reshedule Appointment" class="button"/>
        <input type = "hidden" name="Appoinment_Id" value="<%=aId %>" class="button" />
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
</html>
