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
            <span class="subtitle">Manage Inventory Items</span>
        </div>
        <div class="colomn-content-div options">
            <div>
                <span class="title">Add Inventory Items</span><br>
                <span>Add new inventory item to your database through here.
                    This will add a new item to a relevent branch or branches.
                </span><br>
                <a href="addInventory.jsp"><button class="button">Add Item</button></a>
            </div>
            <div>
                <span class="title">Manage Inventory Item</span><br>
                <span>Update or change the Inventory Item details that is already exixting.
                    This will update the item details in your database.
                </span><br>
                <a href="/SerWise_war/inventorylist"><button class="button">Update Details</button></a>
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
<script src="/SerWise_war/GeneralManager/GeneralManagerHeader.js"></script>
</body>
</html>