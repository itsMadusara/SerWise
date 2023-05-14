package com.CS01.SerWise.Services.Inventory;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.CS01.SerWise.Controllers.inventoryItemBranchTable;

public class ServletIssueItems extends HttpServlet {
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
        int batchNo=Integer.parseInt(session.getAttribute("batchNo").toString());
        int qt=Integer.parseInt(request.getParameter("quantity").toString());
        int branchId=Integer.parseInt(session.getAttribute("branchId").toString());

        try {
            inventoryItemBranchTable.update("quantity=quantity-"+qt,"Inventory_Item_Id='"+iId+"'AND Branch_Id='"+branchId+"'AND batchNo="+batchNo);
            response.sendRedirect("../SerWise_war/StoreKeeper/Order/order.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        out.close();
    }
}
