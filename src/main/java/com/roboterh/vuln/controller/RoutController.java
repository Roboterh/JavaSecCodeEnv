package com.roboterh.vuln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RoutController {
    @GetMapping("/redirect")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rout = request.getParameter("rout");
        response.sendRedirect(rout);
    }
}
