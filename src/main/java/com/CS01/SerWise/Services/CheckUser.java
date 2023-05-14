package com.CS01.SerWise.Services;

import com.CS01.SerWise.Controllers.userTable;

import java.sql.SQLException;
import java.util.ArrayList;

public class CheckUser {

    public static boolean checkUserExists(String email) throws SQLException, ClassNotFoundException {
        boolean userExists = false;

        try {
            String where = "id='%s'";
            where = String.format(where,email);
            ArrayList<String[]> results1 = userTable.select("*",where);
            if (!results1.isEmpty()){
                userExists = true;
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        return userExists;
    };
}
