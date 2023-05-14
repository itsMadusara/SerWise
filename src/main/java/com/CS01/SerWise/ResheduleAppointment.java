package com.CS01.SerWise;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ResheduleAppointment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("uid")==null){
            resp.sendRedirect("../../Login/login.jsp");
            return;
        }
        HttpSession session1= req.getSession();
        int aId=(Integer)session1.getAttribute("Appointment_Id");
        String date=req.getParameter("Date");
        String time=req.getParameter("Time");

        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement ps= con.prepareStatement("update serwise.appoinment set Date=?,Time=? where Appoinment_Id=?");
            ps.setString(1,date);
            ps.setString(2,time);
            ps.setInt(3,aId);
            ps.execute();
            resp.sendRedirect("RegisteredClient/Appointments/SelectOngoingAppointment.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
