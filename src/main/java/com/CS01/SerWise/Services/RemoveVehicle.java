package com.CS01.SerWise.Services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.CS01.SerWise.Controllers.vehicleTable;

public class RemoveVehicle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("uid")==null){
            resp.sendRedirect("../../Login/login.jsp");
            return;
        }
        String vid = req.getParameter("Vehicle_Id");
        try {
            vehicleTable.delete(vid);
            resp.sendRedirect("RegisteredClient/Vehicles/selectVehicle.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
