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
    Object profilePicNameObj = null;
    if (session.getAttribute("employeeId")==null && session.getAttribute("uid")==null){
        response.sendRedirect("/SerWise_war/Login/login.html");
    }else {
        profilePicNameObj = session.getAttribute("employeeId");
        if(profilePicNameObj==null){
            profilePicNameObj = session.getAttribute("uid").toString();
        }
    }

    String profilePicName = profilePicNameObj.toString();

%>

    <header class="navigation"></header>

    <div class="single-content-div title center">
        <span class="title">Profile </span>
        <span class="subtitle">&nbsp; - User Information</span>
    </div>

    <div class="two-content-div glass">
        <div class="colomn-content-div center">
            <div>
                <img src="/SerWise_war/Profile/ProfilePictures/<%out.print(profilePicName);%>.jpg" class="profile-pic" alt="Profile Picture" width="200px" height="200px" onerror="this.onerror=null;this.src='/SerWise_war/Assets/ProfilePic.jpg';">
            </div>
            <form method="post" id="imageForm" enctype="multipart/form-data">
                <button class="button upload-button" type="submit">
                    <p class="button-content">Upload Image</p>
                    <input id="upoadedImage" name="profilePic" class="input-image" type="file" accept=".jpg">
                </button>
            </form>
        </div>

        <div class="two-content-div-form">
            <form method="post" action="/SerWise_war/editProfile">
                <input type="text" name="fname" placeholder="First Name" value="<%=request.getAttribute("firstName")%>" required> <br>
                <input type="text" name="lname" placeholder="Last Name" value="<%=request.getAttribute("lastName")%>" required><br>
                <input type="tel" name="contact" pattern="[0-9]{10}" placeholder="Contact" value="<%=request.getAttribute("contact")%>" required><br>
                <input type="email" name="email" placeholder="Email" value="<%=request.getAttribute("email")%>" required><br>
<%--                <input type="password" name="pswd" pattern="{8,}" id="password" placeholder="Password" required><br>--%>
                <input type="submit" value="Edit Details" class="button"> &MediumSpace;
                <button type="button" class="button" id="passwordChange">Change Password</button>
            </form>
        </div>
    </div>

    <div class="change-password-popup" id="passwordDiv">
        <div class="change-password-popup-content">
            <span class="popup-close" id="closebtn">&times;</span><br>
            <form method="post" action="/SerWise_war/changePassword">
                <input type="password" name="currPassword" pattern="{8,}" id="currentPassword" placeholder="Current Password" autocomplete="off" required> <br>
                <input type="password" name="newPassword" pattern="{8,}" id="newPassword" placeholder="New Password" required><br>
                <input type="text" name="currPassword" pattern="[0,9]+" id="opt" placeholder="OTP" autocomplete="off" required><br>
                <button type="button" class="button" id="OPTDivbtn">Get OTP</button> &MediumSpace;
                <input type="submit" class="button" value="Change Password">
            </form>
        </div>
    </div>

<%--    <div class="change-password-popup" id="otpDiv">--%>
<%--        <div class="change-password-popup-content">--%>
<%--            <span class="popup-close" id="otpCloseBtn">&times;</span><br>--%>
<%--            <form action="/SerWise_war/changePassword">--%>
<%--                <input type="text" name="currPassword" pattern="[0,9]+" id="opt" placeholder="OTP" autocomplete="off" required> <br>--%>
<%--                <button type="button" class="button" id="OPTSubmitbtn">Get OTP</button> &MediumSpace;--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>


    <footer class="footer">
        <div class="center"><img src="../../Assets/SerWise.png" class="logo"></div>
        <div class="center"><a href="#"> Contact Us </a> &nbsp|
            &nbsp<a href="#"> About Us </a> &nbsp|
            &nbsp <a href="#"> Legal Stuff </a></div>
        <div class="center">All Rights Recieved</div>
    </footer>

<script src="/SerWise_war/Profile/profile.js"></script>
<%
    if(session.getAttribute("employeeId")==null){
        out.print("<script src=\"/SerWise_war/RegisteredClient/RegisteredClientHeader.js\"></script>");
    } else {
        int auth = (int) session.getAttribute("auth");
        switch (auth){
            case 2:
                out.print("<script src=\"/SerWise_war/GeneralManager/GeneralManagerHeader.js\"></script>");
                break;
            case 3:
                out.print("<script src=\"/SerWise_war/ServiceAdvisor/ServiceAdvisorHeader.js\"></script>");
                break;
            case 4:
                out.print("<script src=\"/SerWise_war/BranchManager/BranchManagerHeader.js\"></script>");
                break;
            case 6:
                out.print("<script src=\"/SerWise_war/Cashier/CashierHeader.js\"></script>");
                break;
        }
    }
%>
</body>
</html>
