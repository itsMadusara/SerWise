package com.CS01.SerWise.Services.Inventory;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.CS01.SerWise.Controllers.inventoryItemBranchTable;

public class ServletAddNewBatch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        if (session.getAttribute("auth")==null){
            response.sendRedirect("../../Login/login.jsp");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        int iId=Integer.parseInt(session.getAttribute("iId").toString());
        int batchNo=Integer.parseInt(request.getParameter("batchNo").toString());
        int qt=Integer.parseInt(request.getParameter("quantity").toString());
        int hT=Integer.parseInt(request.getParameter("hT").toString());
        int branchId=Integer.parseInt(session.getAttribute("branchId").toString());

        try {
            inventoryItemBranchTable.insert("Inventory_Item_Id,Branch_Id,batchNo,quantity,handling_time"," '"+iId+"', '"+branchId+"', '"+batchNo+"', '"+qt+"', '"+hT+"' ");
            response.sendRedirect("../SerWise_war/StoreKeeper/Inventory/inventory.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        out.close();
    }
}
