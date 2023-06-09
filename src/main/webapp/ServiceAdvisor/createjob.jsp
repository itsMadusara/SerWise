<%@ page import="java.sql.Connection" %>
<%@ page import="com.CS01.SerWise.DatabaseConnection" %>
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
<%
  if (session.getAttribute("auth")==null){
    response.sendRedirect("../Login/login.html");
  }
  else {
    if (!session.getAttribute("auth").toString().equals("3")) {
      out.println("invalid authentication");
      out.println(session.getAttribute("auth"));
    }
  }
%>

<%@ page import ="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.io.IOException"%>

<%
  class job{
    Integer app_id;
    Date date;
    String time;
    Integer V_No;

  }
  List<job> data = new ArrayList<job>();

  try{
    Connection con = DatabaseConnection.initializeDatabase();
    PreparedStatement ps = con.prepareStatement("select * from serwise.appoinment");
    ResultSet rs = ps.executeQuery();

    while(rs.next()){
      job ap = new job();
      ap.app_id=rs.getInt("Appoinment_Id");
      ap.date=rs.getDate("Date");
      ap.time=rs.getString("Time");
      ap.V_No=rs.getInt("Vehicle_id");
      data.add(ap);
    }
  }
  catch(SQLException sq){
    response.sendRedirect("Errsql.html");
  }
  catch(ClassNotFoundException cq){
    response.sendRedirect("Err.html");
  }
//  out.println("<table>");
//  out.println("</table>");
%>

<header class="navigation">
  <img src="../Assets/SerWise.png" class="navimg">
  <table>
    <tr>
      <td><a href="Home.jsp">Home</a></td>
      <td><a href="#">Inventory</a></td>
      <td><a href="job.jsp" style="color:#EE534F">Jobs</a></td>
      <td><a href="#">Slots</a></td>
      <td><a href="../ServletLogout"><button class="button">Logout</button></a></td>
    </tr>
  </table>
</header>

<div>

  <div class="single-content-div center title">
    <span class="title">SerWice &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Appointment</span>
  </div>

  <div class="single-content-div center title">
    Search By Appointment ID : &MediumSpace;
    <form>
      <input type="text" placeholder="Employee ID">
      &MediumSpace;
      <input type="submit" value="Search" class="button">
    </form>
  </div>

  <div class="single-content-div center form-display-table">
    <table>
      <tr>
        <th>Appointment ID</th>
        <th>Date</th>
        <th>Time</th>
        <th>Vehicle No</th>
        <th>Create Job</th>
      </tr>
      <%
        for(Integer i = 0; i<data.size();i++){
          out.println("<tr><td>"+data.get(i).app_id+"</td><td>"+data.get(i).date+"</td><td>"+data.get(i).time+"</td><td>"+data.get(i).V_No+"</td><td><a href=\"jobadd.jsp?date="+data.get(i).date+"&id="+data.get(i).app_id+"&time="+data.get(i).time+"\"><button class=\"button\">Create Job</button></a></td></tr>");
        }
      %>
    </table>
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