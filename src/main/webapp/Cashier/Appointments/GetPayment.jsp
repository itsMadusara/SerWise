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
            <span class="title">Services</span><br>
            <span class="subtitle">Get Payment</span>
        </div>
    </div>

    <div class="two-content-div glass">
        <div class="receipt-table">
            <table>
                <tr>
                    <th>Item</th>
                    <th>QTY</th>
                    <th>Batch</th>
                    <th>Price</th>
                </tr>
                <%
                    int noOfItems = (int) request.getAttribute("noOfItems");
                    int noOfService = (int) request.getAttribute("noOfService");
                    int total = 0;
                    for (int j = 0; j < noOfService; j++) {
                        out.println("<tr>");
                        out.println("<td>"+request.getAttribute("serviceName"+j)+"</td>");
                        out.println("<td> -- </td>");
                        out.println("<td> -- </td>");
                        out.println("<td class='price'>"+request.getAttribute("servicePrice"+j)+"</td>");
                        int tempServicePrice = Integer.parseInt(request.getAttribute("servicePrice"+j).toString());
                        total=total+tempServicePrice;
                        out.println("</tr>");
                    }

                    for (int j = 0; j < noOfItems; j++) {
                        out.println("<tr>");
                        out.println("<td>"+request.getAttribute("itemName"+j)+"</td>");
                        out.println("<td>"+request.getAttribute("itemQuantity"+j)+"</td>");
                        out.println("<td>"+request.getAttribute("itemBatch"+j)+"</td>");
                        out.println("<td class='price'>"+request.getAttribute("itemFullPrice"+j)+"</td>");
                        int tempItemPrice = Integer.parseInt(request.getAttribute("itemFullPrice"+j).toString());
                        total=total+tempItemPrice;
                        out.println("</tr>");
                    }
                %>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td id="total-amount" class="total"><%out.print(total);%></td>
                </tr>
            </table>
        </div>
        <div class="two-content-div-form">
            <form method="post" action="/SerWise_war/getInvoice?jobId=<%out.print(request.getAttribute("jobId"));%>">
                <span>Amount</span>
                <input id="total-box" type="text" name="total" placeholder="Amount" readonly><br>
                <span>Payment</span>
                <input id="paid-amount-box" type="text" name="paid" placeholder="Paid"><br>
                <span>Balance</span>
                <input id="balance-amount-box" type="text" name="balance" placeholder="Balance" readonly><br>
                <a href="/SerWise_war/getInvoice?jobId=<%out.print(request.getAttribute("jobId"));%>">
                    <button class="button">Get Bill</button><br>
                </a>
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
    <script src="/SerWise_war/Cashier/CashierHeader.js"></script>
    <script src="/SerWise_war/Cashier/Appointments/getPayment.js"></script>
</body>
</html>