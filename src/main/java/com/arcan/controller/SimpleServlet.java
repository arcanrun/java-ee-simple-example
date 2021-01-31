package com.arcan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "SimpleServlet", urlPatterns = "/simple-servlet")
public class SimpleServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(SimpleServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("GET: /simple-servlet");
        resp
                .getWriter()
                .printf(
                        "<h1>This is simple GET servlet request: " +
                                "</br> - path: %s " +
                                "</br> - param: %s</h1>",
                        req.getPathInfo(),
                        req.getQueryString()
                );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("POST: /simple-servlet");
        resp
                .getWriter()
                .printf(
                        "<h1>This is simple POST servlet request: " +
                                "</br> - path: %s " +
                                "</br> - param: %s " +
                                "</br> - body: %s" +
                                "</h1>",
                        req.getPathInfo(),
                        req.getQueryString(),
                        readAllLines(req.getReader())
                );
    }

    private String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }
}
