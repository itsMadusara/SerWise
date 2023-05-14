package com.CS01.SerWise;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveAppointment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("uid")==null){
            resp.sendRedirect("../../Login/login.jsp");
            return;
        }
        String aid = req.getParameter("Appoinment_Id");
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            String query = "delete from serwise.appoinment where Appoinment_Id="+aid;
            Statement statement = con.createStatement();
            Integer result = statement.executeUpdate(query);
            resp.sendRedirect("RegisteredClient/Appointments/SelectOngoingAppointment.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
