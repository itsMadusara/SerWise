package com.CS01.SerWise.Services.Branch;

import com.CS01.SerWise.Controllers.branchTable;
import com.CS01.SerWise.Controllers.branchManagerTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class addBranch extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String location = req.getParameter("location");
        String address = req.getParameter("address");
        String noOfSlotes = req.getParameter("noOfSlots");

        try {
            String branchTableVals = "%s,'%s','%s'";
            branchTableVals = String.format(branchTableVals, noOfSlotes, location, address);
            branchTable.insert("Number_of_Slots, Location, Address",branchTableVals);

            resp.sendRedirect("/SerWise_war/GeneralManager/Branch/BranchHome.jsp");

        } catch (SQLException e) {
            resp.sendRedirect("/SerWise_war/Error/error.jsp");
//            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            resp.sendRedirect("/SerWise_war/Error/error.jsp");
//            throw new RuntimeException(e);
        }

    }
}
