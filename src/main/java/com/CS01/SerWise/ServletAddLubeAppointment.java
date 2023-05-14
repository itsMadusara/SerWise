package com.CS01.SerWise;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServletAddLubeAppointment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1= request.getSession();
        if (session1.getAttribute("uid")==null){
            response.sendRedirect("../../Login/login.jsp");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String date=request.getParameter("Date");
        String time=request.getParameter("Time");
        int vId=Integer.parseInt(request.getParameter("Vehicle_Id"));
        int BId=Integer.parseInt(request.getParameter("Branch_Id"));
        //int SId=Integer.parseInt(request.getParameter("Service_Id"));
        String dr="Lube";

        HttpSession session=request.getSession();
        int userid=(Integer)session.getAttribute("uid");

        Connection con= null;

        try {
            con = DatabaseConnection.initializeDatabase();
            PreparedStatement ps1=con.prepareStatement("insert into serwise.appoinment(Date,Time,Registered_Client_Id,Branch_Id,Vehicle_Id,Description) values(?,?,?,?,?,?)");

            ps1.setString(1,date);
            ps1.setString(2,time);
            ps1.setInt(3,userid);
            ps1.setInt(4,BId);
            ps1.setInt(5,vId);
            ps1.setString(6,dr);

            int i=ps1.executeUpdate();
            if(i>0){
                response.sendRedirect("RegisteredClient/Appointments/appointments.jsp");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        out.close();
    }
}
