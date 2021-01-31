package com.arcan.controller;

import model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            products.add(
                    new Product(
                            i,
                            "Prod_" + i,
                            new Random().nextDouble() * 10
                    )
            );
        }
        log.info("GET: /products : {}", products);
        resp.getWriter().printf("Products: %s", products);
    }
}
