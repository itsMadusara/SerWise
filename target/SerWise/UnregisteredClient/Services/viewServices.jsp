<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 4/18/2023
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.CS01.SerWise.Controllers.serviceBranchTable" %>
<%@ page import="com.CS01.SerWise.Controllers.serviceTable" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
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
<header class="navigation">
    <img src="../../Assets/SerWise.png" class="navimg">
    <table>
        <tr>
            <td><a href="../../Home/home.jsp">Home</a></td>
            <td><a href="#">Services</a></td>
            <td><a href="../Register/register.jsp">Register</a></td>
            <td><a href="../../Login/login.jsp"><button class="button">Login</button></a></td>
        </tr>
    </table>
</header>

<div class="single-content-div title">
    <div>
        <span class="title">Services</span><br>
        <span class="subtitle">Enjoy the best services</span>
    </div>
</div>

<div class="two-content-div">
    <div class="colomn-content-div">
        <%
            int bId=Integer.parseInt(request.getParameter("Branch_Id"));
            try{
                ArrayList<String[]> results1 = serviceBranchTable.select("Service_Id","Branch_Id="+bId);
                for (String[] i : results1){
                    ArrayList<String[]> results2 = serviceTable.select("Name","Service_Id="+i[0]);
                    for (String[] j : results2){
        %>
        <div>
            <span class="subtitle"><%=j[0]%></span><br>
        </div>
        <%
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
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
</body>
</html>
