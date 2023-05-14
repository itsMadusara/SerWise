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
        <span class="subtitle">Update Employee</span>
    </div>
    <div class="two-content-div-form">
        <form method="post" action="/SerWise_war/updateEmployeeDetails">
            <input type="text" name="employeeID" placeholder="Employee ID" value="<%out.print(request.getAttribute("EmployeeID"));%>" readonly><br>
            <input type="text" name="firstName" placeholder="First Name" value="<%out.print(request.getAttribute("FirstName"));%>"><br>
            <input type="text" name="lastName" placeholder="Last Name" value="<%out.print(request.getAttribute("LastName"));%>"><br>
            <input type="text" name="contact" placeholder="Contact Number" value="<%out.print(request.getAttribute("Contact"));%>"><br>
            <input type="text" name="address" placeholder="Address (Home)" value="<%out.print(request.getAttribute("Address"));%>"><br>
            <input type="hidden" id="BranchIdNow" placeholder="Branch ID" value="<%out.print(request.getAttribute("BranchID"));%>">
            <select id="BranchId" name="BranchID">

            </select>
            <input type="date" name="date" value="<%out.print(request.getAttribute("JoinedDate"));%>"><br>
            <%String role = request.getAttribute("Role").toString();%>
            <select id="role" name="role" class="drop-down-list" required>
                <option value="2" <%if (role.equals("2")) {out.print("selected");}%>>General Manager</option>
                <option value="3" <%if (role.equals("3")) {out.print("selected");}%>>Serwise Advisor</option>
                <option value="4" id="branchManagerOption" <%if (role.equals("4")) {out.print("selected");}%>>Branch Manager</option>
                <option value="5" <%if (role.equals("5")) {out.print("selected");}%>>Store Keeper</option>
                <option value="6" <%if (role.equals("6")) {out.print("selected");}%>>Cashier</option>
                <option value="7" <%if (role.equals("7")) {out.print("selected");}%>>Security</option>
                <option value="8" <%if (role.equals("8")) {out.print("selected");}%>>Slot Leader</option>
                <option value="9" <%if (role.equals("9")) {out.print("selected");}%>>Washer</option>
                <option value="10" <%if (role.equals("10")) {out.print("selected");}%>>Mechanic</option>
            </select><br>
            <button type="submit" class="button">Update Employee</button><br>
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
<script src="/SerWise_war/GeneralManager/Employee/updateEmployee.js"></script>
</body>
</html>