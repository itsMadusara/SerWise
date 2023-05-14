<%@ page import="java.util.ArrayList" %>
<%@ page import="com.CS01.SerWise.Controllers.inventoryItemBranchTable" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 12/13/2022
  Time: 5:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/content.css">
    <link rel="stylesheet" href="../../CSS/navigation.css">
    <link rel="stylesheet" href="../../CSS/footer.css">
    <link rel="stylesheet" href="../../CSS/backgrount.css">
    <title>Issue Items</title>
</head>
<body>
<%
    if (session.getAttribute("auth")==null){
        response.sendRedirect("../../Login/login.html");
    }
%>
<header class="navigation"></header>
<div class="two-content-div">
    <div class="two-content-div-form">
        <%
            int iId=Integer.parseInt(request.getParameter("Item_Id").toString());
            int batchNo=Integer.parseInt(request.getParameter("batchNo").toString());
            int branchId=Integer.parseInt(session.getAttribute("branchId").toString());
            try{
                ArrayList<String[]> results1 = inventoryItemBranchTable.select("Inventory_Item_Id,batchNo,quantity","Inventory_Item_Id='"+iId+"'AND Branch_Id='"+branchId+"'AND batchNo="+batchNo);
                for (String[] i : results1){
                    session.setAttribute("iId",i[0]);
        %>
        <form name="rform" action="../../ServletAddNewBatch" method="post">
            <label>Item No</label>
            <input type="number" name="iId" placeholder="<%=i[0]%>" disabled><br>
            <label>Enter Batch No</label>
            <input type="number" name="batchNo" placeholder="Please Enter" required><br>
            <label>Enter Quantity</label>
            <input type="number" name="quantity" placeholder="Please Enter" required><br>
            <label>Enter Handling Time</label>
            <input type="number" name="hT" placeholder="Please Enter" required><br>
            <input type="submit" value="Add New Batch" class="button">
        </form>
        <%
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        %>
    </div>
</div>


<footer class="footer">
    <div class="center"><img src="../../Assets/SerWise.png" class="logo"></div>
    <div class="center"><a href="#"> Contact Us </a> &nbsp|
        &nbsp<a href="#"> About Us </a> &nbsp|
        &nbsp <a href="#"> Legal Stuff </a></div>
    <div class="center">All Rights Recieved</div>
</footer>
<script src="/SerWise_war/StoreKeeper/StoreKeeperHeader.js"></script>
</body>
</html>
