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
  <link rel="stylesheet" href="/SerWise_war/CSS/profile.css">
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


<div class="two-content-div glass">
  <div>
    <span class="title">SerWise</span><br>
    <span class="subtitle">Update Services</span>
  </div>
  <div class="two-content-div-form">
    <form method="post" action="/SerWise_war/updateServiceDetails">
      <input type="text" name="serviceName" pattern="[A-Za-z0-9' ']+" placeholder="Service Name" value="<% out.println(request.getAttribute("serviceName")); %>"><br>
      <input type="hidden" id="serviceId" name="serviceID" placeholder="Service ID" value="<% out.println(request.getAttribute("serviceID")); %>">
      <input type="text" name="price" pattern="[0-9]+(.[0-9]{2})" placeholder="Service Price in Rs." value="<% out.println(request.getAttribute("price")); %>"><br>
      <input type="text" name="timeSpend" pattern="[0-9]+" placeholder="Time Spend In Mins" value="<% out.println(request.getAttribute("time")); %>"><br>

      <div id="branchDivPopup" class="change-password-popup">
        <div class="change-password-popup-content">
          <div id="branchDiv">
            <input type="hidden" name="noOfBranches" id="noBranch" value="0">
            <input type="hidden" name="noOfBranchNow" id="noBranchNow" value="<%out.print(request.getAttribute("noOfBranch"));%>">
            <%
              for (int i = 0; i < (int) request.getAttribute("noOfBranch"); i++) {
                out.println("<input class='input-with-button' type='text' id='branchidnow"+i+"' name='branchidnow"+i+"' placeholder='Available branch ID' value='"+request.getAttribute("BranchIdLocation"+i)+"' readonly>");
                out.println("<button class='button-with-input' type='button' id='buttonbranchidnow"+i+"' value='"+request.getAttribute("BranchId"+i)+"'>X</button>");
              }
            %>
          </div>
          <button type="button" class="button" id="addBranch">Add Branch</button> &MediumSpace;
          <button type="button" class="button" id="rmBranch">Remove Branch</button> &MediumSpace;
          <button type="button" class="button" id="confirmBranches">Confirm</button>
        </div>
      </div>

      <div id="itemDivPopup" class="change-password-popup">
        <div class="change-password-popup-content">
          <div id="itemDiv">
            <input type="hidden" name="noOfItems" id="noItems" value="0">
            <input type="hidden" name="noOfItemsNow" id="noItemsNow" value="<%out.print(request.getAttribute("noOfItems"));%>">
            <%
              for (int i = 0; i < (int) request.getAttribute("noOfItems"); i++) {
                out.println("<div id='itemIdDiv"+i+"'>");
                out.println("<input class='input-with-button' type='text' id='itemidnow"+i+"' name='itemidnow"+i+"' placeholder='Available branch ID' value='"+request.getAttribute("itemName"+i)+"' readonly> <br>");
                out.println("<input class='input-with-button' type='text' id='itemQtynow"+i+"' name='itemQtynow"+i+"' placeholder='Item Quantity' value='"+request.getAttribute("itemQty"+i)+"' readonly> <br>");
                out.println("<button class='button' type='button' id='buttonitemidnow"+i+"' value='"+request.getAttribute("itemId"+i)+"'>Remove "+request.getAttribute("itemName"+i)+"</button> <br>");
                out.println("</div>");
              }
            %>
          </div>
          <button type="button" class="button" id="addItem">Add Item</button> &MediumSpace;
          <button type="button" class="button" id="rmItem">Remove Item</button> &MediumSpace;
          <button type="button" class="button" id="confirmItems">Confirm</button>
        </div>
      </div>

      <input type="submit" class="button" value="Add Item"> &MediumSpace;
      <button id="addBranchDivBtn" type="button" class="button">Manage Branches</button> &MediumSpace;
      <button id="addItemDivBtn" type="button" class="button">Manage Items</button>

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
<script src="/SerWise_war/GeneralManager/Services/updateServices.js"></script>

</body>
</html>