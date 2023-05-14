package com.CS01.SerWise.Services.Registration;

import com.CS01.SerWise.Controllers.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getEmployeeList extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            Connection con = DatabaseConnection.initializeDatabase();
//            String query = "select * from serwise.employee";
//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<String[]> results = employeeTable.select();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/GeneralManager/Employee/ManageEmployeeHome.jsp");
//            requestDispatcher.forward(req,resp);
            int noOfRows = 0;
            for (String[] i:results){
                String employeeID = i[0];
                req.setAttribute("EmployeeID"+noOfRows,i[0]);
                req.setAttribute("FirstName"+noOfRows,i[1]);
                req.setAttribute("LastName"+noOfRows,i[2]);
                req.setAttribute("Address"+noOfRows,i[3]);
                req.setAttribute("JoinedDate"+noOfRows,i[4]);
                req.setAttribute("Contact"+noOfRows,i[5]);
                req.setAttribute("BranchID"+noOfRows,i[6]);

                ArrayList<String[]> BranchManagerResult = generalManagerTable.select("*","Employee_Id="+employeeID);
                if (BranchManagerResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"General Manager");
                }

                ArrayList<String[]> generalManagerResult = branchManagerTable.select("*","Employee_Id="+employeeID);
                if (generalManagerResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Branch Manager");
                }

                ArrayList<String[]> serviceAdvisorResult = serviceAdvisorTable.select("Employee_Id","Employee_Id="+employeeID);
                if (serviceAdvisorResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Service Advisor");
                }

                ArrayList<String[]> storeKeeperResult = storeKeeperTable.select("Employee_Id","Employee_Id="+employeeID);
                if (storeKeeperResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Store Keeper");
                }

                ArrayList<String[]> slotLeaderResult = slotLeaderTable.select("*","Employee_Id="+employeeID);
                if (slotLeaderResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Slot Leader");
                }

                ArrayList<String[]> securityResult = securityTable.select("*","Employee_Id="+employeeID);
                if (securityResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Security");
                }

                ArrayList<String[]> cashierResult = cashierTable.select("*","Employee_Id="+employeeID);
                if (cashierResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Cashier");
                }

                ArrayList<String[]> mechanicResult = mechanicTable.select("*","Employee_Id="+employeeID);
                if (mechanicResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Mechanic");
                }

                ArrayList<String[]> washerResult = washerTable.select("*","Employee_Id="+employeeID);
                if (washerResult.size() > 0){
                    req.setAttribute("Role"+noOfRows,"Washer");
                }


                noOfRows+=1;
            }
//            while (resultSet.next()){
//                req.setAttribute("EmployeeID"+noOfRows,resultSet.getString("Employee_Id"));
//                req.setAttribute("FirstName"+noOfRows,resultSet.getString("First_Name"));
//                req.setAttribute("LastName"+noOfRows,resultSet.getString("Last_Name"));
//                req.setAttribute("Address"+noOfRows,resultSet.getString("Address"));
//                req.setAttribute("JoinedDate"+noOfRows,resultSet.getString("Joined_Date"));
//                req.setAttribute("Contact"+noOfRows,resultSet.getString("Phone_Number"));
//                req.setAttribute("BranchID"+noOfRows,resultSet.getString("Branch_Id"));
//                noOfRows+=1;
//            }
            req.setAttribute("noOfRows",noOfRows);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
