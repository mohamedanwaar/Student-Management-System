package com.example.studentsystem;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.annotation.Resource;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
//    @Resource(name = "jdbc/web_student_tracker")
//    private DataSource dataSource;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plan");

//        // Hello
//        PrintWriter out = response.getWriter();
//        Connection myconn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            myconn= dataSource.getConnection();
//            stmt = myconn.createStatement();
//            String sql = "select * from student";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String email = rs.getString("first_name");
//                out.println(email);
//            }
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public void destroy() {
    }
}