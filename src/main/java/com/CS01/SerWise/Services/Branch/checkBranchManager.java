package com.CS01.SerWise.Services.Branch;

import com.CS01.SerWise.Controllers.branchManagerTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class checkBranchManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String branchId = req.getParameter("branchId");
            ArrayList<String[]> branchManagerResult = branchManagerTable.select("*","Branch_Id="+branchId);
            if(branchManagerResult.size() > 0){
                resp.getOutputStream().print("1111");
            } else {
                resp.getOutputStream().print("");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
