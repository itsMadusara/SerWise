<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/13/2022
  Time: 5:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("uid")==null){
        response.sendRedirect("../../Login/login.jsp");
%>
<header class="navigation">
    <img src="../../Assets/SerWise.png" class="navimg">
    <table>
        <tr>
            <td><a href="../Home/home.jsp ">Home</a></td>
            <td><a href="../Services/services.jsp">Services</a></td>
            <td><a href="../Appointments/appointments.jsp">Appointments</a></td>
            <td><a href="../Vehicles/vehicles.jsp">Vehicles</a></td>
            <td><a href="../Profile/profile..jsp">Profile</a></td>
            <td><a href="../../Logout/logout.jsp"><button class="button">Logout</button></a></td>
        </tr>
    </table>
</header>
</body>
</html>
