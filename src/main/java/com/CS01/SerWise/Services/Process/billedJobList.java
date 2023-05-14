package com.CS01.SerWise.Services.Process;

import com.CS01.SerWise.Controllers.jobTable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class billedJobList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            String branchId = (String) session.getAttribute("branchId");
            ArrayList<String[]> results = jobTable.select("*","Status='Billed' AND Branch_Id="+branchId);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Cashier/BilledJobs/billedJobsHome.jsp");
            int noOfRows = 0;
            for(String[] i: results){
                req.setAttribute("Job_Id"+noOfRows,i[0]);
                req.setAttribute("Vehicle_Id"+noOfRows,i[7]);
                req.setAttribute("Date"+noOfRows,i[2]);
                req.setAttribute("Slot"+noOfRows,i[4]);
                noOfRows++;
            }
            req.setAttribute("noOfRows",noOfRows);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
