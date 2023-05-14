package com.CS01.SerWise.Services.Services;

import com.CS01.SerWise.Controllers.serviceBranchTable;
import com.CS01.SerWise.Controllers.serviceInventoryTable;
import com.CS01.SerWise.Controllers.serviceTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class updateServiceDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String serviceID = req.getParameter("serviceID");
        String serviceName = req.getParameter("serviceName");
        String price = req.getParameter("price");
        String time = req.getParameter("timeSpend");
        int noOfBranch = Integer.parseInt(req.getParameter("noOfBranches"));
        int noOfItems = Integer.parseInt(req.getParameter("noOfItems"));

        String setService = "Name='%s',Price=%s,Time_Spent=%s";
        String whereService = "Service_Id=%s";
        setService = String.format(setService, serviceName, price, time);
        whereService = String.format(whereService, serviceID);

        try {
            serviceTable.update(setService,whereService);
            for (int k=1;k<=noOfBranch;k++) {
                String branchid = req.getParameter("branchid" + k);
                String branchServiceVals = "%s,%s";
                branchServiceVals = String.format(branchServiceVals, branchid, serviceID);
                String branchServiceAttribute = "Branch_Id,Service_Id";
                serviceBranchTable.insert(branchServiceAttribute,branchServiceVals);
            }

            for (int k=1;k<=noOfItems;k++) {
                String itemId = req.getParameter("itemid" + k);
                String itemQty = req.getParameter("itemidQty" + k);
                String serviceItemVals = "%s,%s,%s";
                serviceItemVals = String.format(serviceItemVals, serviceID, itemId, itemQty);
                String serviceItemAttributes = "Service_Id,Inventory_Item_Id,Quantity";
                serviceInventoryTable.insert(serviceItemAttributes,serviceItemVals);
            }

            resp.sendRedirect("/SerWise_war/serviceList");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
