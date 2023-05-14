<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/SerWise_war/CSS/content.css">
  <link rel="stylesheet" href="/SerWise_war/CSS/navigation.css">
  <link rel="stylesheet" href="/SerWise_war/CSS/footer.css">
  <link rel="stylesheet" href="/SerWise_war/CSS/backgrount.css">
  <title>Document</title>
</head>
<body>
  <%
    if (session.getAttribute("auth")==null){
      response.sendRedirect("/SerWise_war/Login/login.html");
    }
    else {
      if (!session.getAttribute("auth").toString().equals("2")) {
        out.println("invalid authentication");
        out.println(session.getAttribute("auth"));
      }
    }
  %>
<header class="navigation"></header>


<div class="two-content-div">
  <div>
    <span class="title">SerWise</span><br>
    <span class="subtitle">Manage Branches</span>
  </div>
  <div class="two-content-div-form">
    <form method="post" action="/SerWise_war/updateBranchDetails">
      <input type="text" name="branchID" placeholder="Branch ID" pattern="[0-9]+" value="<% out.println(request.getAttribute("branchID")); %>" readonly><br>
      <input type="text" name="location" placeholder="Branch Location (City)" value="<% out.println(request.getAttribute("location")); %>" required><br>
      <input type="text" name="address" placeholder="Address" value="<% out.println(request.getAttribute("address")); %>" required><br>
      <input type="text" name="noOfSlots" placeholder="No of Slots" pattern="[0-9]+" value="<% out.println(request.getAttribute("noOfSlots")); %>" required><br>
      <input type="text" name="branchManagerID" pattern="[0-9]+" placeholder="Branch Manager ID" value="<% out.println(request.getAttribute("branchManagerID")); %>"><br>
      <button type="submit" class="button">Add Branch</button><br>
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
<script src="/SerWise_war/GeneralManager/GeneralManagerHeader.js"></script>
</body>
</html>