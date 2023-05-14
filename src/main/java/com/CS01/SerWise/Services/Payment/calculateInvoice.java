package com.CS01.SerWise.Services.Payment;

import com.CS01.SerWise.Controllers.inventoryItemTable;
import com.CS01.SerWise.Controllers.jobInventoryItemTable;
import com.CS01.SerWise.Controllers.jobServiceTable;
import com.CS01.SerWise.Controllers.serviceTable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class calculateInvoice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobId = req.getParameter("jobId");
        String setWhere = "Job_ID=%s";
        setWhere = String.format(setWhere, jobId);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Cashier/Appointments/GetPayment.jsp");
        try {
            ArrayList<String[]> jobInventory = jobInventoryItemTable.select("*",setWhere);
            ArrayList<String[]> jobService = jobServiceTable.select("*",setWhere);
            int noOfService = 0;
            int noOfItems = 0;
            for(String[] i: jobService){
                ArrayList<String[]> tempService = serviceTable.select("*","Service_Id="+i[1]);
                req.setAttribute("serviceName"+noOfService,tempService.get(0)[1]);
                req.setAttribute("servicePrice"+noOfService,tempService.get(0)[2]);
                noOfService++;
            }
            for(String[] i: jobInventory){
                ArrayList<String[]> tempItem = inventoryItemTable.select("*","Inventory_Item_Id="+i[1]);
                req.setAttribute("itemName"+noOfItems,tempItem.get(0)[1]);
                int itemTotal = Integer.parseInt(tempItem.get(0)[3]) * Integer.parseInt(i[3]);
                req.setAttribute("itemFullPrice"+noOfItems,itemTotal);
                req.setAttribute("itemBatch"+noOfItems,i[2]);
                req.setAttribute("itemQuantity"+noOfItems,i[3]);
                noOfItems++;
            }
            req.setAttribute("noOfService",noOfService);
            req.setAttribute("noOfItems",noOfItems);
            req.setAttribute("jobId",jobId);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
