package com.CS01.SerWise.Services.Profile;

import com.CS01.SerWise.Controllers.employeeTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class editProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String contact = req.getParameter("contact");
        String email = req.getParameter("email");

        String afterSet = "First_Name='%s',Last_Name='%s',Phone_Number='%s',Email='%s'";
        afterSet = String.format(afterSet, firstName,lastName,contact,email);

        HttpSession session = req.getSession();
        String employeeId = (String) session.getAttribute("employeeId");

        String afterWhere = "Employee_Id=%s";
        afterWhere = String.format(afterWhere, employeeId);

        try {
            employeeTable.update(afterSet,afterWhere);
            resp.sendRedirect("/SerWise_war/Profile");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
