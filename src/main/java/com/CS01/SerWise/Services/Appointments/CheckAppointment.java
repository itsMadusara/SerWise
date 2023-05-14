package com.CS01.SerWise.Services.Appointments;

import com.CS01.SerWise.Controllers.appoinmentTable;
import com.CS01.SerWise.Controllers.branchTable;

import java.sql.SQLException;
import java.util.ArrayList;

public class CheckAppointment {
    public static boolean checkAppointmentExists(Integer BID,String Time,String Date) throws SQLException, ClassNotFoundException {
        boolean appointmentExists = false;
        try {
            String where = "Branch_Id="+BID+" AND Time='%s' AND Date='%s'";
            where = String.format(where,Time,Date);
            ArrayList<String[]> results1 = appoinmentTable.select("*",where );
            ArrayList<String[]> results2 = branchTable.select("Number_of_Slots","Branch_Id="+BID);
            for (String[] i : results2){
                int ns=Integer.parseInt(i[0]);
                int cs=results1.size();
                if(cs>=ns){
                    appointmentExists=true;
                    break;
                }
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        return appointmentExists;
    };
}
