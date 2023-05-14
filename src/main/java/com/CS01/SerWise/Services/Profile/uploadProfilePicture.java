package com.CS01.SerWise.Services.Profile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

public class uploadProfilePicture extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part profilePic = req.getPart("profilePic");
        String fileName = profilePic.getSubmittedFileName();

        // Specify the directory where the file should be saved
        String saveDirectory = "D:\\SerWise\\src\\main\\webapp\\Profile\\ProfilePictures\\";
        ServletContext context = getServletContext();
        String contextPath = context.getRealPath("/");
        String filePath = contextPath + "/Profile/ProfilePictures/";

        HttpSession session = req.getSession();
        String employeeId = (String) session.getAttribute("employeeId");
        String imageSaveName = employeeId;
        if (employeeId.isEmpty()){
            String clientId = (String) session.getAttribute("uid");
            imageSaveName = clientId;
            if(clientId.isEmpty()){
                resp.sendRedirect("/SerWise_war/Login/login.html");
            }
        }


        // Create the directory if it doesn't exist
        File directory = new File(saveDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Save the file to the specified directory
        profilePic.write(saveDirectory+imageSaveName+".jpg");
        profilePic.write(filePath+imageSaveName+".jpg");

        System.out.println(fileName);
        System.out.println("Test");

        resp.sendRedirect("/SerWise_war/Profile");
    }
}
