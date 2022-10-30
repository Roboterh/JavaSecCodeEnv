package com.roboterh.vuln.controller;

import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.io.Hessian2Input;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/deserializer/Hessian")
public class HessianVuln {
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "POST访问/Hessian/exp, 传入参数data为base64后的序列化数据";
    }

    @PostMapping("/exp")
    public void exp(@RequestParam String data) throws IOException {
        HessianProxyFactory factory = new HessianProxyFactory();
        factory.setOverloadEnabled(true);

        byte[] bytes = Base64.getDecoder().decode(data);
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Hessian2Input hessian2Input = new Hessian2Input(bis);
        hessian2Input.readObject();
    }
}
