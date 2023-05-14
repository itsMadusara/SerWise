package com.CS01.SerWise.Services.Process;

import com.CS01.SerWise.Controllers.registeredClientTable;
import com.CS01.SerWise.Controllers.userTable;
import com.CS01.SerWise.Services.CheckUser;
import com.CS01.SerWise.Services.Hash;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;

public class ServletOTP extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session= request.getSession();
        String fname= (String) session.getAttribute("Fname");
        String lname=(String) session.getAttribute("Lname");
        String id=(String) session.getAttribute("Email");
        String contact=(String) session.getAttribute("Contact");
        String hp=(String) session.getAttribute("pswd");
        Integer opt= (Integer) session.getAttribute("OTP");
        Integer optval= Integer.valueOf(request.getParameter("OTPval"));

        try {
            if (optval != opt) {
                if (CheckUser.checkUserExists(id)) {
                    response.sendRedirect("UnregisteredClient/Register/OTP.jsp?message=Invalid OTP!");
                    return;
                } else{
                    String values1 = "'%s','%s',%s";
                    values1 = String.format(values1,id,hp,1);
                    userTable.insert("id,password,role",values1);
                    String values2 = "'%s','%s','%s','%s'";
                    values2 = String.format(values2,fname,lname,contact,id);
                    registeredClientTable.insert("First_Name,Last_Name,Contact,Address",values2);
                    response.sendRedirect("Login/login.html");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
