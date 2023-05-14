package com.CS01.SerWise.Services.Appointments;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.CS01.SerWise.Controllers.appoinmentTable;

public class ResheduleAppointment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("uid")==null){
            resp.sendRedirect("../../Login/login.jsp");
            return;
        }
        HttpSession session1= req.getSession();
        int aId=(Integer)session1.getAttribute("Appointment_Id");
        String date=req.getParameter("Date");
        String time=req.getParameter("Time");



        try {
            ArrayList<String[]> results = null;
            try {
                results = appoinmentTable.select("Branch_Id","Appoinment_Id="+aId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            for (String[] i : results){
                Integer BId=Integer.parseInt(i[0]);
                if(CheckAppointment.checkAppointmentExists(BId,time,date)){
                    resp.sendRedirect("RegisteredClient/Appointments/SelectOngoingAppointment.jsp");
                }else {
                    appoinmentTable.update("Date='"+date+"' ,Time='"+time+"' ","Appoinment_Id="+aId);
                    resp.sendRedirect("RegisteredClient/Appointments/SelectOngoingAppointment.jsp");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
