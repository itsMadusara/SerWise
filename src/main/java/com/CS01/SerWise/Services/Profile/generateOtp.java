package com.CS01.SerWise.Services.Profile;

import com.CS01.SerWise.Controllers.employeeTable;
import com.CS01.SerWise.Controllers.registeredClientTable;
import com.CS01.SerWise.Services.Process.sendMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class generateOtp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int min = 1000;
        int max = 9999;
        int randomNum = (int) (Math.random()*(max-min-1)+min);
        HttpSession session = req.getSession();
        session.setAttribute("OTP",randomNum);

        String text = "OPT for the password change is "+randomNum;

        String employeeId = null;
        String clientID = null;
        String contactNum = null;
        if (session.getAttribute("employeeId")==null && session.getAttribute("uid")==null){
            resp.sendRedirect("/SerWise_war/Login/login.html");
        }else {
            employeeId = session.getAttribute("employeeId").toString();
            if(employeeId==null){
                clientID = session.getAttribute("uid").toString();
            }
        }


        try {
            if(clientID==null) {
                ArrayList<String[]> contact = employeeTable.select("Phone_Number", "Employee_Id=" + employeeId);
                contactNum = contact.get(0)[0];
            } else {
                ArrayList<String[]> contact = registeredClientTable.select("Contact","Registered_Client_Id="+clientID);
                contactNum = contact.get(0)[0];
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        contactNum = contactNum.substring(1);
        contactNum = "94"+contactNum;

        String optAPIreq = sendMessage.sendMessage(text,contactNum);
        resp.sendRedirect(optAPIreq);
    }
}
