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
            <span class="subtitle">Manage Branches</span>
        </div>
        <div class="colomn-content-div options">
            <div>
                <span class="title">Add Branch</span><br>
                <span>Update Branch details in your database from here to your database.
                    This will. This will update relevent branch details.
                </span><br>
                <a href="AddBranch.jsp"><button class="button">Click Here</button></a>
            </div>
            <div>
                <span class="title">Manage Branch</span><br>
                <span>Update Branch details in your database from here to your database.
                    This will. This will update relevent branch details.
                </span><br>
                <a href="/SerWise_war/branchlist"><button class="button">Click Here</button></a>
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