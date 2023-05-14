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


<div class="two-content-div glass">
    <div>
        <span class="title">SerWise</span><br>
        <span class="subtitle">Update Inventory Item</span>
    </div>
    <div class="two-content-div-form">
        <form method="post" action="/SerWise_war/updateInventoryDetails">
            <input id="itemId" type="text" name="itemID" pattern="[0-9]+" placeholder="Item ID" value="<% out.println(request.getAttribute("ItemID")); %>" required readonly><br>
            <input type="text" name="itemName" pattern="[A-Za-z0-9' ']+" placeholder="Item Name" value="<% out.println(request.getAttribute("ItemName")); %>" required><br>
            <select name="measurement" placeholder="Measurement" required>
                <option value="Liters" <% if (request.getAttribute("Measure").toString().equals("Liters")){out.println("selected");}%>>Liters</option>
                <option value="Units" <% if (request.getAttribute("Measure").toString().equals("Units")){out.println("selected");}%>>No of Units</option>
                <option value="Kilograms" <% if (request.getAttribute("Measure").toString().equals("Kilograms")){out.println("selected");}%>>Kilograms</option>
            </select><br>
            <input type="text" name="price" pattern="[0-9]+" placeholder="Price Per Unit (Rs.)" value="<% out.println(request.getAttribute("Price")); %>" required><br>
            <div id="branchDiv">
                <input type="hidden" name="noOfBranches" id="noBranch" value="0">
                <input type="hidden" name="noOfBranchesNow" id="noBranchNow" value="<%out.println(request.getAttribute("noOfBranch"));%>">
                <%
                    for (int i = 0; i < (int) request.getAttribute("noOfBranch"); i++) {
                        out.println("<input class='input-with-button' type='text' id='branchidnow"+i+"' name='branchidnow"+i+"' placeholder='Available branch ID' value='"+request.getAttribute("BranchIdLocation"+i)+"' readonly>");
                        out.println("<button class='button-with-input' type='button' id='buttonbranchidnow"+i+"' value='"+request.getAttribute("BranchId"+i)+"'>X</button>");
                    }
                %>
<%--                <input type="text" id="branchid1" name="branchid1" placeholder="Available branch ID">--%>
            </div>
            <input type="submit" class="button" value="Add Item"> &MediumSpace;
            <button type="button" class="button" id="addBranch">Add Branch</button> &MediumSpace;
            <button type="button" class="button" id="rmBranch">Remove Branch</button> <br>
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
<script src="/SerWise_war/GeneralManager/Inventory/updateInventory.js"></script>

</body>
</html>