<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/13/2022
  Time: 5:42 AM
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
<header class="navigation">
  <img src="../../Assets/SerWise.png" class="navimg">
  <table>
    <tr>
      <td><a href="../Home/home.jsp ">Home</a></td>
      <td><a href="../Services/services.jsp">Services</a></td>
      <td><a href="../Appointments/appointments.jsp">Appointments</a></td>
      <td><a href="../Vehicles/vehicles.jsp">Vehicles</a></td>
      <td><a href="../Profile/profile..jsp">Profile</a></td>
      <td><a href="../../ServletLogout"><button class="button">Logout</button></a></td>
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
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
  </div>
  <div class="colomn-content-div">
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
    </div>
    <div>
      <span class="subtitle">Car Wash</span><br>
      <span>We offer the best service with a friendly staff for you to get your work done
                    in the fastest way possible.
                </span>
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
</body>
</html>