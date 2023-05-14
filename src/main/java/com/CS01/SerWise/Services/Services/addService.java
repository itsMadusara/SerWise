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
import java.util.ArrayList;

public class addService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String serviceName = req.getParameter("serviceName");
        String price = req.getParameter("price");
        String time = req.getParameter("timeSpend");
        int noOfBranch = Integer.parseInt(req.getParameter("noOfBranches"));
        int noOfItems = Integer.parseInt(req.getParameter("noOfItems"));

        String serviceAttribute = "Name,Price,Time_Spent";
        String serviceValues = "'%s',%s,%s";
        serviceValues = String.format(serviceValues, serviceName, price, time);

        try {
            serviceTable.insert(serviceAttribute,serviceValues);
            String nameOfService = "Name='%s'";
            nameOfService = String.format(nameOfService, serviceName);
            ArrayList<String[]> serviceIdResults = serviceTable.select("Service_Id",nameOfService);
            String serviceID = serviceIdResults.get(0)[0];
//            for(String[] i:serviceIdResults){
//                serviceID = i[0];
//            }
            for (int k=1;k<=noOfBranch;k++) {
                String branchid = req.getParameter("branchid" + k);
                String branchServiceVals = "%s,%s";
                branchServiceVals = String.format(branchServiceVals, branchid, serviceID);
                String branchServiceAttribute = "Branch_Id,Service_Id";
                serviceBranchTable.insert(branchServiceAttribute,branchServiceVals);
            }
            for (int i = 1; i <=noOfItems ; i++) {
                String itemId = req.getParameter("itemid" + i);
                String itemQty = req.getParameter("itemidQty" + i);
                String itemServiceVals = "%s,%s,%s";
                itemServiceVals = String.format(itemServiceVals, serviceID, itemId, itemQty);
                String itemServiceAttributes = "Service_Id,Inventory_Item_Id,Quantity";
                serviceInventoryTable.insert(itemServiceAttributes,itemServiceVals);
            }

            resp.sendRedirect("/SerWise_war/GeneralManager/Services/serviceHome.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
