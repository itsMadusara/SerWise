package com.CS01.SerWise.Services.Registration;

import com.CS01.SerWise.Controllers.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class updateEmployeeDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String contact = req.getParameter("contact");
        String address = req.getParameter("address");
        String BranchID = req.getParameter("BranchID");
        String date = req.getParameter("date");
        int newRole = Integer.parseInt(req.getParameter("role"));
        String employeeID = req.getParameter("employeeID");

        String afterSet = "First_Name='%s', Last_Name='%s', Address='%s', Joined_Date='%s', Phone_Number='%s', Branch_Id='%s'";
        String afterWhere = "Employee_Id='%s'";

        afterSet = String.format(afterSet, firstName, lastName, address, date, contact, BranchID);
        afterWhere = String.format(afterWhere, employeeID);

        try {
            ArrayList<String[]> emailResult = employeeTable.select("Email",afterWhere);
            ArrayList<String[]> oldRoleResult = userTable.select("role","id='"+emailResult.get(0)[0]+"'");
            int oldRole = Integer.parseInt(oldRoleResult.get(0)[0]);

            if (!(oldRole == newRole)){
                changeRole(BranchID,employeeID,oldRole,newRole);
            }

            employeeTable.update(afterSet,afterWhere);
            resp.sendRedirect("/SerWise_war/employeelist");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void changeRole(String branchId ,String employeeId ,int oldRole , int newRole) throws SQLException, ClassNotFoundException {
        switch (oldRole) {
            case 2:
                generalManagerTable.delete(employeeId);
                break;
            case 3:
                serviceAdvisorTable.delete(employeeId);
                break;
            case 4:
                //This is branch manager and added in branch
                branchManagerTable.delete("Employee_Id="+employeeId);
                break;
            case 5:
                storeKeeperTable.delete(employeeId);
                break;
            case 6:
                cashierTable.delete(employeeId);
                break;
            case 7:
                securityTable.delete(employeeId);
                break;
            case 8:
                slotLeaderTable.delete(employeeId);
                break;
            case 9:
                washerTable.delete(employeeId);
                break;
            case 10:
                mechanicTable.delete(employeeId);
                break;
        }

        switch (newRole) {
            case 2:
                generalManagerTable.insert("Employee_Id",employeeId);
                break;
            case 3:
                serviceAdvisorTable.insert("Employee_Id",employeeId);
                break;
            case 4:
                //This is branch manager and added in branch
                String branchManagerTableVals = "%s,%s";
                branchManagerTableVals = String.format(branchManagerTableVals, branchId, employeeId);
                branchManagerTable.insert("Branch_Id,Employee_Id",branchManagerTableVals);
                break;
            case 5:
                storeKeeperTable.insert("Employee_Id",employeeId);
                break;
            case 6:
                cashierTable.insert("Employee_Id",employeeId);
                break;
            case 7:
                securityTable.insert("Employee_Id",employeeId);
                break;
            case 8:
                slotLeaderTable.insert("Employee_Id",employeeId);
                break;
            case 9:
                washerTable.insert("Employee_Id",employeeId);
                break;
            case 10:
                mechanicTable.insert("Employee_Id",employeeId);
                break;
        }

        ArrayList<String[]> emailResult = employeeTable.select("Email","Employee_Id="+employeeId);
        String email = emailResult.get(0)[0];
        userTable.update("role="+newRole,"id='"+email+"'");
    }
}
