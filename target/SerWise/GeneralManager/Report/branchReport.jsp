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
    <header class="navigation"></header>


    <div class="single-content-div title">
        <div>
            <span class="title">SerWise Branch - <%=request.getAttribute("branchId")%></span><br>
            <span class="subtitle"><%=request.getAttribute("month")%></span>
        </div>
    </div>

    <div class="report-table glass">
        <table>
            <tr>
                <td>
                    <span class="subtitle">Appointments Done</span><br>
                    <span class="title"><%=request.getAttribute("doneAppointments")%></span>
                </td>
                <td>
                    <span class="subtitle">Ongoing Appointments</span><br>
                    <span class="title"><%=request.getAttribute("ongoingAppointments")%></span>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="subtitle">Total Income</span><br>
                    <span class="title"><%=request.getAttribute("totalIncome")%></span>
                </td>
                <td>
                    
                </td>
            </tr>
        </table>
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