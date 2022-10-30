package com.roboterh.vuln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

@Controller
@RequestMapping("/deserializer")
public class DeserializationVuln {
    @GetMapping("/demo")
    @ResponseBody
    public String DemoGet() {
        return "POST传入序列化数据(data传参)";
    }

    @PostMapping("/demo")
    @ResponseBody
    public void DemoPost(@RequestParam String data) {
        try {
            byte[] serializer = Base64.getDecoder().decode(data);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializer);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
