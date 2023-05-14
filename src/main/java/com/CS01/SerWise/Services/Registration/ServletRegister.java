package com.CS01.SerWise.Services.Registration;

import com.CS01.SerWise.CheckUser;
import com.CS01.SerWise.Controllers.registeredClientTable;
import com.CS01.SerWise.Controllers.userTable;
import com.CS01.SerWise.Hash;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class ServletRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String fname=request.getParameter("Fname");
        String lname=request.getParameter("Lname");
        String id=request.getParameter("Email");
        String contact=request.getParameter("Contact");
        String password=request.getParameter("pswd");
        String hp= Hash.hashPassword(password);

        try {
            if (id != null) {
                if (CheckUser.checkUserExists(id)) {
                    response.sendRedirect("UnregisteredClient/Register/register.jsp?message=User Already Exists!");
                    return;
                } else {
                    //HttpSession session= request.getSession();
                    //session.setAttribute("Fname",fname);
                    //session.setAttribute("Lname",lname);
                    //session.setAttribute("Email",id);
                    //session.setAttribute("Contact",contact);
                    //session.setAttribute("pswd",hp);
                    //response.sendRedirect("UnregisteredClient/Register/OTP.jsp");
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
