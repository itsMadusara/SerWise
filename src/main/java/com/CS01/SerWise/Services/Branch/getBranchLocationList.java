package com.CS01.SerWise.Services.Branch;

import com.CS01.SerWise.Controllers.branchTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class getBranchLocationList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<String []> results = branchTable.select("Branch_Id,Location");
            for (String[] i : results){
                resp.getOutputStream().print(i[0]);
                resp.getOutputStream().print("**");
                resp.getOutputStream().print(i[1]);
                resp.getOutputStream().print(",");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
