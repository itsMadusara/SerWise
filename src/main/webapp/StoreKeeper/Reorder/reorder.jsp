<%--
  Created by IntelliJ IDEA.
  User: Thamira Weerakoon
  Date: 2/5/2023
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.CS01.SerWise.Controllers.inventoryItemBranchTable" %>
<%@ page import="java.sql.SQLException" %>
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
    <link rel="stylesheet" href="../CSS/table.css">
    <link rel="stylesheet" href="../CSS/popup.css">
    <link rel="stylesheet" href="../CSS/content.css">
    <title>Document</title>
</head>
<body>
<%
    if (session.getAttribute("auth")==null){
        response.sendRedirect("/SerWise_war/Login/login.html");
    }
%>

<div id="blur" class="back_g">
    <header class="navigation"></header>

    <div>
        <div class="single-content-div center title">
            <span class="title">SerWice</span><span class="subtitle">-&MediumSpace;Branch Inventory:Reorder Items</span>
        </div>

        <div class="form-display-table glass">
            <table>
                <tr>
                    <th>Item No</th>
                    <th>Batch No</th>
                    <th>Quantity</th>
                    <th>Handling Time</th>
                </tr>

                <%
                    int branchId=Integer.parseInt(session.getAttribute("branchId").toString());
                    try{
                        ArrayList<String[]> results1 = inventoryItemBranchTable.select("Inventory_Item_Id,batchNo,quantity,handling_time","Branch_Id="+branchId);
                        for (String[] i : results1){
                            if (Integer.parseInt(i[2])<=Integer.parseInt(i[3])){
                %>
                <tr>
                    <td><%=i[0]%></td>
                    <td><%=i[1]%></td>
                    <td><%=i[2]%></td>
                    <td><%=i[3]%></td>
                </tr>
                <%
                            }
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                %>
            </table>
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
<script src="/SerWise_war/StoreKeeper/StoreKeeperHeader.js"></script>
</body>
</html>
