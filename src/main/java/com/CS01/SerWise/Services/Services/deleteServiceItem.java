package com.CS01.SerWise.Services.Services;

import com.CS01.SerWise.Controllers.serviceBranchTable;
import com.CS01.SerWise.Controllers.serviceInventoryTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class deleteServiceItem extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("itemId");
        String serviceId = req.getParameter("serviceId");
        String where = "Service_Id=%s and Inventory_Item_Id=%s";
        where = String.format(where, serviceId, itemId);
        try {
            serviceInventoryTable.delete(where);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
