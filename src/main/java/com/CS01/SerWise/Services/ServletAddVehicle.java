package com.CS01.SerWise.Services;

import com.CS01.SerWise.Controllers.vehicleTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class ServletAddVehicle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        if (session1.getAttribute("uid") == null) {
            response.sendRedirect("../../Login/login.jsp");
            return;
        }
        String type = request.getParameter("Type");
        String reg = request.getParameter("Reg");
        String brand = request.getParameter("Brand");
        String fuel = request.getParameter("FuelType");
        String model = request.getParameter("Model");
        String ec = request.getParameter("EC");

        HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("uid");

        try {
            if (CheckVehicle.checkVehicleExists(userid, reg)) {
                response.sendRedirect("RegisteredClient/Vehicles/addVehicle.jsp?message=Vehicle Already Exists!");
            } else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                try {
                    String values = "'%s','%s',%s,'%s','%s','%s','%s'";
                    values = String.format(values,model,type,userid,reg,brand,fuel,ec);
                    vehicleTable.insert("Model,Type,Registered_Client_Id,Reg_No,Brand,Fuel,EC",values);
                    response.sendRedirect("RegisteredClient/Vehicles/vehicles.jsp");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                out.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
