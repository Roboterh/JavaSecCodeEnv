package com.roboterh.vuln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;

@Controller
public class CommonsCollectionsVuln {
    @ResponseBody
    @RequestMapping("/unser")
    public void unserialize(HttpServletRequest request, HttpServletResponse response) throws Exception {
        java.io.InputStream inputStream =  request.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        objectInputStream.readObject();
        response.getWriter().println("successfully!!!");
    }

    @ResponseBody
    @RequestMapping("/demo")
    public void demo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.getWriter().println("This is a Demo!!!");
    }
}
