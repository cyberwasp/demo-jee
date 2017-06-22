package ru.cwasp.demo.jee;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("ejb_call")
public class EjbCallServlet extends HttpServlet {

    @EJB
    private EjbDemo ejbDemo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ejbDemo.test();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ejbDemo.test();
    }
}
