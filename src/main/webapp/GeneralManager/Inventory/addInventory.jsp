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
            <span class="subtitle">Add Inventory Item</span>
        </div>
        <div class="two-content-div-form">
            <form method="post" action="/SerWise_war/addinventory">
<%--                <input type="text" name="itemID" pattern="[0-9]+" placeholder="Item ID" required><br>--%>
                <input type="text" name="itemName" pattern="[A-Za-z0-9' ']+" placeholder="Item Name" required><br>
                <select name="measurement" placeholder="Measurement" required>
                    <option value="Liters">Liters</option>
                    <option value="Units">No of Units</option>
                    <option value="Kilograms">Kilograms</option>
                </select><br>
                <input type="text" name="price" pattern="[0-9]+" placeholder="Price Per Unit (Rs.)" required><br>
                <div id="branchDiv">
                    <input type="hidden" name="noOfBranches" id="noBranch" value="1">
<%--                    <input type="text" id="branchid1" name="branchid1" placeholder="Available branch ID">--%>
                    <select id="branchid1" name="branchid1" placeholder="Available Branch ID" required>

                    </select><br>
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
<script src="/SerWise_war/GeneralManager/Inventory/inventory.js"></script>

</body>
</html>