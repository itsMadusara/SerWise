package com.CS01.SerWise.Services.Inventory;

import com.CS01.SerWise.Controllers.branchTable;
import com.CS01.SerWise.Controllers.inventoryItemBranchTable;
import com.CS01.SerWise.Controllers.inventoryItemTable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class updateInventory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("itemId");
        String afterWhere = "Inventory_Item_Id='%s'";
        String afterWhereInventoryBranch = "inventory_item_Inventory_Item_Id='%s'";
        afterWhere = String.format(afterWhere, itemId);
        afterWhereInventoryBranch = String.format(afterWhereInventoryBranch, itemId);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/GeneralManager/Inventory/UpdateInventory.jsp");
        try {
            ArrayList<String[]> results = inventoryItemTable.select("*",afterWhere);
            ArrayList<String[]> results1 = inventoryItemBranchTable.select("branch_Branch_Id",afterWhereInventoryBranch);
            for(String[] i:results){
                req.setAttribute("ItemID",i[0]);
                req.setAttribute("ItemName",i[1]);
                req.setAttribute("Measure",i[2]);
                req.setAttribute("Price",i[3]);
            }
            int noOfBranchs = 0;
            for(String[] i : results1){
                ArrayList<String[]> temp = branchTable.select("Location","Branch_Id='"+i[0]+"'");
                req.setAttribute("BranchIdLocation"+noOfBranchs,temp.get(0)[0]);
                req.setAttribute("BranchId"+noOfBranchs,i[0]);
                noOfBranchs++;
            }
            req.setAttribute("noOfBranch",noOfBranchs);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
