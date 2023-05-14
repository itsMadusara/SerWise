package com.CS01.SerWise.Services.Registration;

import com.CS01.SerWise.Controllers.*;
import com.CS01.SerWise.Hash;
import com.CS01.SerWise.passwordHash;
import com.CS01.SerWise.passwordHashGenerate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class addEmployee extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String contact = req.getParameter("contact");
        String address = req.getParameter("address");
        String BranchID = req.getParameter("BranchID");
        String date = req.getParameter("date");
        int role =Integer.parseInt(req.getParameter("role"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String employeeAttributes = "First_Name, Last_Name, Address, Joined_Date, Phone_Number, Branch_Id, Email";
        String employeeValues = "'%s','%s','%s','%s','%s',%s,'%s'";
        employeeValues = String.format(employeeValues, firstName, lastName, address, date, contact, BranchID, email);


        try {
            String hashedPassword = Hash.hashPassword(password);

            String userAttributes = "id,password,role";
            String userValues = "'%s','%s',%s";

            userValues = String.format(userValues, email, hashedPassword, role);

            employeeTable.insert(employeeAttributes,employeeValues);
            userTable.insert(userAttributes,userValues);

            ArrayList<String[]> newEmployeeIdResult = employeeTable.select("Employee_Id","Email='"+email+"'");
            String employeeId = newEmployeeIdResult.get(0)[0];
            switch (role) {
                case 2:
                    generalManagerTable.insert("Employee_Id",employeeId);
                    break;
                case 3:
                    serviceAdvisorTable.insert("Employee_Id",employeeId);
                    break;
                case 4:
                    //This is branch manager and added in branch
                    String branchManagerTableVals = "%s,%s";
                    branchManagerTableVals = String.format(branchManagerTableVals, BranchID, employeeId);
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
                default:
                    resp.sendRedirect("/SerWise_war/Error/error.jsp");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/SerWise_war/GeneralManager/Employee/EmployeeHome.jsp");

    }
}
