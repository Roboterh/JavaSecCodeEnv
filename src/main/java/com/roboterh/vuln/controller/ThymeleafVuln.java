package com.roboterh.vuln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/SSTI")
public class ThymeleafVuln {

    @GetMapping("/Thymeleaf")
    public String index(Model model) {
        model.addAttribute("message", "world");
        return "en/test/hello";
    }
    @GetMapping("/Thymeleaf/cmd")
    public String cmd(@RequestParam String lang) {
        return lang;
    }
    @GetMapping("/Thymeleaf/admin")
    public String path(@RequestParam String lang) {
        return "en/test/" + lang;
    }
    @GetMapping("/Thymeleaf/home/{page}")
    public String getHome(@PathVariable String page) {
        return "home/" + page;
    }
    @GetMapping("/Thymeleaf/doc/{document}")
    public void getDocument(@PathVariable String document) {
//        log.info("Retrieving " + document);
    }
}
