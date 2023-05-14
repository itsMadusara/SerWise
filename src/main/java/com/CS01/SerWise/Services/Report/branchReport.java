package com.CS01.SerWise.Services.Report;

import com.CS01.SerWise.Controllers.jobTable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class branchReport extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String branchId = req.getParameter("branchId");
        String month = req.getParameter("month");
        req.setAttribute("month",month);
        req.setAttribute("branchId",branchId);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/GeneralManager/Report/branchReport.jsp");

        try {
            ArrayList<String[]> billedAppointments = jobTable.select("count(Job_ID)","Status='Billed' and Branch_Id='"+branchId+"' and Date like '"+month+"%'");
            for (String[] i: billedAppointments){
                req.setAttribute("doneAppointments",i[0]);
                System.out.println(i[0]);
            }

            ArrayList<String[]> ongoingAppointments = jobTable.select("count(Job_ID)","Status in ('Done','Ongoing') and Branch_Id='"+branchId+"' and Date like '"+month+"%'");
            for (String[] i : ongoingAppointments){
                req.setAttribute("ongoingAppointments",i[0]);
                System.out.println(i[0]);
            }

            ArrayList<String[]> totalIncome = jobTable.select("sum(Total)","Status in ('Done','Ongoing') and Branch_Id='"+branchId+"' and Date like '"+month+"%'");
            for (String[] i : totalIncome){
                if(i[0] == null){
                    i[0] = "0";
                }
                req.setAttribute("totalIncome",i[0]);
                System.out.println(i[0]);
            }

//            ArrayList<String[]> rankOfBranch = jobTable.select();

            requestDispatcher.forward(req,resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
