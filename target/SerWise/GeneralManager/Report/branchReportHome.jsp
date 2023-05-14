<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
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
    <header class="navigation"></header>


    <div class="two-content-div glass">
        <div>
            <span class="title">SerWise</span><br>
            <span class="subtitle">Branch Report</span>
        </div>
        <div class="two-content-div-form">
            <form method="post" action="/SerWise_war/branchReport">
                <select id="branchId" name="branchId">

                </select>
                <%
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
                    LocalDateTime now = LocalDateTime.now();
                %>
                <input type="month" name="month" max="<%=dtf.format(now)%>" placeholder="Select Month"><br>
                <input type="submit" class="button" value="View Report">
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
    <script src="/SerWise_war/GeneralManager/Report/branchReportHome.js"></script>
</body>
</html>