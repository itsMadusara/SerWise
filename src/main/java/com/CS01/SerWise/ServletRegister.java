package com.CS01.SerWise;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;

public class ServletRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String fname=request.getParameter("Fname");
        String lname=request.getParameter("Lname");
        String id=request.getParameter("Email");
        String contact=request.getParameter("Contact");
        String password=request.getParameter("pswd");

        if(Objects.equals(fname, "") || Objects.equals(lname, "") || Objects.equals(id, "") || Objects.equals(contact, "") || Objects.equals(password, "")){
            response.sendRedirect("UnregisteredClient/Register/register.jsp?message=Please fill all required details!");
            return;
        }

        Connection con= null;

        try {
            if (id != null) {
                if (CheckUser.checkUserExists(id)) {
                    response.sendRedirect("UnregisteredClient/Register/register.jsp?message=User Already Exists!");
                    return;
                } else {
                    con = DatabaseConnection.initializeDatabase();

                    passwordHashGenerate generatedHash = passwordHash.generateHashedPassword(password);
                    String salt = Base64.getEncoder().encodeToString(generatedHash.salt);

                    PreparedStatement ps2=con.prepareStatement("insert into serwise.user(id,password,role,salt) values (?,?,?,?)");
                    PreparedStatement ps1=con.prepareStatement("insert into serwise.registered_client(First_Name,Last_Name,Contact,Address) values (?,?,?,?)");

                    ps1.setString(1,fname);
                    ps1.setString(2,lname);
                    ps1.setString(3,contact);
                    ps1.setString(4,id);

                    ps2.setString(1,id);
                    ps2.setString(2,generatedHash.hashedPassword);
                    ps2.setInt(3,1);
                    ps2.setString(4,salt);

                    int i=ps2.executeUpdate();
                    if(i>0){
                        int j=ps1.executeUpdate();
                        if (j>0){
                            response.sendRedirect("Login/login.html");
                        }
                    }else {
                        response.sendRedirect("UnregisteredClient/Register/register.jsp?message=An error occurred, Please try again!");
                        return;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
