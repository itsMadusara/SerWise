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
            <span class="subtitle">Add Inventory Item</span>
        </div>
        <div class="two-content-div-form">
            <form method="post" action="/SerWise_war/addService">
                <input type="text" name="serviceName" pattern="[A-Za-z0-9' ']+" placeholder="Service Name" required><br>
                <input type="text" name="price" pattern="[0-9]+(.[0-9]{2})" placeholder="Service Price in Rs." required><br>
                <input type="text" name="timeSpend" pattern="[0-9]+" placeholder="Time Spend In Mins" required><br>

                <div id="branchDivPopup" class="change-password-popup">
                    <div class="change-password-popup-content">
                        <div id="branchDiv">
                            <input type="hidden" name="noOfBranches" id="noBranch" value="1">
                            <select id="branchid1" name="branchid1">

                            </select>
                        </div>
                        <button type="button" class="button" id="addBranch">Add Branch</button> &MediumSpace;
                        <button type="button" class="button" id="rmBranch">Remove Branch</button> &MediumSpace;
                        <button type="button" class="button" id="confirmBranches">Confirm</button>
                    </div>
                </div>

                <div id="itemDivPopup" class="change-password-popup">
                    <div class="change-password-popup-content">
                        <div id="itemDiv">
                            <input type="hidden" name="noOfItems" id="noItems" value="1">
                            <select id="itemid1" name="itemid1">

                            </select><br>
                            <input type="text" name="itemidQty1" pattern="[0-9]+" placeholder="Quantity" required><br>

                        </div>
                        <button type="button" class="button" id="addItem">Add Item</button> &MediumSpace;
                        <button type="button" class="button" id="rmItem">Remove Item</button> &MediumSpace;
                        <button type="button" class="button" id="confirmItems">Confirm</button>
                    </div>
                </div>

                <input type="submit" class="button" value="Add Item"> &MediumSpace;
                <button id="addBranchDivBtn" type="button" class="button">Add Branches</button> &MediumSpace;
                <button id="addItemDivBtn" type="button" class="button">Add Items</button>
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
<script src="/SerWise_war/GeneralManager/Services/Service.js"></script>
</body>
</html>