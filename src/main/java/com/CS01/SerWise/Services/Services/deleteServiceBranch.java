package com.CS01.SerWise.Services.Services;

import com.CS01.SerWise.Controllers.inventoryItemBranchTable;
import com.CS01.SerWise.Controllers.serviceBranchTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class deleteServiceBranch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String BranchId = req.getParameter("branchId");
        String serviceId = req.getParameter("serviceId");
        String where = "Service_Id=%s and Branch_Id=%s";
        where = String.format(where, serviceId, BranchId);
        try {
            serviceBranchTable.delete(where);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
