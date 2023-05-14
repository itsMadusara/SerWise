package com.CS01.SerWise.Services.Registration;

import com.CS01.SerWise.Controllers.employeeTable;
import com.CS01.SerWise.Controllers.userTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class deleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eid = req.getParameter("eid");
        try {
            ArrayList<String[]> empEmailResult = employeeTable.select("Email","Employee_Id="+eid);
            String empEmail = empEmailResult.get(0)[0];

            userTable.delete(empEmail);
            employeeTable.delete(eid);
            resp.sendRedirect("/SerWise_war/employeelist");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
