package com.roboterh.vuln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Controller
@RequestMapping("/PostgreSQL")
public class PostgresqlJDBCSQLInjection {

    @GetMapping("/JDBC")
    public String index() {
        return "访问/PostgreSQL/exp路由，传入参数url为JDBC连接串, 参数dbname为创建的表名";
    }

    @RequestMapping("/exp")
    public void exp(@RequestParam String url, @RequestParam String dbname) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url);
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("open database successfully");
        ResultSet rs = st.executeQuery("select * from " + dbname);
        rs.next();
        rs.refreshRow();
        st.close();
        connection.close();
    }
}
