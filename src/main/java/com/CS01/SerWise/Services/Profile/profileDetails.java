package com.CS01.SerWise.Services.Profile;

import com.CS01.SerWise.Controllers.employeeTable;
import com.CS01.SerWise.Controllers.registeredClientTable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class profileDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String afterWhere;

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Profile/profile.jsp");

        try {
            if (session.getAttribute("employeeId") == null){
                System.out.println(session.getAttribute("uid"));
                String clientId = session.getAttribute("uid").toString();
                afterWhere = "Registered_Client_Id=%s";
                afterWhere = String.format(afterWhere, clientId);
                System.out.println(clientId);

                ArrayList<String[]> result = registeredClientTable.select("First_Name,Last_Name,Contact,Address",afterWhere);

                String[] i = result.get(0);

                req.setAttribute("firstName",i[0]);
                req.setAttribute("lastName",i[1]);
                req.setAttribute("contact",i[2]);
                req.setAttribute("email",i[3]);
                requestDispatcher.forward(req,resp);

            } else {
                String employeeId = (String) session.getAttribute("employeeId");
                afterWhere = "Employee_Id=%s";
                afterWhere = String.format(afterWhere, employeeId);

                ArrayList<String[]> result = employeeTable.select("First_Name,Last_Name,Phone_Number,Email",afterWhere);
                String[] i = result.get(0);

                req.setAttribute("firstName",i[0]);
                req.setAttribute("lastName",i[1]);
                req.setAttribute("contact",i[2]);
                req.setAttribute("email",i[3]);
                requestDispatcher.forward(req,resp);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
