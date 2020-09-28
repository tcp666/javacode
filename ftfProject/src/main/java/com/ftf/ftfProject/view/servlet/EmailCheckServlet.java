package com.ftf.ftfProject.view.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/emailCheckServlet")
public class EmailCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hhgslkjghfkgljhalkhdfglkjhaldfg");
        resp.getWriter().write("1024");
        System.out.println("helloikjkhkhhj");
    }
}
