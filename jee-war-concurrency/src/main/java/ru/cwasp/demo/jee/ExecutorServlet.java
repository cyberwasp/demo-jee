package ru.cwasp.demo.jee;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@WebServlet("executor")
public class ExecutorServlet extends HttpServlet {

    @EJB
    private EjbDemo ejbDemo;

    @Resource(mappedName = "java:jboss/ee/concurrency/executor/default")
    private Executor executor;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        testFuture();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        testFuture();
    }

    private void testFuture() {
        CompletableFuture.runAsync(ejbDemo::test, executor);
    }
}
