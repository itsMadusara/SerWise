<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/3/2022
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.CS01.SerWise.Controllers.vehicleTable" %>
<%@ page import="java.util.ArrayList" %>
<%
  HttpSession session1=request.getSession();
  int id=(Integer)session1.getAttribute("uid");
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
    <span class="title">Select Vehicle</span><br>
  </div>
</div>



<div class="two-content-div">
  <div class="colomn-content-div">
    <%
      try{
        ArrayList<String[]> results1 = vehicleTable.select("*","Registered_Client_Id="+id);
        for (String[] i : results1){
    %>
    <div>
      <span class="subtitle"><%=i[4]%></span>
    </div>
    <%
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    %>
  </div>
  <div class="colomn-content-div">
    <%
      try{
        ArrayList<String[]> results1 = vehicleTable.select("*","Registered_Client_Id="+id);
        for (String[] i : results1){
    %>
    <div>
      <form method="post" action="viewVehicle.jsp">
        <input type="submit" value="View Details" class="button"/>
        <input type = "hidden" name="Vehicle_Id" value="<%=i[0]%>" class="button" />
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