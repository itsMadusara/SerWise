package com.CS01.SerWise;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getServiceList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            String query = "select * from serwise.inventory_item";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/GeneralManager/Inventory/manageInventoryHome.jsp");
//            requestDispatcher.forward(req,resp);
            int noOfRows = 0;
            while (resultSet.next()){
                req.setAttribute("ItemID"+noOfRows,resultSet.getString("Inventory_Item_Id"));
                req.setAttribute("ItemName"+noOfRows,resultSet.getString("Name"));
                req.setAttribute("Measure"+noOfRows,resultSet.getString("Measurement"));
                req.setAttribute("Price"+noOfRows,resultSet.getString("Price"));
                noOfRows+=1;
            }
            req.setAttribute("noOfRows",noOfRows);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
