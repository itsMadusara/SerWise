package com.CS01.SerWise.Services.Profile;

import com.CS01.SerWise.Services.Process.sendMessage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletGenerateOTPClient", value = "/ServletGenerateOTPClient")
public class ServletGenerateOTPClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int min = 1000;
        int max = 9999;
        int randomNum = (int) (Math.random()*(max-min-1)+min);
        HttpSession session = request.getSession();
        session.setAttribute("OTP",randomNum);

        String text = "OPT for the password change is "+randomNum;

        String contact=(String) session.getAttribute("Contact");
        contact = contact.substring(1);
        contact = "94"+contact;
        String optAPIreq = sendMessage.sendMessage(text,contact);
        response.sendRedirect(optAPIreq);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
