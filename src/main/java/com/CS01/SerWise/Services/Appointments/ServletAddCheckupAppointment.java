package com.CS01.SerWise.Services.Appointments;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.CS01.SerWise.Controllers.appoinmentTable;

public class ServletAddCheckupAppointment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1= request.getSession();
        if (session1.getAttribute("uid")==null){
            response.sendRedirect("../../Login/login.jsp");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String date=request.getParameter("Date");
        String time=request.getParameter("Time");
        int vId=Integer.parseInt(request.getParameter("Vehicle_Id"));
        int BId=Integer.parseInt(request.getParameter("Branch_Id"));
        String dr="Checkup";

        HttpSession session=request.getSession();
        int userid=(Integer)session.getAttribute("uid");

        try {
            if(CheckAppointment.checkAppointmentExists(BId,time,date)){
                response.sendRedirect("RegisteredClient/Appointments/makeCheckupAppointment.jsp?message=Sorry! Please select another Time.");
            }else {
                String values = "'%s','%s','%s',%s,%s,%s";
                values = String.format(values,date,time,dr,userid,BId,vId);
                appoinmentTable.insert("Date,Time,Description,Registered_Client_Id,Branch_Id,Vehicle_Id",values);
                response.sendRedirect("RegisteredClient/Appointments/appointments.jsp");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        out.close();
    }
}
