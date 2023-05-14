package com.CS01.SerWise.Services.Registration;

import com.CS01.SerWise.Controllers.employeeTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class checkEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeID = req.getParameter("empId");
        String afterWhere = "Employee_Id='%s'";
        afterWhere = String.format(afterWhere, employeeID);
        try {
            ArrayList<String[]> employeeResult = employeeTable.select("Employee_Id",afterWhere);
            for(String[] i : employeeResult){
                resp.getOutputStream().print(i[0]);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
