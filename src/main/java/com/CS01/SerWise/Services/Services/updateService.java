package com.CS01.SerWise.Services.Services;

import com.CS01.SerWise.Controllers.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class updateService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String serviceID = req.getParameter("ServiceId");
        String setWhere = "Service_Id='%s'";
        setWhere = String.format(setWhere, serviceID);

        try {
            ArrayList<String[]> results = serviceTable.select("*",setWhere);
            ArrayList<String[]> results1 = serviceBranchTable.select("Branch_Id",setWhere);
            ArrayList<String[]> results2 = serviceInventoryTable.select("Inventory_Item_Id,Quantity",setWhere);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/GeneralManager/Services/updateServices.jsp");

            for (String[] i:results){
                req.setAttribute("serviceID",i[0]);
                req.setAttribute("serviceName",i[1]);
                req.setAttribute("price",i[2]);
                req.setAttribute("time",i[3]);
            }

            int noOfBranch = 0;
            for (String[] i : results1){
                ArrayList<String[]> temp = branchTable.select("Location","Branch_Id='"+i[0]+"'");
                req.setAttribute("BranchIdLocation"+noOfBranch,temp.get(0)[0]);
                req.setAttribute("BranchId"+noOfBranch,i[0]);
                noOfBranch++;
            }
            req.setAttribute("noOfBranch",noOfBranch);

            int noOfItems = 0;
            for (String[] i : results2){
                ArrayList<String[]> temp = inventoryItemTable.select("Name","Inventory_Item_Id='"+i[0]+"'");
                req.setAttribute("itemName"+noOfItems,temp.get(0)[0]);
                req.setAttribute("itemId"+noOfItems,i[0]);
                req.setAttribute("itemQty"+noOfItems,i[1]);
                noOfItems++;
            }
            req.setAttribute("noOfItems",noOfItems);

            requestDispatcher.forward(req,resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
