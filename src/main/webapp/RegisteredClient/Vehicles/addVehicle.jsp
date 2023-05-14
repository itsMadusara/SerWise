<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/3/2022
  Time: 9:15 AM
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

<div class="single-content-div title center">
  <div>
    <span class="title">Add your vehicle details</span><br>
  </div>
</div>

<div class="single-content-div center">
  <div class="single-content-div-form">
    <div>
      <form action="../../ServletAddVehicle" method="post">
        <select name="Type" class="drop-down-list" required>
          <option value="Car">Car</option>
          <option value="SUV">SUV</option>
          <option value="Bike">Bike</option>
          <option value="ThreeWheel">Three Wheel</option>
          <option value="Commercial Light-Weight">Commercial Light-Weight</option>
          <option value="Commercial Heavy-Weight">Commercial Heavy-Weight</option>
        </select><br>
        <input name="Reg" type="text" placeholder="Vehicle Reg Number" pattern="[A-Z0-9-]{7,8}" required><br>
        <div style="color:red" id="err"></div>
        <%
          String msg=request.getParameter("message");
          if(msg==null){
            msg="";
          }
        %>
        <h4 style="color: #EE534F"><%=msg%></h4>
        <select id="selectbrand" name="Brand" required></select><br>
        <input name="Model" type="text" placeholder="Model" required><br>
        <select name="FuelType" class="drop-down-list" required>
          <option value="Petrol">Petrol</option>
          <option value="Disel">Disel</option>
          <option value="Petrol">Hybrid</option>
          <option value="Disel">Electric</option>
        </select><br>
        <input name="EC" type="text" placeholder="Engine Capacity" required><br>
        <input type="submit" value="ADD VEHICLE" class="button">
      </form>
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
<script src="addVehicle.js"></script>
</body>
</html>
