package com.CS01.SerWise.Services;

import java.sql.SQLException;
import java.util.ArrayList;
import com.CS01.SerWise.Controllers.vehicleTable;

public class CheckVehicle {

    public static boolean checkVehicleExists(Integer RCI,String RN) throws SQLException, ClassNotFoundException {
        boolean vehicleExists = false;
        try {
            String where = "Registered_Client_Id="+RCI+" AND Reg_No='%s' ";
            where = String.format(where,RN);
            ArrayList<String[]> results = vehicleTable.select("*",where );
            for (String[] i : results) {
                vehicleExists = true;
                break;
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        return vehicleExists;
    };
}
