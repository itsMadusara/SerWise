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


    <div class="single-content-div center title">
        <span class="title">SerWice &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; Manage Branch</span>
    </div>
    <div class="single-content-div center title">
        Search By Branch ID : &MediumSpace; 
        <form>
            <input id="idInput" type="text" placeholder="Branch ID" name="branchID">
            &MediumSpace;
            <input type="submit" value="Search" class="button">
        </form>
    </div>

    <div class="form-display-table glass">
        <table>
            <tr>
                <th>Branch ID</th>
                <th>Location</th>
                <th>No of Slots</th>
                <th>Address</th>
                <th>Branch Manager</th>
                <th colspan="2">Manage Options</th>
            </tr>
            <%
                int noOfRows = (int) request.getAttribute("noOfRows");
                int i = 0;
                while (i < noOfRows){
                    out.println("<tr>");
                    out.println("<td>");
                    String bid = request.getAttribute("branchID"+i).toString();
                    out.println(bid);
                    out.println("</td>");
                    out.println("<td>");
                    out.println(request.getAttribute("location"+i));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(request.getAttribute("noOfSlots"+i));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(request.getAttribute("address"+i));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(request.getAttribute("managerID"+i));
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='/SerWise_war/updateBranch?bid="+bid+"'><button class='button'>Update</button></a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='/SerWise_war/deleteBranch?bid="+bid+"'><button class='button'>Remove</button></a>");
                    out.println("</td>");
                    out.println("</tr>");
                    i=i+1;
                }
            %>
        </table>
    </div>


    <footer class="footer">
        <div class="center"><img src="/SerWise_war/Assets/SerWise.png" class="logo"></div>
        <div class="center"><a href="#"> Contact Us </a> &nbsp| 
            &nbsp<a href="#"> About Us </a> &nbsp|
            &nbsp <a href="#"> Legal Stuff </a></div>
        <div class="center">All Rights Recieved</div>
    </footer>
    <script src="/SerWise_war/GeneralManager/GeneralManagerHeader.js"></script>
    <script src="/SerWise_war/GeneralManager/Branch/branchList.js"></script>
</body>
</html>