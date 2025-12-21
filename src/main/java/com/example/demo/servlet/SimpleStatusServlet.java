package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/status") // [cite: 327, 419]
public class SimpleStatusServlet extends HttpServlet { // [cite: 326, 418]
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_OK); // [cite: 328, 420]
        resp.getWriter().write("OK"); // [cite: 328, 420]
    }
}