package com.CS01.SerWise.Services;

import com.CS01.SerWise.Controllers.registeredClientTable;
import com.CS01.SerWise.Controllers.userTable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import com.CS01.SerWise.Controllers.employeeTable;


public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String password = request.getParameter("pswd");

        try {
            if (!(CheckUser.checkUserExists(id))) {
                response.sendRedirect("Login/login.jsp?message=User doesn't Exists!");
            }
            ArrayList<String[]> results1 = userTable.select("password,role","id='"+id+"'");
            for (String[] i1 : results1){
                if (Hash.checkPassword(password,i1[0])) {
                    int role=Integer.parseInt(i1[1]);
                    switch (role) {
                        case 1:
                            ArrayList<String[]> results2 = registeredClientTable.select("Registered_Client_Id","Address='"+id+"'");
                            for (String[] i2 : results2){
                                int val = Integer.parseInt(i2[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("uid", val);
                            }
                            response.sendRedirect("RegisteredClient/Home/home.jsp");
                            break;
                        case 2:
                            ArrayList<String[]> results3 = userTable.select("role","id='"+id+"'");
                            for (String[] i3 : results3){
                                int val = Integer.parseInt(i3[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("auth", val);
                                ArrayList<String[]> employeeId = employeeTable.select("Employee_Id,Branch_Id","Email='"+id+"'");
                                for(String[] i : employeeId){
                                    session.setAttribute("employeeId",i[0]);
                                    session.setAttribute("branchId",i[1]);
                                }
                            }
                            response.sendRedirect("GeneralManager/Home/home.jsp");
                            break;
                        case 3:
                            ArrayList<String[]> results4 = userTable.select("role","id='"+id+"'");
                            for (String[] i4 : results4){
                                int val = Integer.parseInt(i4[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("auth", val);
                                ArrayList<String[]> employeeId = employeeTable.select("Employee_Id,Branch_Id","Email='"+id+"'");
                                for(String[] i : employeeId){
                                    session.setAttribute("employeeId",i[0]);
                                    session.setAttribute("branchId",i[1]);
                                }
                            }
                            response.sendRedirect("ServiceAdvisor/Home.jsp");
                            break;
                        case 4:
                            ArrayList<String[]> results5 = userTable.select("role","id='"+id+"'");
                            for (String[] i5 : results5){
                                int val = Integer.parseInt(i5[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("auth", val);
                                ArrayList<String[]> employeeId = employeeTable.select("Employee_Id,Branch_Id","Email='"+id+"'");
                                for(String[] i : employeeId){
                                    session.setAttribute("employeeId",i[0]);
                                    session.setAttribute("branchId",i[1]);
                                }
                            }
                            response.sendRedirect("BranchManager/Home/home.jsp");
                            break;
                        case 5:
                            ArrayList<String[]> results6 = userTable.select("role","id='"+id+"'");
                            for (String[] i6 : results6){
                                int val = Integer.parseInt(i6[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("auth", val);
                                ArrayList<String[]> employeeId = employeeTable.select("Employee_Id,Branch_Id","Email='"+id+"'");
                                for(String[] i : employeeId){
                                    session.setAttribute("employeeId",i[0]);
                                    session.setAttribute("branchId",i[1]);
                                }
                            }
                            response.sendRedirect("StoreKeeper/Home/home.jsp");
                            break;
                        case 6:
                            ArrayList<String[]> results7 = userTable.select("role","id='"+id+"'");
                            for (String[] i7 : results7){
                                int val = Integer.parseInt(i7[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("auth", val);
                                ArrayList<String[]> employeeId = employeeTable.select("Employee_Id,Branch_Id","Email='"+id+"'");
                                for(String[] i : employeeId){
                                    session.setAttribute("employeeId",i[0]);
                                    session.setAttribute("branchId",i[1]);
                                }
                            }
                            response.sendRedirect("Cashier/Home/home.jsp");
                            break;
                        case 7:
                            ArrayList<String[]> results8 = userTable.select("role","id='"+id+"'");
                            for (String[] i8 : results8){
                                int val = Integer.parseInt(i8[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("auth", val);
                                ArrayList<String[]> employeeId = employeeTable.select("Employee_Id,Branch_Id","Email='"+id+"'");
                                for(String[] i : employeeId){
                                    session.setAttribute("employeeId",i[0]);
                                    session.setAttribute("branchId",i[1]);
                                }
                            }
                            response.sendRedirect("Security/Home.jsp");
                            break;
                        case 8:
                            ArrayList<String[]> results9 = userTable.select("role","id='"+id+"'");
                            for (String[] i9 : results9){
                                int val = Integer.parseInt(i9[0]);
                                HttpSession session = request.getSession();
                                session.setAttribute("auth", val);
                                ArrayList<String[]> employeeId = employeeTable.select("Employee_Id,Branch_Id","Email='"+id+"'");
                                for(String[] i : employeeId){
                                    session.setAttribute("employeeId",i[0]);
                                    session.setAttribute("branchId",i[1]);
                                }
                            }
                            response.sendRedirect("SlotLeader/Home/home.jsp");
                            break;
                    }
                    ;

                } else {
                    response.sendRedirect("Login/login.jsp?message=Password Invalid!");
                    return;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        out.close();
    }
    }
